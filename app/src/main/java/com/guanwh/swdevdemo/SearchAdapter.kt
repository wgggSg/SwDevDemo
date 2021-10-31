package com.guanwh.swdevdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter: RecyclerView.Adapter<TextViewHolder>() {
    @NonNull
    private val mItems:MutableList<String> = ArrayList()

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false))
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(mItems.get(position))
    }

    public fun notifyItems(@NonNull items:MutableList<String>){
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
}