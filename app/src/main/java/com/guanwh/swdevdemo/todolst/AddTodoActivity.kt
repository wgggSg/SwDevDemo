package com.guanwh.swdevdemo.todolst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.guanwh.swdevdemo.R
import com.guanwh.swdevdemo.database.AppDatabase
import com.guanwh.swdevdemo.database.TodoList
import java.util.*

class AddTodoActivity : AppCompatActivity() {
    private lateinit var mTodoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        val appDatabase = AppDatabase.getInstance(applicationContext)
        val todoListDao = appDatabase.todoListDao()

        mTodoEditText = findViewById(R.id.editText_todo)
        findViewById<Button>(R.id.button_add_todo).setOnClickListener {
            val todoList = TodoList()
            todoList.id = todoListDao.maxId + 1
            todoList.finished = false
            todoList.note = mTodoEditText.text.toString()
            todoList.date = Date()
            todoListDao.insertAll(todoList)
            finish()
        }
    }
}