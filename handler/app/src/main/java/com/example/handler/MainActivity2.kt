package com.example.handler

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ht = HandlerThread("Handler")
        ht.start()


        handler = Handler(ht.looper) { msg ->
            Toast.makeText(this, msg.what.toString(), Toast.LENGTH_SHORT).show()
            Log.d("LogTest", "测试数据:${Thread.currentThread()}")
            true
        }

        val handler = Handler(Looper.myLooper()!!) {

            true
        }

        val handlerThread = HandlerThread("hi")


        /**
         * 第二种创建方式
         * 继承handler
         */
        class myHandler : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
            }

        }


        /**
         * 这里的消息先后处理顺序应该是132 也就是说
         * handler维护的队列链表的顺序是132
         */
        val msg1 = handler.obtainMessage()
        msg1.what = 1
        handler.sendMessage(msg1)


        val msg2 = handler.obtainMessage()
        msg2.what = 2
        handler.sendMessageDelayed(msg2, 5000)

        val msg3 = handler.obtainMessage()
        msg3.what = 3
        handler.sendMessage(msg3)

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}