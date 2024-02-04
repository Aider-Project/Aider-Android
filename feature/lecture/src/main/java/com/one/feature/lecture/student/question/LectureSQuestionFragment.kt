package com.one.feature.lecture.student.question

import androidx.recyclerview.widget.LinearLayoutManager
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.lecture.databinding.FragmentLectureSQuestionBinding

class LectureSQuestionFragment : BaseFragment<FragmentLectureSQuestionBinding>(FragmentLectureSQuestionBinding::inflate) {
    override fun onViewCreated() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            val categoryAdapter = LectureSQuestionCategoryAdapter()

            val categoryList: ArrayList<LectureSQuestionCategoryData> = ArrayList()
            categoryList.add(LectureSQuestionCategoryData("국어", "김민아"))
            categoryList.add(LectureSQuestionCategoryData("국어", "김민아"))
            categoryList.add(LectureSQuestionCategoryData("국어", "김민아"))

            rvLectureS.adapter = categoryAdapter
            rvLectureS.layoutManager = LinearLayoutManager(context)
            categoryAdapter.questionCategoryList = categoryList
            categoryAdapter.notifyDataSetChanged()
        }
    }

}