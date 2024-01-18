package com.one.aider.signup.role

import androidx.navigation.fragment.findNavController
import com.one.aider.R
import com.one.aider.databinding.FragmentRoleBinding
import com.one.core.common_ui.base.BaseFragment

class RoleFragment : BaseFragment<FragmentRoleBinding>(FragmentRoleBinding::inflate) {
    override fun onViewCreated() {
        binding.tvRoleTocertificate.setOnClickListener {
            findNavController().navigate(R.id.action_roleFragment_to_certificateFragment)
        }
    }

}