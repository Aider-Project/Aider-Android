package com.one.aider

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.one.aider.databinding.ActivityStudentBinding
import com.one.core.common_ui.base.BaseActivity

class StudentActivity : BaseActivity<ActivityStudentBinding>(ActivityStudentBinding::inflate) {
    override fun onCreate() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_student) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.btnv_student)
        bottomNavigationView.setItemIconTintList(null) // Tint 초기화

        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}