package com.example.tasktimer1room6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      var addTask_btn = findViewById<Button>(R.id.btn_addTask)
        addTask_btn.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

        var viewTask_btn = findViewById<Button>(R.id.btn_viewTask)
        viewTask_btn.setOnClickListener {
            val intent = Intent(this,ViewActivity::class.java)
            startActivity(intent)
        }


    }
}