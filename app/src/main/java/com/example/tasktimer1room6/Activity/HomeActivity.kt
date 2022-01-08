package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tasktimer1room6.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addTask_btn = findViewById<Button>(R.id.btn_addTask)
        addTask_btn.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        val viewTask_btn = findViewById<Button>(R.id.btn_viewTask)
        viewTask_btn.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }
    }
}