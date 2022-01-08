package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimer1room6.Adapter.RVAdapter
import com.example.tasktimer1room6.Model.TasksViewModel
import com.example.tasktimer1room6.R

class ViewActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var  rvAdapter : RVAdapter

    lateinit var tasksViewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)

        tasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)

        tasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        tasksViewModel.getTasks().observe(this, {
                taskList -> rvAdapter.update(taskList)
        })

        recyclerView = findViewById(R.id.recyclerView)

        rvAdapter = RVAdapter(this)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val back_btn = findViewById<Button>(R.id.btn_back2)
        back_btn.setOnClickListener {
            val intent = Intent(this , HomeActivity::class.java)
            startActivity(intent)
        }
    }

}