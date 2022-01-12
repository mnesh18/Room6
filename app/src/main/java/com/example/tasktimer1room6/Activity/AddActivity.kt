package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tasktimer1room6.Model.TasksViewModel
import com.example.tasktimer1room6.R
import com.example.tasktimer1room6.Room.Task

class AddActivity : AppCompatActivity() {

    private lateinit var saveTasks_btn: Button
    private lateinit var back_btn: Button
    private lateinit var addDetails_ed: EditText
    private lateinit var addTasks_ed: EditText

    lateinit var tasksViewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        tasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)

        saveTasks_btn = findViewById(R.id.saveTasks_btn)
        back_btn = findViewById(R.id.cancel_btn)
        addDetails_ed = findViewById(R.id.addDetails_ed)
        addTasks_ed = findViewById(R.id.addTasks_ed)

        saveTasks_btn.setOnClickListener { AddNewTask() }

        back_btn.setOnClickListener {
            val intent = Intent(this , HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun AddNewTask() {
        if (addTasks_ed.text.isNotBlank()) {
             tasksViewModel.addTask(
                Task(
                    0,
                    addTasks_ed.text.toString(),
                    addDetails_ed.text.toString(),
                    "0"
                )
            )

            Toast.makeText(this@AddActivity, "Added successfully", Toast.LENGTH_SHORT).show()
            addDetails_ed.clearFocus()
            addDetails_ed.text.clear()
            addTasks_ed.clearFocus()
            addTasks_ed.text.clear()
        } else {
            Toast.makeText(this@AddActivity, "Not added, try again", Toast.LENGTH_SHORT).show()
        }
    }

}