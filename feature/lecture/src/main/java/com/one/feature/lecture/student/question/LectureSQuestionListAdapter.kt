package com.one.feature.lecture.student.question

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.feature.lecture.databinding.ItemQuestionListLectureSRecyclerBinding

class LectureSQuestionListAdapter : RecyclerView.Adapter<LectureSQuestionListAdapter.LectureSQuestionListViewHolder>() {
    var questionList = arrayListOf<LectureSQuestionListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LectureSQuestionListViewHolder {
        val binding = ItemQuestionListLectureSRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LectureSQuestionListViewHolder(binding)
    }

    override fun getItemCount(): Int = questionList.size

    override fun onBindViewHolder(holder: LectureSQuestionListViewHolder, position: Int) {
        val data = questionList[position]
        holder.bind(data)
    }

    inner class LectureSQuestionListViewHolder(val binding: ItemQuestionListLectureSRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LectureSQuestionListData) {
            binding.tvTitleLectureS.text = data.title
        }
    }
}

data class LectureSQuestionListData(
    val title: String
)