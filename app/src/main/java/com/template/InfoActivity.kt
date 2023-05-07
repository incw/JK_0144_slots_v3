package com.template

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.template.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.buttonBack?.setOnClickListener {
            onBackPressed()
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)
        }
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