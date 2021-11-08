package com.guanwh.swdevdemo.todolst

import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.guanwh.swdevdemo.R
import com.guanwh.swdevdemo.database.AppDatabase
import com.guanwh.swdevdemo.database.TodoList
import java.text.SimpleDateFormat
import java.util.*

class TodoListItemViewHolder:RecyclerView.ViewHolder {
    private lateinit var todoList:TodoList
    private var mSwitch:Switch
    private var mNoteTextVew:TextView
    private var mDateTextView:TextView
    private var mDelBtn:Button

    constructor(@NonNull itemView:View): super(itemView){
        mSwitch = itemView.findViewById(R.id.todo_switch)
        mNoteTextVew = itemView.findViewById(R.id.textView_todonote)
        mDateTextView = itemView.findViewById(R.id.textView_tododate)
        mDelBtn = itemView.findViewById(R.id.btn_del_todo)

        val appDatabase = AppDatabase.getInstance(itemView.context)
        val todoListDao = appDatabase.todoListDao()

        mSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            todoList.finished = isChecked
            todoListDao.update(todoList)
        }
        mDelBtn.setOnClickListener {
            todoListDao.delete(todoList)

        }
    }

    public fun bind(todoList:TodoList) {
        this.todoList = todoList
        mSwitch.isChecked = todoList.finished
        mNoteTextVew.text = todoList.note
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
        val dateString: String = sdf.format(todoList.date)
        mDateTextView.text = dateString

    }
}