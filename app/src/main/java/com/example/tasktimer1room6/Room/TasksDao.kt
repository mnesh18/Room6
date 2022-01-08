package com.example.tasktimer1room6.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TasksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun AddTask(task: Task)

    @Update
    suspend fun UpdateTask(task: Task)

    @Query("SELECT * FROM tasks_table")
    fun getAllTasks(): LiveData<List<Task>>

    @Delete
    suspend fun DeleteTask(task: Task)
}