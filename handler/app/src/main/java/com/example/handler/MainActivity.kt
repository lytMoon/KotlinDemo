package com.example.handler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var mBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBtn = findViewById(R.id.main_btn)
        mBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


//        /**
//         * 这里的消息先后处理顺序应该是132 也就是说
//         * handler维护的队列链表的顺序是132
//         */
//        val msg1 = handler.obtainMessage()
//        msg1.what = 1
//        handler.sendMessage(msg1)
//
//        val msg2 = handler.obtainMessage()
//        msg2.what = 2
//        handler.sendMessageDelayed(msg2, 5000)
//
//        val msg3 = handler.obtainMessage()
//        msg3.what = 3
//        handler.sendMessage(msg3)
//

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

    override fun onDestroy() {
        super.onDestroy()
//        handler.removeCallbacksAndMessages(null)
    }
}