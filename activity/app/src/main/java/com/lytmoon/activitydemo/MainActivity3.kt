package com.lytmoon.activitydemo

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

class MainActivity3 : AppCompatActivity() {

    private lateinit var mButton: Button
    private lateinit var mButton2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        initView()
        Log.d("LogTest", "onCreate")

        val ans = savedInstanceState?.getString("lytMoon")
        Log.d("8494948", "测试数据${ans}")
    }

    private fun initView() {
        mButton = findViewById<Button>(R.id.ac3_button).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity3, MainActivity::class.java)
                startActivity(intent)
            }
        }
        mButton2 = findViewById<Button?>(R.id.ac3_button2).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity3, MainActivity3::class.java)
                intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LogTest", "onStart")

    }


    override fun onResume() {
        super.onResume()
        Log.d("LogTest", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("LogTest", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LogTest", "onStop")


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LogTest", "onDestroy")
    }


    override fun onRestart() {
        super.onRestart()

    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        Log.d("LogTest", "onConfigurationChanged")


    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("LogTest", "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString("lytMoon", "123456")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d("LogTest", "onRestoreInstanceState")

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

}