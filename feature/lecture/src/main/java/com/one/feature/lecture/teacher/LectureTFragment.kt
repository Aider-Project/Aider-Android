package com.one.feature.lecture.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.one.core.common_ui.base.BaseFragment
import com.one.feature.lecture.R
import com.one.feature.lecture.databinding.FragmentLectureTBinding

class LectureTFragment : BaseFragment<FragmentLectureTBinding>(FragmentLectureTBinding::inflate) {
    lateinit var lectureTAdapter: LectureTAdapter

    override fun onViewCreated() {
        makeTabLayout()
    }

    private fun makeTabLayout() {
        lectureTAdapter = LectureTAdapter(this)

        lectureTAdapter.addFragment(LectureClassFragment())
        lectureTAdapter.addFragment(LectureStudentFragment())

        binding.viewPagerLectureT.adapter = lectureTAdapter
        binding.viewPagerLectureT.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        TabLayoutMediator(binding.tabLayoutLectureT, binding.viewPagerLectureT) { tab, position ->
            when(position) {
                0 -> tab.text = "강의실"
                1 -> tab.text = "학생"
            }
        }.attach()

    }

}