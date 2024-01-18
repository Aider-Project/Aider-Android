package com.one.aider.signup.proposal

import android.content.Intent
import com.one.aider.StudentActivity
import com.one.aider.TeacherActivity
import com.one.aider.databinding.FragmentProposalBinding
import com.one.aider.signup.SignUpActivity
import com.one.core.common_ui.base.BaseFragment

class ProposalFragment : BaseFragment<FragmentProposalBinding>(FragmentProposalBinding::inflate) {
    override fun onViewCreated() {
        binding.tvProposalTostudent.setOnClickListener{
            val intent = Intent(requireContext(), StudentActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        binding.tvProposalToteacher.setOnClickListener {
            val intent = Intent(requireContext(), TeacherActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

    }

}