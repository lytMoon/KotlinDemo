package com.example.coroutinedemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var mTv: TextView
    private lateinit var mBtn: Button

    @SuppressLint("MissingInflatedId")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTv = findViewById(R.id.tv_name)
        mBtn = findViewById(R.id.btn_intent)

        mBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }



//        start()
//        start1()
//        start3()
//        start4()
//        testDefaultStart()
//        testLazyStart()
//        testAtomicStart()
//        testCoroutineStart()


    }

    /**
     *
     */
    @OptIn(DelicateCoroutinesApi::class)
    private fun start4() {
        GlobalScope.launch {
            start5()
        }
    }

    private suspend fun start5() {

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun start3() {
        /**
         * 这里我们新开了一个协程。挂起在IO线程。
         */
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                Log.d("LogTest", "测试数据:${Thread.currentThread()}")
                val a = 5 + 7
//                Toast.makeText(this@MainActivity,Thread.currentThread().toString(),Toast.LENGTH_SHORT).show()
//                mTv.text=Thread.currentThread().toString()
            }
            //这里的UI刷新成功，显然此刻为主线程。
            mTv.text = Thread.currentThread().toString()
            Log.d("LogTest", "测试数据:${Thread.currentThread()}")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun start() {
        GlobalScope.launch {
            val launchJob = launch {
                Log.d("launch", "启动一个协程")
            }
            Log.d("launchJob", "$launchJob")
            val asyncJob = async {
                Log.d("async", "启动一个协程")
                "我是async返回值"
            }
            Log.d("asyncJob.await", ":${asyncJob.await()}")
            Log.d("asyncJob", "$asyncJob")
        }
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun start1() {
        GlobalScope.launch(Dispatchers.Main) {
            for (index in 1 until 100) {
                //同步执行
                launch {
                    Log.d("launch it", "${index}:启动一个协程")
                }
            }

            for (index in 1 until 1000) {
                if (index in 200 until 600) {
                    //如果调度器不是主线程，那么将会并发。
                    launch(Dispatchers.IO) {
                        Log.d("LogTest", "测试数据:${index}:启动一个协程")
                    }
                } else {
                    //主线程调度的这部分还是同步进行。
                    launch {
                        Log.d("LogTest", "测试数据:${index}:启动一个协程")
                    }
                }
            }
        }
    }

    /**
     * 这里研究一下挂起函数
     *参考网址：https://book.kotlincn.net/text/composing-suspending-functions.html
     */
    private fun start2() {

    }

    private suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // 假设我们在这里做了一些有用的事
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // 假设我们在这里也做了一些有用的事
        return 29
    }

    /**
     * 一般情况下为饿汉模式启动，不过有可能被取消掉。
     * 先开启一个协程调度到IO再回来。回来之后打印当前的Main线程，接着执行join
     */


    /**
     * 这里打印的Log没有测试数据2.也就是第一个挂起函数被取消了，但是这两个不都是运行在主线程的吗？
     * 因为协程是不会阻塞线程的，不管调度的线程是否和原线程一样。所以不会先执行上面，开启第一个线程的时候第二个已经执行了。
     */
    @OptIn(DelicateCoroutinesApi::class)
    private fun testDefaultStart() {
        GlobalScope.launch(Dispatchers.Main) {
            val job = launch(Dispatchers.Main) {
                Log.d("LogTest", "测试数据:2")
                Log.d("LogTest", "测试数据:${Thread.currentThread()}")
            }
            Log.d("LogTest", "测试数据:${Thread.currentThread()}")
            job.cancel()
        }
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun testLazyStart() {
        GlobalScope.launch {
            val lazy = launch(start = CoroutineStart.LAZY) {
                Log.d("LogTest", "测试数据:${"我是LAZY启动模式"}")
            }
            Log.d("LogTest", "测试数据:执行1")
            lazy.join()
        }
    }


    @OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
    private fun testAtomicStart() {
        GlobalScope.launch(Dispatchers.Main) {
            val job = launch(Dispatchers.Main, start = CoroutineStart.ATOMIC) {
                Log.d("LogTest", "测试数据:2")
//                delay(100)
                Log.d("LogTest", "测试数据:${Thread.currentThread()}")
            }
            job.cancel()
            Log.d("LogTest", "测试数据:${Thread.currentThread()}")
        }
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun testCoroutineStart() {
        val defaultJob = GlobalScope.launch {
            Log.d("LogTest", "CoroutineStart.DEFAULT")
        }
        defaultJob.cancel()
        val lazyJob = GlobalScope.launch(start = CoroutineStart.LAZY) {
            Log.d("LogTest", "CoroutineStart.LAZY")
        }
        val atomicJob = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
            Log.d("LogTest", "CoroutineStart.ATOMIC挂起前")
            delay(100)
            Log.d("LogTest", "CoroutineStart.ATOMIC挂起后")
        }
        atomicJob.cancel()
        val undispatchedJob = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
            Log.d("LogTest", "${Thread.currentThread()}CoroutineStart.UNDISPATCHED挂起前")
            delay(100)
            Log.d("LogTest", "CoroutineStart.UNDISPATCHED挂起后")
        }
        undispatchedJob.cancel()
    }


}
