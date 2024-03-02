package com.one.core.common_ui.base

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.one.core.common_ui.R

/**
 * 라디오 버튼 객체
 *
 * 선택되지 않았을 때 색상과 background는 고정되어 있다. 선택되었을 때 색상과 background만 입력하면 된다.
 *
 * Button 위젯을 쓰지 않고, TextView 위젯을 사용한다.
 */
class OptionButton(
    private val textView: TextView,
    private val selectedTextColor: Int,
    private val selectedBackground: Int,
) {
    fun select() { // 버튼이 클릭 되었을 때 색상 변경 메서드
        textView.setTextColor(ContextCompat.getColor(textView.context, selectedTextColor))
        textView.background = (ContextCompat.getDrawable(textView.context, selectedBackground))
    }

    fun deselect() { // 다른 버튼이 클릭 되었을 때 색상 변경 메서드
        textView.setTextColor(ContextCompat.getColor(textView.context, R.color.bg60))
        textView.background =
            (ContextCompat.getDrawable(textView.context, R.drawable.iv_bt_background_grayline))
    }

    fun reset(selectedColor: Int, selectedBackground: Int) { // 선택 색상 정보를 재 설정하는 메서드
        textView.setTextColor(selectedColor)
        textView.background = (ContextCompat.getDrawable(textView.context, selectedBackground))
    }
}

/**
 * Option button helper
 *
 * OptionButton 객체들을 관리하는 클래스
 */
class OptionButtonHelper {
    private val buttons = mutableMapOf<String, OptionButton>()
    private var selected: String? = null

    // 라디오 버튼 목록에 버튼 등록 메서드
    fun registerButton(option: String, button: OptionButton) {
        buttons[option] = button
    }

    // 버튼 목록 중 버튼을 선택했을 때
    fun selectButton(option: String) {
        if (buttons.contains(option)) { // 등록된 버튼인지 확인
            selected?.let { buttons[it]?.deselect() }
            buttons[option]?.select()
            selected = option // 선택된 버튼 정보 갱신
        }
    }

    fun deleteButton(option: String) {
        if (buttons.contains(option)) { // 등록된 버튼인지 확인
            buttons.remove(option) // 버튼 목록에서 삭제
            if (selected == option) { // 삭제된 버튼이 선택된 버튼이라면
                selected = null // 선택된 버튼 정보 초기화
            }
        }
    }

    fun removeRadioButtonHelper() {
        buttons.clear() // 버튼 목록을 비움
        selected = null // 선택된 버튼 정보 초기화
    }
}