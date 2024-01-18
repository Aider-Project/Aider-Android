package com.one.feature.assignment.student

import com.one.core.common_ui.base.BaseFragment
import com.one.feature.assignment.databinding.FragmentAssginmentSBinding


class AssignmentSFragment : BaseFragment<FragmentAssginmentSBinding>(FragmentAssginmentSBinding::inflate) {
    override fun onViewCreated() {
        initToolbar()
    }

    private fun initToolbar(){
        binding.toolbarAssignments.initBackKey()
        binding.toolbarAssignments.initTitle("숙제")
    }

}