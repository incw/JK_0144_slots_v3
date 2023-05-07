package com.template

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.template.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {  // it =  loading screen
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        progress()
        settings()

    }


    @SuppressLint("SetTextI18n")
    private fun progress() {
        val play = binding.playButton
        val progress = binding.progressLoading
        val progressIndicatorTextView = binding.progressBarIndicatorTextView
        play?.isVisible = false
        val progressBar = binding.progressLoading
        progressBar?.max = 100
        progressBar?.progress = 0
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 0..100) {
                runOnUiThread {
                    progressBar?.progress = i
                    progressIndicatorTextView?.text = String.format(i.toString()) + "%"
                }
                delay(20)
                when (i) {
                    100 -> {
                        runOnUiThread {
                            play?.isVisible = true
                            progress?.isVisible = false
                            progressIndicatorTextView?.isVisible = false
                        }
                    }
                }
            }
        }
        play?.setOnClickListener {
            launchGameActivity()
        }
    }

    private fun launchGameActivity() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("AppCompatMethod")
    private fun settings() {
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (isTaskRoot) {
            return
        } else {
            super.onBackPressed()
        }
    }

}