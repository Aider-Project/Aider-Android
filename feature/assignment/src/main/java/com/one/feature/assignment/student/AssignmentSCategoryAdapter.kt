package com.one.feature.assignment.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.base.ToggleAnimation
import com.one.feature.assignment.databinding.ItemAssignmentSRecyclerBinding

class AssignmentSCategoryAdapter: RecyclerView.Adapter<AssignmentSCategoryAdapter.AssignmentSCategoryViewHolder>() {
    var assignmentSCategoryList = arrayListOf<AssignmentCategoryData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AssignmentSCategoryViewHolder {
        val binding = ItemAssignmentSRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssignmentSCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = assignmentSCategoryList.size
    override fun onBindViewHolder(holder: AssignmentSCategoryViewHolder, position: Int) {
        val data = assignmentSCategoryList[position]
        holder.bind(data)
    }

    inner class AssignmentSCategoryViewHolder(val binding: ItemAssignmentSRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AssignmentCategoryData) {
            binding.tvCategoryAssignmentS.text = data.category
            binding.tvTeacherNameAssignmentS.text = data.teacherName

            val layoutExpand = binding.linearlayoutAssignmentListAssignmentS
            binding.btnToggleDown.setOnClickListener {
                val show = toggleLayout(
                    !layoutExpand.isVisible,
                    it.findViewById(binding.btnToggleDown.id),
                    layoutExpand
                )
                layoutExpand.isVisible = show
                getAssignmentList()
            }
        }

        private fun getAssignmentList() {
            with(binding) {
                val assignmentListAdapter = AssignmentSAssignmentListAdapter()

                val assignmentList: ArrayList<AssignmentListData> = ArrayList()
                assignmentList.add(AssignmentListData("1단원 문제풀이", "~11.10", "제출 완료"))
                assignmentList.add(AssignmentListData("2단원 심화문제", "~11.17", "제출 완료"))
                assignmentList.add(AssignmentListData("3단원 문제풀이", "~11.24", "제출 전"))
                assignmentList.add(AssignmentListData("3단원 문제풀이", "~11.24", "제출 전"))
                assignmentList.add(AssignmentListData("3단원 문제풀이", "~11.24", "제출 전"))

                rvAssignmentListAssignmentS.adapter = assignmentListAdapter
                rvAssignmentListAssignmentS.layoutManager = LinearLayoutManager(itemView.context)
                assignmentListAdapter.assignmentList = assignmentList
                assignmentListAdapter.notifyDataSetChanged()
            }
        }

        private fun toggleLayout(
            isExpanded: Boolean,
            view: View,
            layoutExpand: LinearLayout
        ): Boolean {
            ToggleAnimation.toggleArrow(view, isExpanded)
            if (isExpanded) ToggleAnimation.expandView(layoutExpand)
            else ToggleAnimation.collapseView(layoutExpand)

            return isExpanded
        }
    }

}

data class AssignmentCategoryData(
    val category: String, // 과목
    val teacherName: String
)

