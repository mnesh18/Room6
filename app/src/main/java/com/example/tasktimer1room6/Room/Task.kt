package com.example.tasktimer1room6.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tasks_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name:String,
    val description: String,
    val time: String): Serializable