package com.one.feature.assignment.teacher.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.base.ToggleAnimation
import com.one.feature.assignment.databinding.ItemDetailQuestionCategoryAssignmentTRecyclerBinding

class DetailQuestionCategoryAdapter : RecyclerView.Adapter<DetailQuestionCategoryAdapter.DetailQuestionCategoryViewHolder>(){
    var questionCategoryList = arrayListOf<DetailQuestionCategoryData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailQuestionCategoryAdapter.DetailQuestionCategoryViewHolder {
        val binding = ItemDetailQuestionCategoryAssignmentTRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailQuestionCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DetailQuestionCategoryAdapter.DetailQuestionCategoryViewHolder,
        position: Int
    ) {
        val data = questionCategoryList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = questionCategoryList.size

    inner class DetailQuestionCategoryViewHolder(val binding: ItemDetailQuestionCategoryAssignmentTRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DetailQuestionCategoryData) {
            binding.tvCategoryAssignmentT.text = data.category
            binding.tvTeacherNameAssignmentT.text = data.teacherName

            val layoutExpand = binding.linearLayoutAssignmentListItems
            binding.btnToggleDown.setOnClickListener {
                val show = toggleLayout(
                    !layoutExpand.isVisible,
                    it.findViewById(binding.btnToggleDown.id),
                    layoutExpand
                )
                layoutExpand.isVisible = show
                getQuestionList()
            }
        }

        private fun getQuestionList() {
            with(binding) {
                val questionListAdapter = DetailQuestionListAdapter()

                val questionList: ArrayList<DetailQuestionListData> = ArrayList()
                questionList.add(DetailQuestionListData("1단원", "~11.10", "~11.12", "잘했어요"))
                questionList.add(DetailQuestionListData("1단원", "~11.10", "~11.12", "잘했어요"))
                questionList.add(DetailQuestionListData("1단원", "~11.10", "~11.12", "잘했어요"))
                questionList.add(DetailQuestionListData("1단원", "~11.10", "~11.12", "잘했어요"))

                rvLectureListLectureS.adapter = questionListAdapter
                rvLectureListLectureS.layoutManager = LinearLayoutManager(itemView.context)
                questionListAdapter.questionList = questionList
                questionListAdapter.notifyDataSetChanged()
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

data class DetailQuestionCategoryData(
    val category: String,
    val teacherName: String
)