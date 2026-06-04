package com.mobile.androidpractice

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.androidpractice.databinding.ActivityRandBinding
import kotlin.random.Random
import kotlin.text.append

class RandActivity : AppCompatActivity() {
    val TAG = "RanActivity"
    val binding by lazy { ActivityRandBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRandom.setOnClickListener {
            val random = Random(45)
            var lottery = mutableSetOf<Int>()

            val number : Int = binding.tvRandom.text.toString().toInt() ?: 6
            while (lottery.size < number) {
                var num = Random.nextInt(45)
                lottery.add(num)
            }
            binding.tvRandom.text = lottery.toString()
        }
        binding.btnReset.setOnClickListener {
            binding.tvRandom.text = ""
        }

    }
    fun onDigitClick(view: View) {
        when(view.id) {
            R.id.btn_1 -> binding.tvRandom.append("1")
            R.id.btn_2 -> binding.tvRandom.append("2")
            R.id.btn_3 -> binding.tvRandom.append("3")
            R.id.btn_4 -> binding.tvRandom.append("4")
            R.id.btn_5 -> binding.tvRandom.append("5")
            R.id.btn_6 -> binding.tvRandom.append("6")
            R.id.btn_7 -> binding.tvRandom.append("7")
            R.id.btn_8 -> binding.tvRandom.append("8")
            R.id.btn_9 -> binding.tvRandom.append("9")
        }
    }
}