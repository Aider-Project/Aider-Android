package com.one.feature.lecture.student

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LectureSAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var fragments: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    fun removeFragment(fragment: Fragment) {
        fragments.remove(fragment)
        notifyItemRemoved(fragments.size)
    }
}