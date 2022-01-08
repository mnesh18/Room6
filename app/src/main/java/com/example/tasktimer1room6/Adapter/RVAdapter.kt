package com.example.tasktimer1room6.Adapter

import android.content.Intent
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimer1room6.Activity.TimerActivity
import com.example.tasktimer1room6.Activity.ViewActivity
import com.example.tasktimer1room6.R
import com.example.tasktimer1room6.Room.Task
import kotlinx.android.synthetic.main.task_item.view.*


class RVAdapter (val activity: ViewActivity) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    private var list = emptyList<Task>()

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.apply {
            task_tv.text = item.name
            details_tv.text = item.description

            if (item.time != "0") {
                time.base = SystemClock.elapsedRealtime() + item.time.toLong()
            } else {
                time.base = SystemClock.elapsedRealtime()
            }
            delete_btn.setOnClickListener {
                activity.tasksViewModel.deleteTask(item)
            }
            item_card.setOnClickListener {
                val data = Task( list[position].id, list[position].name, list[position].description, list[position].time)
                val intent = Intent(holder.itemView.context, TimerActivity::class.java)
                intent.putExtra("timer",data)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = list.size

    fun update(task: List<Task>){
        this.list = task
        notifyDataSetChanged()
    }

    fun get() : List<Task>{
        notifyDataSetChanged()
        return this.list
    }
}