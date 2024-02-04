package com.one.feature.assignment.teacher.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.feature.assignment.databinding.ItemDetailQuestionListAssignmentTRecyclerBinding

class DetailQuestionListAdapter : RecyclerView.Adapter<DetailQuestionListAdapter.DetailQuestionListViewHolder>(){
    var questionList = arrayListOf<DetailQuestionListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailQuestionListAdapter.DetailQuestionListViewHolder {
        val binding = ItemDetailQuestionListAssignmentTRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailQuestionListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DetailQuestionListAdapter.DetailQuestionListViewHolder,
        position: Int
    ) {
        val data = questionList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = questionList.size

    inner class DetailQuestionListViewHolder(val binding: ItemDetailQuestionListAssignmentTRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DetailQuestionListData) {
            binding.tvItemUnitAssignmentT.text = data.unit
            binding.tvItemExpectDayAssignmentT.text = data.expectDay
            binding.tvItemActualDayAssignmentT.text = data.actualDay
            binding.tvItemStatusAssignmentT.text = data.status
        }
    }
}

data class DetailQuestionListData(
    val unit: String,
    val expectDay: String,
    val actualDay: String,
    val status: String
)