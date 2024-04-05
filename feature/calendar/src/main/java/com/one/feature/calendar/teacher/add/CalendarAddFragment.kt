package com.one.feature.calendar.teacher.add

import androidx.fragment.app.DialogFragment
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.calendar.R
import com.one.feature.calendar.databinding.FragmentCalendarAddBinding
import com.one.feature.calendar.teacher.add.dialog.CalendarBottomSheetDialog

class CalendarAddFragment : BaseFragment<FragmentCalendarAddBinding>(FragmentCalendarAddBinding::inflate) {

    override fun onViewCreated() {
        initToolbar()

        binding.btnShowCalendart.setOnClickListener {
            showCalendar()
        }
    }

    private fun initToolbar() {
        binding.toolbarAssignments.initBackKey()
        binding.toolbarAssignments.initTitle("일정 추가")
    }

    private fun showCalendar() {
        val bottomSheetDialog = CalendarBottomSheetDialog()
        bottomSheetDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
        bottomSheetDialog.show(parentFragmentManager, bottomSheetDialog.tag)
    }
}