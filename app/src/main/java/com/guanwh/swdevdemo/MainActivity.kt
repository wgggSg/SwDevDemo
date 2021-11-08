package com.guanwh.swdevdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.guanwh.swdevdemo.todolst.TodoListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            Log.d(R.layout.activity_main.toString(),"Click welcome button.")
            findViewById<TextView>(R.id.textView).setText("Welcome FDU:)")

            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button_todolist).setOnClickListener {
            val intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
        }
    }
}
