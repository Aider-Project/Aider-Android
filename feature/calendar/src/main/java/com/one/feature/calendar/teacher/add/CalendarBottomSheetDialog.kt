package com.one.feature.calendar.teacher.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.one.feature.calendar.databinding.BottomSheetDialogCalendarBinding

class CalendarBottomSheetDialog: BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetDialogCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetDialogCalendarBinding.inflate(layoutInflater)

        return binding.root
    }
}