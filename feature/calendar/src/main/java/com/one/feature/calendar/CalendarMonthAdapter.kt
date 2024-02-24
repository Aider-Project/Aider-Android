package com.one.feature.calendar

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.databinding.ItemCalendarbaseMonthBinding
import java.util.Calendar
import java.util.Date

class CalendarMonthAdapter(
    var onSwipeListener: OnSwipeListener,
    val clickListener: (Int, Int) -> Unit,
) : RecyclerView.Adapter<CalendarMonthAdapter.MonthView>() {
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
        // 오늘 날짜가 2024년 2월 9일이라면, calendar 변수의 날짜는 2024년 2월 1일이 됨
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MONTH, position - center)

        with(holder) {
            binding.tvCalendarbaseitemmonthMonth.text =
                "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
            Log.d("whatisthis", "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월")
            val tempMonth = calendar.get(Calendar.MONTH)

            val lastDayCalendar = Calendar.getInstance()
            var weekOfMonth: Int = 0
            // 해당 월의 마지막 날짜를 얻기 위한 Calendar 인스턴스를 생성
            lastDayCalendar.time = calendar.time // 현재 calendar의 시간을 lastDayCalendar로 복사
            lastDayCalendar.set(
                Calendar.DAY_OF_MONTH, lastDayCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            ) // 해당 월의 마지막 날짜로 설정

            // 해당 월의 마지막 날짜가 포함된 주가 그 달의 몇 번째 주인지 계산
            weekOfMonth = lastDayCalendar.get(Calendar.WEEK_OF_MONTH)

            var dayList: MutableList<Date> = MutableList(weekOfMonth * 7) { Date() } // 5행 * 7일
            for (i in 0 until weekOfMonth) { // 5행만큼 반복
                // 주의 시작을 일요일로 고정
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
                for (k in 0 until 7) { // 일주일은 7일
                    dayList[i * 7 + k] = calendar.time
                    // 날짜를 하루씩 증가
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }
            }

            val dayListManager = GridLayoutManager(holder.binding.root.context, 7)
            val dayListAdapter = CalendarDayAdapter(weekOfMonth, tempMonth, dayList) { month, day ->
                clickListener(month, day)
            }

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