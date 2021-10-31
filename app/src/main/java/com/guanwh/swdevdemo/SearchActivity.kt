package com.guanwh.swdevdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val mSearchAdapter: SearchAdapter = SearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mSearchAdapter

        val items: MutableList<String> = ArrayList()
        for (i in 0..100) {
            items.add("这是第" + i.toString() + "行")
        }
        mSearchAdapter.notifyItems(items)

        val mSearchBtn: Button = findViewById(R.id.btn_search)
        val mSearchText: TextView = findViewById(R.id.editTextSearch)
        mSearchBtn.setOnClickListener {
            val items: MutableList<String> = ArrayList()
            for (i in 0..100) {
                if (i.toString().contains(mSearchText.text))
                    items.add("这是第" + i.toString() + "行")
            }
            mSearchAdapter.notifyItems(items)
        }
    }
}