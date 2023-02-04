package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @Description:
 * @author: zhaoyj
 * @date: 2023/1/30
 */
class MyAdapter(var data: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as MyHolder).tv.text = "item ${data[position]}"
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyHolder(view: View) : ViewHolder(view) {
        val tv: TextView = view.findViewById(R.id.tv)
    }

}