package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        Log.d("LogTest","测试数据:${Thread.currentThread().name}")
        /**
         *
         */

        GlobalScope.launch {
            Log.d("LogTest","测试数据:${Thread.currentThread().name}")
            val job = launch {
                Log.d("LogTest","测试数据:${Thread.currentThread().name}")
            }
        }

        Log.d("LogTest","测试数据:${Thread.currentThread().name}")







    }
}