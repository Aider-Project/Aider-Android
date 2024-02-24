package com.one.feature.lecture.teacher.classroom

import com.one.core.common_ui.base.BaseFragment
import com.one.feature.lecture.databinding.FragmentLectureClassBinding

class LectureTClassroomFragment :
    BaseFragment<FragmentLectureClassBinding>(FragmentLectureClassBinding::inflate) {
    override fun onViewCreated() {
        binding.tvLectureclassAddclassroom.setOnAvoidDuplicateClickFlow {
            // 커스텀 다이얼로그 객체 생성
            val customDialog = AddClassroomDialogFragment()
            // 다이얼로그를 프래그먼트 매니저에 추가
            customDialog.show(requireActivity().supportFragmentManager, "customDialog")
        }
    }


}