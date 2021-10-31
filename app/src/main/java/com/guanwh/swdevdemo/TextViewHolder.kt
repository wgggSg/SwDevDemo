package com.guanwh.swdevdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.annotations.NotNull

class TextViewHolder:RecyclerView.ViewHolder,View.OnClickListener {
    private var mTextView:TextView

    constructor(@NotNull itemView: View) : super(itemView){
        mTextView = itemView.findViewById(R.id.textView_sl)
        itemView.setOnClickListener(this)
    }

    public fun bind(text:String){
        mTextView.setText(text)
    }

    override fun onClick(v: View?) {

    }
}