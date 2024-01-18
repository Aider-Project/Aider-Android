package com.one.aider.signup.idpw

import androidx.navigation.fragment.findNavController
import com.one.aider.R
import com.one.aider.databinding.FragmentIdPwBinding
import com.one.core.common_ui.base.BaseFragment

class IdPwFragment : BaseFragment<FragmentIdPwBinding>(FragmentIdPwBinding::inflate) {
    override fun onViewCreated() {
        binding.tvIdpwTorole.setOnAvoidDuplicateClickFlow {
            findNavController().navigate(R.id.action_idPwFragment_to_roleFragment)
        }
    }

}