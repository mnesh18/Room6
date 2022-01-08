package com.example.tasktimer1room6.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimer1room6.Adapter.RVAdapter
import com.example.tasktimer1room6.R

class ViewActivity : AppCompatActivity() {

    lateinit var rv : RecyclerView
    lateinit var  adpter : RVAdapter
    lateinit var tasks: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)

        rv = findViewById(R.id.recyclerView)


       // tasks = arrayListOf()
      //  adpter = RVAdapter(tasks)
        //  rv.adapter = RVAdapter
     //   rv.layoutManager = GridLayoutManager(requireContext() , 2)





        val back_btn = findViewById<Button>(R.id.btn_back2)
        back_btn.setOnClickListener {
            val intent = Intent(this , HomeActivity::class.java)
            startActivity(intent)
        }
    }
}