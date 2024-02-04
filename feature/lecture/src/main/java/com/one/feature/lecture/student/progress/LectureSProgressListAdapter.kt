package com.one.feature.lecture.student.progress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.feature.lecture.databinding.ItemProgressListLectureSRecyclerBinding

class LectureSProgressListAdapter : RecyclerView.Adapter<LectureSProgressListAdapter.LectureSProgressListViewHolder>(){
    var lectureList = arrayListOf<LectureSProgressListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureSProgressListViewHolder {
        val binding = ItemProgressListLectureSRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LectureSProgressListViewHolder(binding)
    }

    override fun getItemCount(): Int = lectureList.size

    override fun onBindViewHolder(holder: LectureSProgressListViewHolder, position: Int) {
        val data = lectureList[position]
        holder.bind(data)
    }

    inner class LectureSProgressListViewHolder(val binding: ItemProgressListLectureSRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LectureSProgressListData) {
            binding.tvItemUnitLectureS.text = data.unit
            binding.tvItemExpectDayLectureS.text = data.expectDay
            binding.tvItemActualDayLectureS.text = data.actualDay
            binding.tvItemStatusLectureS.text = data.status
        }
    }
}

data class LectureSProgressListData(
    val unit: String,
    val expectDay: String,
    val actualDay: String,
    val status: String
)