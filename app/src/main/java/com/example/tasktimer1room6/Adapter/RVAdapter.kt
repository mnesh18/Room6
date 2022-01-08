package com.example.tasktimer1room6.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimer1room6.R
import com.example.tasktimer1room6.Room.Task
import kotlinx.android.synthetic.main.task_item.view.*


class RVAdapter (var list: List<Task>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.apply {
            task_tv.text = item.name
            details_tv.text = item.description
            time.text = item.time
        }
    }

    override fun getItemCount() = list.size
}