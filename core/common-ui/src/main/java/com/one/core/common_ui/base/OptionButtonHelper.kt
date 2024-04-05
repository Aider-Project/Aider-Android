package com.one.core.common_ui.base

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

/**
 * 라디오 버튼 객체
 *
 * 선택되지 않았을 때 색상과 background는 고정되어 있다. 선택되었을 때 색상과 background만 입력하면 된다.
 *
 * Button 위젯을 쓰지 않고, TextView 위젯을 사용한다.
 */
// 기본 인터페이스 정의
interface OptionButton {
    fun select()
    fun deSelect()
}

// 텍스트 버튼 구현
class TextOptionButton(
    private val textView: TextView,
    private val baseTextColor: Int,
    private val selectedTextColor: Int,
) : OptionButton {

    override fun select() {
        textView.setTextColor(ContextCompat.getColor(textView.context, selectedTextColor))
    }

    override fun deSelect() {
        textView.setTextColor(ContextCompat.getColor(textView.context, baseTextColor))
    }
}

// 이미지 버튼 구현
class ImageOptionButton(
    private val imageView: ImageView,
    private val baseImage: Int,
    private val selectedImage: Int,
) : OptionButton {

    override fun select() {
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, selectedImage))
    }

    override fun deSelect() {
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, baseImage))
    }
}

// 텍스트와 배경 이미지가 있는 버튼 구현
class TextBackgroundOptionButton(
    private val textView: TextView,
    private val baseTextColor: Int,
    private val selectedTextColor: Int,
    private val baseImage: Int,
    private val selectedImage: Int,
) : OptionButton {

    override fun select() {
        textView.setTextColor(ContextCompat.getColor(textView.context, selectedTextColor))
        textView.background = ContextCompat.getDrawable(textView.context, selectedImage)
    }

    override fun deSelect() {
        textView.setTextColor(ContextCompat.getColor(textView.context, baseTextColor))
        textView.background = ContextCompat.getDrawable(textView.context, baseImage)
    }
}

/**
 * Option button helper
 *
 * OptionButton 객체들을 관리하는 클래스
 */
class OptionButtonHelper {
    private var buttons: MutableMap<Int, OptionButton>? = null
    private var selected: Int? = null

    init {
        buttons = mutableMapOf()
    }

    // 라디오 버튼 목록에 버튼 등록 메서드
    fun registerButton(optionInfo: Int, button: OptionButton) {
        buttons?.set(optionInfo, button)
    }

    // 버튼 목록 중 버튼을 선택했을 때
    fun selectButton(optionInfo: Int) {
        if (buttons?.contains(optionInfo) == true) { // 등록된 버튼인지 확인
            selected?.let { buttons?.get(it)?.deSelect() }
            buttons?.get(optionInfo)?.select()
            selected = optionInfo // 선택된 버튼 정보 갱신
        }
    }

    fun deleteButton(optionInfo: Int) {
        if (buttons?.contains(optionInfo) == true) { // 등록된 버튼인지 확인
            buttons?.remove(optionInfo) // 버튼 목록에서 삭제
            if (selected == optionInfo) { // 삭제된 버튼이 선택된 버튼이라면
                selected = null // 선택된 버튼 정보 초기화
            }
        }
    }

    fun removeRadioButtonHelper() {
        buttons?.clear() // 버튼 목록을 비움
        buttons = null
        selected = null // 선택된 버튼 정보 초기화
    }
}