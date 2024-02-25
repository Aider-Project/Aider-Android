package com.one.feature.lecture.teacher.classroom

import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import com.one.core.common_ui.base.BaseDialogFragment
import com.one.feature.lecture.databinding.DialogFragmentAddClassroomBinding

class AddClassroomDialogFragment :
    BaseDialogFragment<DialogFragmentAddClassroomBinding>(DialogFragmentAddClassroomBinding::inflate) {

    /**
     * On create dialog
     *
     * @param window
     */
    override fun onCreateDialog(window: Window?) {
        // window가 null이 아니면
        window?.let {
            showKeyboard(it, binding.edittvAddclassroomName)
        }
    }

    // Context 객체를 파라미터로 전달하는 경우
    fun showKeyboard(window: Window, editText: EditText) {
        // EditText에 포커스를 줍니다.
        editText.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

}

//class AddClassroomDialogFragment : DialogFragment() {
//    // viewbinding 객체 선언
//    private var _binding: DialogFragmentAddClassroomBinding? = null
//
//    // viewbinding 객체의 참조를 얻기 위한 프로퍼티
//    private val binding get() = _binding!!
//
//
//    // 다이얼로그가 생성될 때 호출되는 메소드
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        // 다이얼로그 빌더 객체 생성
//        val builder = AlertDialog.Builder(requireContext())
//        // viewbinding 객체 초기화
//        _binding = DialogFragmentAddClassroomBinding.inflate(LayoutInflater.from(requireContext()))
//        // 빌더에 레이아웃 설정
//        builder.setView(binding.root)
//        // 빌더로 다이얼로그 객체 생성
//        val dialog = builder.create()
//        // dialog의 window 객체에 접근
//        val window = dialog.window
//        // window가 null이 아니면
//        window?.let {
//            // dialog의 배경을 drawable 리소스 파일로 설정
//            it.setBackgroundDrawableResource(com.one.core.common_ui.R.drawable.iv_dialog_background)
//        }
//        //
//
//        // 다이얼로그 객체 반환
//        return dialog
//    }
//
//    // 다이얼로그가 파괴될 때 호출되는 메소드
//    override fun onDestroyView() {
//        super.onDestroyView()
//        // viewbinding 객체 해제
//        _binding = null
//    }
//}