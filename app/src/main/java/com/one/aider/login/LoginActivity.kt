package com.one.aider.login

import android.content.Intent
import com.one.aider.StudentActivity
import com.one.aider.TeacherActivity
import com.one.aider.databinding.ActivityLoginBinding
import com.one.aider.signup.SignUpActivity
import com.one.core.common_ui.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate() {

        binding.tvLoginSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.tvLoginStudent.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            startActivity(intent)
        }

        binding.tvLoginTeacher.setOnClickListener {
            val intent = Intent(this, TeacherActivity::class.java)
            startActivity(intent)
        }

    }

}