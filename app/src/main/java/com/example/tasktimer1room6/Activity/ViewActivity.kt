package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimer1room6.Adapter.RVAdapter
import com.example.tasktimer1room6.Model.TasksViewModel
import com.example.tasktimer1room6.R
import com.example.tasktimer1room6.Room.Task

class ViewActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var  rvAdapter : RVAdapter
    lateinit var ch_totalTimer : Chronometer

    lateinit var tasksViewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)

        recyclerView = findViewById(R.id.recyclerView)
        ch_totalTimer = findViewById(R.id.ch_totalTimer)

        rvAdapter = RVAdapter(this)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        tasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        tasksViewModel.getTasks().observe(this, {
            taskList -> rvAdapter.update(taskList)
            val list = taskList
            getTotal(list)
        })

        var vv = rvAdapter.get()
        Log.d("ggggg", "$vv")
        val back_btn = findViewById<Button>(R.id.btn_back2)
        back_btn.setOnClickListener {
            val intent = Intent(this , HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getTotal(list: List<Task>?) {
        var total:Long = 0
        if (list != null) {
            for (item in list){
                total += item.time.toLong()
            }
            ch_totalTimer.base = SystemClock.elapsedRealtime() + total
        }
    }

}