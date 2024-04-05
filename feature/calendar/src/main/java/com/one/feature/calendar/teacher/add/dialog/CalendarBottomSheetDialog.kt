package com.one.feature.calendar.teacher.add.dialog

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.one.core.common_ui.base.BaseBottomSheetDialog
import com.one.feature.calendar.CalendarMonthAdapter
import com.one.feature.calendar.databinding.BottomSheetDialogCalendarBinding

class CalendarBottomSheetDialog: BaseBottomSheetDialog<BottomSheetDialogCalendarBinding>(BottomSheetDialogCalendarBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val monthListManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = CalendarMonthAdapter(true, object: CalendarMonthAdapter.OnSwipeListener {
            override fun onSwipeLeft(position: Int) {
                val targetPos = Math.max(0, position - 1)
                //binding.cbAddCalendart.rvCalendarbase.scrollToPosition(targetPos)
                binding.rvAddCalendart.scrollToPosition(targetPos)
            }

            override fun onSwipeRight(position: Int) {
                val targetPos = Math.min(Int.MAX_VALUE, position + 1)
                //binding.cbAddCalendart.rvCalendarbase.scrollToPosition(targetPos)
                binding.rvAddCalendart.scrollToPosition(targetPos)
            }

        }) { _, _-> }

        /*binding.cbAddCalendart.rvCalendarbase.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }*/
        binding.rvAddCalendart.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }

        val snap = PagerSnapHelper()
        //snap.attachToRecyclerView(binding.cbAddCalendart.rvCalendarbase)
        snap.attachToRecyclerView(binding.rvAddCalendart)
    }
}