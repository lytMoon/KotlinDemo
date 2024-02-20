package com.example.handler

import android.os.Bundle
import android.os.Handler
import android.os.Handler.Callback
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.os.MessageQueue
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ht = HandlerThread("myHandler")
        ht.start()
        val handler = Handler(ht.looper) { msg ->
            Toast.makeText(this@MainActivity, msg.what.toString(), Toast.LENGTH_SHORT).show()
            Log.d("LogTest", "测试数据:${Thread.currentThread()}")
            Log.d("LogTest", "测试数据:${msg}")
            true
        }
        val msg = Message()
        msg.what = 1
        handler.sendMessage(msg)


//        /**
//         * 创建handler的两种方式
//         */
//        val handler1 = Handler(mainLooper) {
//            Toast.makeText(this@MainActivity, "我是任务一", Toast.LENGTH_SHORT).show()
//            Log.d("55555", "测试数据:我是任务一")
//            Log.d("77777", "测试数据1:${Thread.currentThread()}")
//            true
//        }
//        val msg1 = Message()
//
//
//
//        handler1.sendMessage(msg1)
//        Log.d("LogTest", "测试数据:${handler1.looper}")
//
//
//        /**
//         * looper起到一个传送带的作用，消息队列的消息依次进入looper
//         * 最后由looper所在的线程来找到msg对应的handler 来处理消息
//         */
//        var msg2 = Message()
//        Thread {
//            //为当前线程创建looper
////            Looper.prepare()
//            Log.d("77777", "测试数据3:${Thread.currentThread()}")
//            val handler2 = Handler(Looper.myLooper() ?: Looper.getMainLooper()) {
//                Toast.makeText(this@MainActivity, "我是任务二", Toast.LENGTH_SHORT).show()
//                Log.d("55555", "测试数据:我是任务二")
//                Log.d("77777", "测试数据2:${Thread.currentThread()}")
//                true
//            }
//            Log.d("LogTest", "测试数据:${handler2.looper}")
//            msg2 = Message()
////            handler2.sendMessage(msg2)
////            Looper.loop()
//        }.start()
//
//        handler1.sendMessage(msg2)

    }
}