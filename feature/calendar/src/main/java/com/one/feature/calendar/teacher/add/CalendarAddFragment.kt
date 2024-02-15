package com.one.feature.calendar.teacher.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.calendar.R
import com.one.feature.calendar.databinding.FragmentCalendarAddBinding

class CalendarAddFragment : BaseFragment<FragmentCalendarAddBinding>(FragmentCalendarAddBinding::inflate) {
    override fun onViewCreated() {
        initToolbar()
    }

    private fun initToolbar() {
        binding.toolbarAssignments.initBackKey()
        binding.toolbarAssignments.initTitle("일정 추가")
    }
}