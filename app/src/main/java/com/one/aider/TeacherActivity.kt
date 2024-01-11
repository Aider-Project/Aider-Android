package com.one.aider

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.one.aider.databinding.ActivityTeacherBinding
import com.one.core.common_ui.base.BaseActivity

class TeacherActivity : BaseActivity<ActivityTeacherBinding>(ActivityTeacherBinding::inflate) {
    override fun onCreate() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_teacher) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.btnv_teacher)
        bottomNavigationView.setItemIconTintList(null) // Tint 초기화

        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}