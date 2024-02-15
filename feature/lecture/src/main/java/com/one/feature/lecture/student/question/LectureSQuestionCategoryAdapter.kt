package com.one.feature.lecture.student.question

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.base.ToggleAnimation
import com.one.feature.lecture.databinding.ItemQuestionLectureSRecyclerBinding

class LectureSQuestionCategoryAdapter : RecyclerView.Adapter<LectureSQuestionCategoryAdapter.LectureSQuestionCategoryViewHolder>(){
    var questionCategoryList = arrayListOf<LectureSQuestionCategoryData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LectureSQuestionCategoryViewHolder {
        val binding = ItemQuestionLectureSRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LectureSQuestionCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = questionCategoryList.size

    override fun onBindViewHolder(holder: LectureSQuestionCategoryViewHolder, position: Int) {
        val data = questionCategoryList[position]
        holder.bind(data)
    }

    inner class LectureSQuestionCategoryViewHolder(val binding: ItemQuestionLectureSRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LectureSQuestionCategoryData) {
            binding.tvCategoryLectureS.text = data.category
            binding.tvTeacherNameLectureS.text = data.teacherName

            val layoutExpand = binding.linearlayoutLectureListLectureS
            binding.btnToggleDown.setOnClickListener {
                val show = toggleLayout(
                    !layoutExpand.isVisible,
                    it.findViewById(binding.btnToggleDown.id),
                    layoutExpand
                )
                layoutExpand.isVisible = show
                getCategorySList()
            }
        }

        private fun getCategorySList() {
            with(binding) {
                val lectureSQuestionListAdapter = LectureSQuestionListAdapter()

                val lectureSQuestionList: ArrayList<LectureSQuestionListData> = ArrayList()
                lectureSQuestionList.add(LectureSQuestionListData("1단원.pdf"))
                lectureSQuestionList.add(LectureSQuestionListData("1단원.pdf"))
                lectureSQuestionList.add(LectureSQuestionListData("1단원.pdf"))
                lectureSQuestionList.add(LectureSQuestionListData("1단원.pdf"))

                rvLectureListLectureS.adapter = lectureSQuestionListAdapter
                rvLectureListLectureS.layoutManager = LinearLayoutManager(itemView.context)
                lectureSQuestionListAdapter.questionList = lectureSQuestionList
                lectureSQuestionListAdapter.notifyDataSetChanged()
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

data class LectureSQuestionCategoryData(
    val category: String,
    val teacherName: String
)