package com.one.feature.calendar.student

import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.calendar.CalendarMonthAdapter
import com.one.feature.calendar.databinding.FragmentCalendarSBinding

class CalendarSFragment :
    BaseFragment<FragmentCalendarSBinding>(FragmentCalendarSBinding::inflate) {
    override fun onViewCreated() {
        val monthListManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = CalendarMonthAdapter(object : CalendarMonthAdapter.OnSwipeListener {
            override fun onSwipeLeft(position: Int) {
                // 왼쪽으로 swipe할 때의 동작을 구현합니다.
                val targetPos = Math.max(0, position - 1)
                binding.rvCalendars.scrollToPosition(targetPos)
                binding.layoutCalendarsCalendar.invalidate()
            }

            override fun onSwipeRight(position: Int) {
                // 오른쪽으로 swipe할 때의 동작을 구현합니다.
                val targetPos = Math.min(Int.MAX_VALUE, position + 1)
                binding.rvCalendars.scrollToPosition(targetPos)
                binding.layoutCalendarsCalendar.invalidate()
            }
        }) { month, day ->
            Log.d("whatisthis", "$month $day")
        }

        binding.rvCalendars.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)

//            addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//                    binding.layoutCalendarsCalendar.invalidate()
//                }
//                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                    super.onScrollStateChanged(recyclerView, newState)
//                    if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING) {
//                        binding.layoutCalendarsCalendar.requestLayout()
//                    }
//                }
//            })
        }
        binding.rvCalendars.setOnTouchListener { v, event ->
            return@setOnTouchListener event.actionMasked == MotionEvent.ACTION_MOVE
        }
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.rvCalendars)
    }

}