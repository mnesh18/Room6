package com.example.tasktimer1room6.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tasktimer1room6.Room.Task
import com.example.tasktimer1room6.Room.TaskDatabase
import com.example.tasktimer1room6.Room.TasksDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TasksViewModel (application: Application): AndroidViewModel(application) {

    private val taskDao: TasksDao
    private val tasks: LiveData<List<Task>>

    init {
        taskDao = TaskDatabase.getDatabase(application).taskDao()
        tasks = taskDao.getAllTasks()
    }

    fun getTasks(): LiveData<List<Task>> {
        return tasks
    }

    fun deleteTask(task: Task) {
        CoroutineScope(IO).launch {
            taskDao.DeleteTask(task)
        }
    }

    fun addTask(task: Task) {
        CoroutineScope(IO).launch {
            taskDao.AddTask(task)
        }
    }
}