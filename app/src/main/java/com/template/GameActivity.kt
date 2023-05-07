package com.template

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.template.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private var _binding: ActivityGameBinding? = null
    private val binding: ActivityGameBinding
        get() = _binding ?: throw RuntimeException("bind is null")
    private var VALUES = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bets()
        binding.imageButtonBack?.setOnClickListener {
            onBackPressed()
        }

        val images = listOf(
            R.drawable.ico_1,
            R.drawable.ico_2,
            R.drawable.ico_3
        )
        val images2 = listOf(
            R.drawable.ico_4,
            R.drawable.ico_5,
            R.drawable.ico_6,
        )
        val images3 = listOf(
            R.drawable.ico_2,
            R.drawable.ico_7,
            R.drawable.ico_8,
        )

        val images4 = listOf(
            R.drawable.ico_6,
            R.drawable.ico_7,
            R.drawable.ico_8,
            R.drawable.ico_2,
            R.drawable.ico_5,
            R.drawable.ico_1,
        )
        val images5 = listOf(

            R.drawable.ico_3,
            R.drawable.ico_5,
            R.drawable.ico_2,

            R.drawable.ico_1,
            R.drawable.ico_4,
        )
        val images6 = listOf(
            R.drawable.ico_6,

            R.drawable.ico_2,
            R.drawable.ico_5,
            R.drawable.ico_1,

            )
        val images7 = listOf(
            R.drawable.ico_7,
            R.drawable.ico_6,
            R.drawable.ico_3,
            R.drawable.ico_4,
            R.drawable.ico_2,
            R.drawable.ico_5,
            R.drawable.ico_5,
            R.drawable.ico_1,
        )
        val images8 = listOf(
            R.drawable.ico_2,
            R.drawable.ico_6,
            R.drawable.ico_7,
            R.drawable.ico_8,
            R.drawable.ico_3,
            R.drawable.ico_4,

            R.drawable.ico_5,
        )
        val images9 = listOf(
            R.drawable.ico_3,
            R.drawable.ico_4,
            R.drawable.ico_2,
            R.drawable.ico_5,
            R.drawable.ico_5,
            R.drawable.ico_1,
        )

        val imagePager: ViewPager2 = findViewById(R.id.image_pager)
        val imageAdapter = ImagePagerAdapter(images)
        imagePager.adapter = imageAdapter
        val initPosition = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager.setCurrentItem(initPosition, false)
        imagePager.isUserInputEnabled = false


        val imagePager2: ViewPager2 = findViewById(R.id.image_pager2)
        val imageAdapter2 = ImagePagerAdapter(images2)
        imagePager2.adapter = imageAdapter2
        val initPosition2 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager2.setCurrentItem(initPosition2, false)
        imagePager2.isUserInputEnabled = false

        val imagePager3: ViewPager2 = findViewById(R.id.image_pager3)
        val imageAdapter3 = ImagePagerAdapter(images3)
        imagePager3.adapter = imageAdapter3
        val initPosition3 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager3.setCurrentItem(initPosition3, false)
        imagePager3.isUserInputEnabled = false


        val imagePager4: ViewPager2 = findViewById(R.id.image_pager4)
        val imageAdapter4 = ImagePagerAdapter(images4)
        imagePager4.adapter = imageAdapter4
        val initPosition4 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager4.setCurrentItem(initPosition4, false)
        imagePager4.isUserInputEnabled = false

        val imagePager5: ViewPager2 = findViewById(R.id.image_pager5)
        val imageAdapter5 = ImagePagerAdapter(images5)
        imagePager5.adapter = imageAdapter5
        val initPosition5 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager5.setCurrentItem(initPosition5, false)
        imagePager5.isUserInputEnabled = false


        val imagePager6: ViewPager2 = findViewById(R.id.image_pager6)
        val imageAdapter6 = ImagePagerAdapter(images6)
        imagePager6.adapter = imageAdapter6
        val initPosition6 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager6.setCurrentItem(initPosition6, false)
        imagePager6.isUserInputEnabled = false

        val imagePager7: ViewPager2 = findViewById(R.id.image_pager7)
        val imageAdapter7 = ImagePagerAdapter(images7)
        imagePager7.adapter = imageAdapter7
        val initPosition7 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager7.setCurrentItem(initPosition7, false)
        imagePager7.isUserInputEnabled = false

        val imagePager8: ViewPager2 = findViewById(R.id.image_pager8)
        val imageAdapter8 = ImagePagerAdapter(images8)
        imagePager8.adapter = imageAdapter8
        val initPosition8 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager8.setCurrentItem(initPosition8, false)
        imagePager8.isUserInputEnabled = false

        val imagePager9: ViewPager2 = findViewById(R.id.image_pager9)
        val imageAdapter9 = ImagePagerAdapter(images9)
        imagePager9.adapter = imageAdapter9
        val initPosition9 = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 % images.size
        imagePager9.setCurrentItem(initPosition9, false)
        imagePager9.isUserInputEnabled = false


        binding.imageButtonSpin?.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)

            if (VALUES == 0) {
                Toast.makeText(this, "Сначала сделайте ставку", Toast.LENGTH_SHORT).show()
            } else {
                binding.imageButtonSpin!!.isEnabled = false
                binding.buttonPlus?.isEnabled = false
                binding.buttonMinus?.isEnabled = false
                val handler = Handler()
                val runnable = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager.currentItem + 1
                        imagePager.setCurrentItem(nextPosition, true)
                        handler.postDelayed(this, 100L)
                    }
                }
                handler.postDelayed(runnable, 100L)
                handler.postDelayed({
                    handler.removeCallbacks(runnable)
                }, 800L)

                val handler2 = Handler()
                val runnable2 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager2.currentItem + 1
                        imagePager2.setCurrentItem(nextPosition, true)
                        handler2.postDelayed(this, 100L)
                    }
                }
                handler2.postDelayed(runnable2, 100L)
                handler2.postDelayed({
                    handler2.removeCallbacks(runnable2)
                }, 1300L)

                val handler3 = Handler()
                val runnable3 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager3.currentItem + 1
                        imagePager3.setCurrentItem(nextPosition, true)
                        handler3.postDelayed(this, 100L)
                    }
                }
                handler3.postDelayed(runnable3, 100L)
                handler3.postDelayed({
                    handler3.removeCallbacks(runnable3)
                }, 1600L)

                val handler4 = Handler()
                val runnable4 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager4.currentItem + 1
                        imagePager4.setCurrentItem(nextPosition, true)
                        handler4.postDelayed(this, 50L)
                    }
                }
                handler4.postDelayed(runnable4, 100L)
                handler4.postDelayed({
                    handler4.removeCallbacks(runnable4)
                }, 1900L)

                val handler5 = Handler()
                val runnable5 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager5.currentItem + 1
                        imagePager5.setCurrentItem(nextPosition, true)
                        handler5.postDelayed(this, 50L)
                    }
                }
                handler5.postDelayed(runnable5, 100L)
                handler5.postDelayed({
                    handler5.removeCallbacks(runnable5)
                }, 2100L)

                val handler6 = Handler()
                val runnable6 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager6.currentItem + 1
                        imagePager6.setCurrentItem(nextPosition, true)
                        handler6.postDelayed(this, 50L)
                    }
                }
                handler6.postDelayed(runnable6, 100L)
                handler6.postDelayed({
                    handler6.removeCallbacks(runnable6)
                }, 2400L)

                val handler7 = Handler()
                val runnable7 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager7.currentItem + 1
                        imagePager7.setCurrentItem(nextPosition, true)
                        handler7.postDelayed(this, 20L)
                    }
                }
                handler7.postDelayed(runnable7, 100L)
                handler7.postDelayed({
                    handler7.removeCallbacks(runnable7)
                }, 2700L)

                val handler8 = Handler()
                val runnable8 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager8.currentItem + 1
                        imagePager8.setCurrentItem(nextPosition, true)
                        handler8.postDelayed(this, 20L)
                    }
                }
                handler8.postDelayed(runnable8, 30L)
                handler8.postDelayed({
                    handler8.removeCallbacks(runnable8)
                }, 3000L)

                val handler9 = Handler()
                val runnable9 = object : Runnable {
                    override fun run() {
                        val nextPosition = imagePager9.currentItem + 1
                        imagePager9.setCurrentItem(nextPosition, true)
                        handler9.postDelayed(this, 20L)
                    }
                }
                handler9.postDelayed(runnable9, 100L)
                handler9.postDelayed({
                    handler9.removeCallbacks(runnable9)
                    binding.imageButtonSpin?.isEnabled = true
                    binding.buttonPlus?.isEnabled = true
                    binding.buttonMinus?.isEnabled = true
                    binding.imageBet?.isEnabled = true
                    VALUES = 0
                    randomBet()

                }, 3333L)
            }
        }

        binding.imageButtonInfo?.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)
            launchInfoActivity()
        }
    }

    private fun launchInfoActivity() {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
    }

    private fun bets() {
        val tv = binding.betMoney
        val buttonPlus = binding.buttonPlus
        val buttonMinus = binding.buttonMinus
        buttonPlus?.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)
            val currentValue = tv?.text.toString().toInt()
            val newValue = currentValue + 1
            tv?.text = String.format("%02d", newValue)
        }
        buttonMinus?.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)
            val currentValue = tv?.text.toString().toInt()
            if (currentValue > 0) {
                val newValue = currentValue - 1
                tv?.text = String.format("%02d", newValue)
            }
        }
        binding.imageBet?.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)
            preBet()
        }
    }

    private fun looseDialogSettings() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(null)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        val imageViewLoose = ImageView(this)
        imageViewLoose.setImageResource(R.drawable.lose)
        val buttonRetryImageView = ImageView(this)
        buttonRetryImageView.setImageResource(R.drawable.bott_replay)
        layout.addView(imageViewLoose)
        layout.addView(buttonRetryImageView)
        builder.setView(layout)
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)

        dialog.show()
        buttonRetryImageView.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.click_anim)
            it.startAnimation(animation)
            dialog.dismiss()
            restartActivity()
        }
    }

    private fun restartActivity() {
        val intent = intent
        finish()
        startActivity(intent)
    }

    private fun preBet() {


        val betValue = binding.betMoney?.text.toString().toInt()
        val totalValue = binding.totalMoney?.text.toString().toInt()
        if (
            totalValue < betValue
        ) {
            Toast.makeText(this, "Недостаточно монет", Toast.LENGTH_SHORT).show()
        } else if (betValue < 1) {
            Toast.makeText(this, "Ставка монет не может быть меньше 1", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ставка: $betValue", Toast.LENGTH_LONG).show()
            binding.buttonMinus?.isEnabled = false
            binding.buttonPlus?.isEnabled = false
            binding.imageBet?.isEnabled = false
            binding.totalMoney?.text = String.format("%08d", totalValue - betValue)
            VALUES = 1
        }
    }

    private fun randomBet() {
        val betValue = binding.betMoney?.text.toString().toInt()
        val totalValue = binding.totalMoney?.text.toString().toInt()
        when {
            totalValue <= 0 -> {
                looseDialogSettings()
            }
        }
        val randomInt = (2..5).random()
        val randomBoolean = listOf(true, false).random()

        if (randomBoolean) {
            val winning = randomInt * binding.betMoney?.text.toString().toInt()
            binding.totalMoney?.text = String.format("%08d", totalValue + winning)
            Toast.makeText(this, "Выиграно: + $winning монет", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Проиграно: - $betValue монет", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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
