package com.guanwh.swdevdemo.todolst

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.guanwh.swdevdemo.R
import com.guanwh.swdevdemo.database.TodoList

class TodoListAdapter: RecyclerView.Adapter<TodoListItemViewHolder>() {
    @NonNull
    private val mItems:MutableList<TodoList> = ArrayList()

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListItemViewHolder {
        return TodoListItemViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo_list, parent, false))
    }

    override fun onBindViewHolder(holder: TodoListItemViewHolder, position: Int) {
        holder.bind(mItems.get(position))
    }

    public fun notifyItems(@NonNull items:MutableList<TodoList>){
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
}