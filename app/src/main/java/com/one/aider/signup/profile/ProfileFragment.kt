package com.one.aider.signup.profile

import androidx.navigation.fragment.findNavController
import com.one.aider.R
import com.one.aider.databinding.FragmentProfileBinding
import com.one.core.common_ui.base.BaseFragment


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override fun onViewCreated() {
        binding.tvProfileToidpw.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_idPwFragment)
        }
    }

}