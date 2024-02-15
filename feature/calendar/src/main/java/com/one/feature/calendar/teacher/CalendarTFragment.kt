package com.one.feature.calendar.teacher

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.calendar.CalendarMonthAdapter
import com.one.feature.calendar.R
import com.one.feature.calendar.databinding.FragmentCalendarTBinding

class CalendarTFragment :
    BaseFragment<FragmentCalendarTBinding>(FragmentCalendarTBinding::inflate) {
    override fun onViewCreated() {
        val monthListManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = CalendarMonthAdapter(object : CalendarMonthAdapter.OnSwipeListener {
            override fun onSwipeLeft(position: Int) {
                // 왼쪽으로 swipe할 때의 동작을 구현합니다.
                val targetPos = Math.max(0, position - 1)
                binding.cbCalendart.rvCalendarbase.scrollToPosition(targetPos)
            }

            override fun onSwipeRight(position: Int) {
                // 오른쪽으로 swipe할 때의 동작을 구현합니다.
                val targetPos = Math.min(Int.MAX_VALUE, position + 1)
                binding.cbCalendart.rvCalendarbase.scrollToPosition(targetPos)
            }
        }) { month, day ->
            Log.d("whatisthis", "$month $day")
        }

        binding.cbCalendart.rvCalendarbase.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.cbCalendart.rvCalendarbase)

        navigateToAddCalendar()
    }

    private fun navigateToAddCalendar() {
        binding.btnAddCalendart.setOnClickListener {
            findNavController().navigate(R.id.action_calendarTFragment_to_calendarAddFragment)
        }
    }

}