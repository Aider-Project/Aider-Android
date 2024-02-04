package com.one.feature.assignment.teacher.detail

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.assignment.databinding.FragmentDetailQuestionBinding

class DetailQuestionFragment : BaseFragment<FragmentDetailQuestionBinding>(FragmentDetailQuestionBinding::inflate) {
    override fun onViewCreated() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            val categoryAdapter = DetailQuestionCategoryAdapter()

            val categoryList: ArrayList<DetailQuestionCategoryData> = ArrayList()
            categoryList.add(DetailQuestionCategoryData("국어", "김민아"))
            categoryList.add(DetailQuestionCategoryData("국어", "김민아"))
            categoryList.add(DetailQuestionCategoryData("국어", "김민아"))
            categoryList.add(DetailQuestionCategoryData("국어", "김민아"))

            rvAssignmentT.adapter = categoryAdapter
            rvAssignmentT.layoutManager = LinearLayoutManager(context)
            categoryAdapter.questionCategoryList = categoryList
            categoryAdapter.notifyDataSetChanged()
        }
    }
}