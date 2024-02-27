package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * 开启协程的三种方法
         */

        //返回的是最后一行代码
        runBlocking {

        }
        //返回一个Job
        GlobalScope.launch {

        }
        //返回Deferred对象
        GlobalScope.launch {

        }

//        start()
//        start1()


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
//            for (index in 1 until 100) {
//                //同步执行
//                launch {
//                    Log.d("launch it", "${index}:启动一个协程")
//                }
//            }

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


}
