package com.mobile.androidpractice

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.androidpractice.databinding.ActivityMainBinding
import kotlin.collections.minusAssign
import kotlin.collections.plusAssign

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

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
            val intent : Intent = Intent(this, BmiActivity::class.java)
            startActivity(intent)
        }
        binding.btnRandom.setOnClickListener {
            val intent : Intent = Intent(this, RandActivity::class.java)
            startActivity(intent)
        }

        registerForContextMenu(binding.customView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_size, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.item_bigger -> {
                binding.customView.radius += 10.0f
                binding.customView.invalidate()
                true
            }

            R.id.item_smaller -> {
                binding.customView.radius -= 10.0f
                binding.customView.invalidate()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateContextMenu( // 매번 생성
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu_color, menu)
        /*메뉴항목 체크상태 활성화*/
        when (circleColor) {
            0 -> menu?.findItem(R.id.item_red)?.isChecked = true
            1 -> menu?.findItem(R.id.item_green)?.isChecked = true
            2 -> menu?.findItem(R.id.item_blue)?.isChecked = true

        }
        return super.onCreateContextMenu(menu, v, menuInfo)
    }

    var circleColor = 0
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_red -> {
                circleColor = 0
                binding.customView.color = Color.RED
                binding.customView.invalidate()
                true
            }

            R.id.item_green -> {
                circleColor = 1
                binding.customView.color = Color.GREEN
                binding.customView.invalidate()
                true
            }

            R.id.item_blue -> {
                circleColor = 2
                binding.customView.color = Color.BLUE
                binding.customView.invalidate()
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}