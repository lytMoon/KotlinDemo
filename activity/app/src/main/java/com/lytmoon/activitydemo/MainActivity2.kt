package com.lytmoon.activitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    private lateinit var mBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        iniView()
    }

    private fun iniView() {
        mBtn=findViewById<Button?>(R.id.main2_btn).apply {
            setOnClickListener{
                val intent = Intent(this@MainActivity2,MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}