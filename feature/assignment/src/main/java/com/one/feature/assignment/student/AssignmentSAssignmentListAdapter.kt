package com.one.feature.assignment.student

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.feature.assignment.databinding.ItemListAssignmentSRecyclerBinding

class AssignmentSAssignmentListAdapter: RecyclerView.Adapter<AssignmentSAssignmentListAdapter.AssignmentSAssignmentListViewHolder>() {
    var assignmentList = arrayListOf<AssignmentListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AssignmentSAssignmentListAdapter.AssignmentSAssignmentListViewHolder {
        val binding = ItemListAssignmentSRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssignmentSAssignmentListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AssignmentSAssignmentListAdapter.AssignmentSAssignmentListViewHolder,
        position: Int
    ) {
        val data = assignmentList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = assignmentList.size

    inner class AssignmentSAssignmentListViewHolder(val binding: ItemListAssignmentSRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AssignmentListData) {
            binding.tvAssignmentListAssignmnetS.text = data.title
        }
    }

}

data class AssignmentListData(
    val title: String
)