package com.one.aider.signup.certificate

import androidx.navigation.fragment.findNavController
import com.one.aider.R
import com.one.aider.databinding.FragmentCertificateBinding
import com.one.core.common_ui.base.BaseFragment

class CertificateFragment : BaseFragment<FragmentCertificateBinding>(FragmentCertificateBinding::inflate) {
    override fun onViewCreated() {
        binding.tvCertificateTopropoal.setOnClickListener {
            findNavController().navigate(R.id.action_certificateFragment_to_proposalFragment)
        }
    }

}