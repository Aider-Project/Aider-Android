package com.one.core.common_ui.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

// BaseFragment에서 사용하는 typealias
typealias DialogFragmentInflate<T> = (LayoutInflater) -> T

abstract class BaseDialogFragment<VB : ViewBinding>(private val inflate: DialogFragmentInflate<VB>) :
    DialogFragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    protected abstract fun onCreateDialog(window: Window?)

    // 다이얼로그가 생성될 때 호출되는 메소드
    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // 다이얼로그 빌더 객체 생성
        val builder = AlertDialog.Builder(requireContext())
        // viewbinding 객체 초기화
        _binding = inflate.invoke(LayoutInflater.from(requireContext()))
        // 빌더에 레이아웃 설정
        builder.setView(binding.root)
        // 빌더로 다이얼로그 객체 생성
        val dialog = builder.create()
        // dialog의 window 객체에 접근
        val window = dialog.window

        // window가 null이 아니면
        window?.let {
            // dialog의 배경을 drawable 리소스 파일로 설정
            it.setBackgroundDrawableResource(com.one.core.common_ui.R.drawable.iv_dialog_background)
        }
        onCreateDialog(window)
        // 다이얼로그 객체 반환
        return dialog
    }

    // 다이얼로그가 파괴될 때 호출되는 메소드
    override fun onDestroyView() {
        super.onDestroyView()
        // viewbinding 객체 해제
        _binding = null
    }
}