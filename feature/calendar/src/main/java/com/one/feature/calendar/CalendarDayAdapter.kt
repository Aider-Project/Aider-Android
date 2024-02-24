package com.one.feature.calendar

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.databinding.ItemCalendarbaseDayBinding
import java.util.Calendar
import java.util.Date

class CalendarDayAdapter(
    val ROW : Int,     // 한 달을 표현하는 행의 수
    val tempMonth: Int,
    val dayList: MutableList<Date>,
    val clickListener: (Int, Int) -> Unit,
) : RecyclerView.Adapter<CalendarDayAdapter.DayView>() {

    // 각 날짜를 표현하는 ViewHolder 클래스
    inner class DayView(val binding: ItemCalendarbaseDayBinding) :
        RecyclerView.ViewHolder(binding.root)

    // ViewHolder를 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        // View Binding을 사용하여 뷰를 생성
        val binding =
            ItemCalendarbaseDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayView(binding)
    }

    // ViewHolder에 데이터를 바인딩하는 함수
    override fun onBindViewHolder(holder: DayView, position: Int) {
        // Calendar 인스턴스를 생성하고, Date 객체를 설정
        val calendar = Calendar.getInstance()
        calendar.time = dayList[position]

        // Calendar.DAY_OF_MONTH 필드를 사용하여 일 정보를 가져옴
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        // Calendar.MONTH 필드를 사용하여 월 정보를 가져옴
        val month = calendar.get(Calendar.MONTH)

        // TextView에 날짜를 표시
        holder.binding.tvCalendarbaseitemdayDate.text = day.toString()

        // 요일에 따라 텍스트 색상을 설정
        holder.binding.tvCalendarbaseitemdayDate.setTextColor(
            when (position % 7) {
                0 -> Color.RED // 일요일은 빨간색
                6 -> Color.BLUE // 토요일은 파란색
                else -> Color.BLACK // 평일은 검은색
            }
        )

        // 다른 달의 날짜는 투명도를 낮춤
        if (tempMonth != month) {
            holder.binding.tvCalendarbaseitemdayDate.alpha = 0.4f
        }

        // 날짜를 클릭하면 Toast 메시지를 표시
        holder.binding.layoutCalendarbaseitemdayDay.setOnClickListener {
            if (tempMonth == month) {
                clickListener(month+1, day)
            }
        }
    }

    // Adapter가 표시할 아이템의 개수를 반환하는 함수
    override fun getItemCount(): Int {
        return ROW * 7
    }
}
