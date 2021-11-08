package com.guanwh.swdevdemo.todolst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guanwh.swdevdemo.R
import com.guanwh.swdevdemo.database.AppDatabase
import com.guanwh.swdevdemo.database.TodoList
import com.guanwh.swdevdemo.database.TodoListDao
import java.util.*
import kotlin.collections.ArrayList

class TodoListActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val mTodoListAdapter: TodoListAdapter = TodoListAdapter()
    private lateinit var appDatabase: AppDatabase
    private lateinit var todoListDao: TodoListDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

        findViewById<Button>(R.id.button_open_addtodo).setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
        }

        mRecyclerView = findViewById(R.id.rv_todolist)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mTodoListAdapter
        appDatabase = AppDatabase.getInstance(applicationContext)
        todoListDao = appDatabase.todoListDao()
        refreshTodoList()
    }

    override fun onResume() {
        super.onResume()
        refreshTodoList()
    }

    private fun refreshTodoList() {
        val items: MutableList<TodoList> = todoListDao.loadAll()
//        val items: MutableList<TodoList> = ArrayList()
//        for (i in 0..20){
//            val todoList = TodoList()
//            todoList.id = i.toLong()
//            todoList.finished = false
//            todoList.note = "mTodoEditText.text.toString()"
//            todoList.date = Date()
//            items.add(todoList)
//        }

        mTodoListAdapter.notifyItems(items)
    }
}