package com.mobile.androidpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.androidpractice.databinding.ActivityBmiBinding
import kotlin.toString

class BmiActivity : AppCompatActivity() {
    val TAG = "BmiActivity"
    val binding by lazy { ActivityBmiBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnBMI.setOnClickListener {
            val h = binding.etHeight.text.toString().toFloat() / 100.0
            val w = binding.etWeight.text.toString().toFloat()

            val result = w / (h * h)

            Log.i(TAG, "h: $h w: $w result: $result")

            binding.tvBMI.text = String.format("%.2f",result)
        }
    }
}