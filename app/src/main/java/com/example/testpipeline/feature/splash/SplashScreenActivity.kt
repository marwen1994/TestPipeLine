package com.example.testpipeline.feature.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testpipeline.databinding.ActivitySplashScreenBinding
import com.example.testpipeline.feature.food.MainActivity
import com.example.testpipeline.feature.login.LoginRegisterActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.Main).launch {
            delay(DELAY)
            startActivity(Intent(this@SplashScreenActivity, LoginRegisterActivity::class.java))
            finish()
        }
    }
    companion object {
        const val DELAY = 3000L
    }
}