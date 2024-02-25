package com.one.feature.calendar.teacher.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.one.core.common_ui.base.BaseBottomSheetDialog
import com.one.feature.calendar.CalendarMonthAdapter
import com.one.feature.calendar.databinding.BottomSheetDialogCalendarBinding

class CalendarBottomSheetDialog: BaseBottomSheetDialog<BottomSheetDialogCalendarBinding>(BottomSheetDialogCalendarBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val monthListManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = CalendarMonthAdapter(object: CalendarMonthAdapter.OnSwipeListener {
            override fun onSwipeLeft(position: Int) {
                val targetPos = Math.max(0, position - 1)
                binding.cbAddCalendart.rvCalendarbase.scrollToPosition(targetPos)
            }

            override fun onSwipeRight(position: Int) {
                val targetPos = Math.min(Int.MAX_VALUE, position + 1)
                binding.cbAddCalendart.rvCalendarbase.scrollToPosition(targetPos)
            }

        }) { _, _ -> }

        binding.cbAddCalendart.rvCalendarbase.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }

        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.cbAddCalendart.rvCalendarbase)
    }
}