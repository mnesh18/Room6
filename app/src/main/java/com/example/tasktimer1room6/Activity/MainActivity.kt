package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.example.tasktimer1room6.R

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMainActivity()
    }

    private fun startMainActivity() {
        runnable = Runnable {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
        handler = Handler()
        handler.postDelayed(runnable, 3000)
    }
}