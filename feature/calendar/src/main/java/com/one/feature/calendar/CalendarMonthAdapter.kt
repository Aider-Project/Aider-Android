package com.one.feature.calendar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.databinding.ItemCalendarbaseMonthBinding
import java.util.Calendar
import java.util.Date

class CalendarMonthAdapter(var onSwipeListener: OnSwipeListener) :
    RecyclerView.Adapter<CalendarMonthAdapter.MonthView>() {
    val center = Int.MAX_VALUE / 2
    private var calendar = Calendar.getInstance()

    interface OnSwipeListener {
        fun onSwipeLeft(position: Int)
        fun onSwipeRight(position: Int)
    }

    inner class MonthView(val binding: ItemCalendarbaseMonthBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthView {
        // View Binding을 사용하여 뷰를 생성
        val binding =
            ItemCalendarbaseMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthView(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MonthView, position: Int) {
        calendar.time = Date() // 오늘 날짜
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MONTH, position - center)

        with(holder) {
            binding.tvCalendarbaseitemmonthMonth.text =
                "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
            val tempMonth = calendar.get(Calendar.MONTH)

            var dayList: MutableList<Date> = MutableList(5 * 7) { Date() } // 5행 * 7일
            for (i in 0 until 5) { // 5행만큼 반복
                // 주의 시작을 일요일로 고정
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
                for (k in 0 until 7) { // 일주일은 7일
                    dayList[i * 7 + k] = calendar.time
                    // 날짜를 하루씩 증가
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }
            }

            val dayListManager = GridLayoutManager(holder.binding.root.context, 7)
            val dayListAdapter = CalendarDayAdapter(tempMonth, dayList)

            binding.rvCalendarbaseitemmonthDays.apply {
                layoutManager = dayListManager
                adapter = dayListAdapter
            }

            binding.ivCalendarbaseitemmonthLeft.setOnClickListener {
                onSwipeListener.onSwipeLeft(holder.layoutPosition)
            }
            binding.ivCalendarbaseitemmonthRight.setOnClickListener {
                onSwipeListener.onSwipeRight(holder.layoutPosition)
            }
        }

    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}