package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = MyAdapter(listOf("1", "2", "3", "4", "5", "6", "7", "8"))

        val snapHelper = LinearSnapHelper()
        //保证recyclerView滚动停止是，可以停在中间位置，类似于viewPager效果
        snapHelper.attachToRecyclerView(binding.recycler)

        binding.btn.setOnClickListener {
            //获取中间位置的position
            val view = snapHelper.findSnapView(layoutManager)
            if (view != null) {
                val position = layoutManager.getPosition(view)
                Toast.makeText(this, " $position", Toast.LENGTH_SHORT).show()
            }
        }
    }
}