package com.one.feature.lecture.student

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.lecture.databinding.FragmentLectureSBinding
import com.one.feature.lecture.student.classroom.LectureSClassroomFragment
import com.one.feature.lecture.student.progress.LectureSProgressFragment
import com.one.feature.lecture.student.question.LectureSQuestionFragment

class LectureSFragment : BaseFragment<FragmentLectureSBinding>(FragmentLectureSBinding::inflate) {
    lateinit var lectureSAdapter: LectureSAdapter
    override fun onViewCreated() {
        makeTabLayout()
    }

    private fun makeTabLayout() {
        lectureSAdapter = LectureSAdapter(this)

        lectureSAdapter.addFragment(LectureSClassroomFragment())
        lectureSAdapter.addFragment(LectureSProgressFragment())
        lectureSAdapter.addFragment(LectureSQuestionFragment())

        binding.viewPagerLectureS.adapter = lectureSAdapter
        binding.viewPagerLectureS.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        TabLayoutMediator(binding.tabLayoutLectureS, binding.viewPagerLectureS) { tab, position ->
            when(position) {
                0 -> tab.text = "강의실"
                1 -> tab.text = "진도"
                2 -> tab.text = "문제"
            }
        }.attach()
    }

}