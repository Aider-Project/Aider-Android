package com.one.core.common_ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

typealias BottomSheetDialogInflate<T> = (LayoutInflater) -> T
abstract class BaseBottomSheetDialog<VB: ViewBinding>(
    private val inflate: BottomSheetDialogInflate<VB>) : BottomSheetDialogFragment(){
    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(LayoutInflater.from(requireContext()))
        return binding.root
    }

    // dialog 파괴시
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}