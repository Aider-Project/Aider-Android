package com.one.feature.assignment.student

import androidx.recyclerview.widget.LinearLayoutManager
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.assignment.databinding.FragmentAssginmentSBinding


class AssignmentSFragment : BaseFragment<FragmentAssginmentSBinding>(FragmentAssginmentSBinding::inflate) {
    override fun onViewCreated() {
        initToolbar()
        initRecyclerView()
    }

    private fun initToolbar(){
        binding.toolbarAssignments.initBackKey()
        binding.toolbarAssignments.initTitle("숙제")
    }

    private fun initRecyclerView() {
        with(binding) {
            val assignmentAdapter = AssignmentSCategoryAdapter()

            val categoryList: ArrayList<AssignmentCategoryData> = ArrayList()
            categoryList.add(AssignmentCategoryData("국어", "김민아"))
            categoryList.add(AssignmentCategoryData("수학", "박수민"))
            categoryList.add(AssignmentCategoryData("영어", "김민아"))

            rvAssignmentS.adapter = assignmentAdapter
            rvAssignmentS.layoutManager = LinearLayoutManager(context)
            assignmentAdapter.assignmentSCategoryList = categoryList
            assignmentAdapter.notifyDataSetChanged()
        }
    }

}