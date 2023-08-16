package com.ktdev.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class SplashActivitiy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activitiy)

        Handler(Looper.getMainLooper()).postDelayed(2500) {
            startActivity(Intent(this@SplashActivitiy,MainActivity::class.java))
            finish()
        }

    }
}