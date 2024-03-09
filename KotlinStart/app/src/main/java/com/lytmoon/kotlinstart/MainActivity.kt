package com.lytmoon.kotlinstart

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mTextView: TextView;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = findViewById(R.id.tv_main)
        mTextView.setOnClickListener {
            it
        }

        Thread(object : Runnable {
            override fun run() {
                //执行自己的逻辑
            }
        }).start()

        Thread({
            println("")
        }).start()

        Thread() {
            println("")
        }.start()


        Thread {
            println("")
        }.start()

        mTextView = findViewById<TextView?>(R.id.tv_main).apply {
            text = "ijweoijfw"
            setOnClickListener {
                println()
            }
            isActivated = false
            text = "ewfewfwef"
        }


    }
}