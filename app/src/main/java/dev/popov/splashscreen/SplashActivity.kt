package dev.popov.splashscreen

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.popov.splashscreen.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            binding.progressBar.max = 10000
            val value = 10000
            ObjectAnimator.ofInt(binding.progressBar, "progress", value)
                .setDuration(5000)
                .start()
            delay(5000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}