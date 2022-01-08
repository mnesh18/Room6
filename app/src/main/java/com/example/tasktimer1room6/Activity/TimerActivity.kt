package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import com.example.tasktimer1room6.R
import com.example.tasktimer1room6.Room.Task
import android.widget.Chronometer.OnChronometerTickListener
import androidx.lifecycle.ViewModelProvider
import com.example.tasktimer1room6.Model.TasksViewModel


class TimerActivity : AppCompatActivity() {

    private lateinit var tv_timer: Chronometer
    private lateinit var startTimer_btn: Button
    private lateinit var stopTimer_btn: Button
    private lateinit var btnBack: Button

    var id = 0
    var name = ""
    var description = ""

    private var timerStarted = false
    private var time: Long = 0

    lateinit var tasksViewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        tasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)

        tv_timer = findViewById(R.id.tv_timer)
        startTimer_btn = findViewById(R.id.startTimer_btn)
        stopTimer_btn = findViewById(R.id.stopTimer_btn)
        btnBack = findViewById(R.id.btnBack)

        val data = intent.getSerializableExtra("timer") as Task
        id = data.id
        name = data.name
        description = data.description
        time = data.time.toLong()

        tv_timer.base = SystemClock.elapsedRealtime() + time

        startTimer_btn.setOnClickListener { startStopTimer() }
        stopTimer_btn.setOnClickListener { resetTimer() }
        btnBack.setOnClickListener { BackToMain() }
    }

    private fun BackToMain() {
        tasksViewModel.updateTask(Task(id,name,description,time.toString()))
        val intent = Intent(this , ViewActivity::class.java)
        startActivity(intent)
    }

    private fun resetTimer()
    {
        time = 0
        tv_timer.base = SystemClock.elapsedRealtime()
        tv_timer.stop()
    }

    private fun startStopTimer()
    {
        if(timerStarted)
            stopTimer()
        else
            startTimer()
    }

    private fun startTimer()
    {
        startTimer_btn.text = "Stop"
        timerStarted = true
        tv_timer.base = SystemClock.elapsedRealtime()+time
        tv_timer.start()
    }

    private fun stopTimer()
    {
        startTimer_btn.text = "Start"
        timerStarted = false
        time = tv_timer.base - SystemClock.elapsedRealtime()
        tv_timer.stop()
    }
}