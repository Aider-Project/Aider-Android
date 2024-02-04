package com.one.feature.lecture.student.progress

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.core.common_ui.base.ToggleAnimation
import com.one.feature.lecture.databinding.ItemProgressLectureSRecyclerBinding

class LectureSProgressCategoryAdapter: RecyclerView.Adapter<LectureSProgressCategoryAdapter.LectureSProgressCategoryViewHolder>() {
    var lectureSCategoryList = arrayListOf<LectureSProgressCategoryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureSProgressCategoryViewHolder {
        val binding = ItemProgressLectureSRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LectureSProgressCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = lectureSCategoryList.size

    override fun onBindViewHolder(holder: LectureSProgressCategoryViewHolder, position: Int) {
        val data = lectureSCategoryList[position]
        holder.bind(data)
    }

    inner class LectureSProgressCategoryViewHolder(val binding: ItemProgressLectureSRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LectureSProgressCategoryData) {
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
                getLectureSList()
            }
        }

        private fun getLectureSList() {
            with(binding) {
                val lectureSProgressListAdapter = LectureSProgressListAdapter()

                val lectureSProgressList: ArrayList<LectureSProgressListData> = ArrayList()
                lectureSProgressList.add(LectureSProgressListData("1단원", "~11.10", "~11.12", "잘했어요"))
                lectureSProgressList.add(LectureSProgressListData("1단원", "~11.10", "~11.12", "잘했어요"))
                lectureSProgressList.add(LectureSProgressListData("1단원", "~11.10", "~11.12", "잘했어요"))
                lectureSProgressList.add(LectureSProgressListData("1단원", "~11.10", "~11.12", "잘했어요"))

                rvLectureListLectureS.adapter = lectureSProgressListAdapter
                rvLectureListLectureS.layoutManager = LinearLayoutManager(itemView.context)
                lectureSProgressListAdapter.lectureList = lectureSProgressList
                lectureSProgressListAdapter.notifyDataSetChanged()
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

data class LectureSProgressCategoryData(
    val category: String, // 과목
    val teacherName: String
)