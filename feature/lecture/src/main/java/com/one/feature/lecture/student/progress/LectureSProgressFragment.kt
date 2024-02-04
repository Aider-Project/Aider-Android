package com.one.feature.lecture.student.progress

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.lecture.databinding.FragmentLectureSProgressBinding

class LectureSProgressFragment : BaseFragment<FragmentLectureSProgressBinding>(FragmentLectureSProgressBinding::inflate) {
    override fun onViewCreated() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            val lectureSProgressAdapter = LectureSProgressCategoryAdapter()

            val categoryList: ArrayList<LectureSCategoryData> = ArrayList()
            categoryList.add(LectureSCategoryData("국어", "김민아"))
            categoryList.add(LectureSCategoryData("수학", "박수민"))
            categoryList.add(LectureSCategoryData("영어", "김민아"))

            rvLectureS.adapter = lectureSProgressAdapter
            rvLectureS.layoutManager = LinearLayoutManager(context)
            lectureSProgressAdapter.lectureSCategoryList = categoryList
            lectureSProgressAdapter.notifyDataSetChanged()
        }
    }

}