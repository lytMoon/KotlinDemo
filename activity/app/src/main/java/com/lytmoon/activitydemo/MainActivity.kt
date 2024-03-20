package com.lytmoon.activitydemo

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mButton :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniView()



    }

    private fun iniView() {

        /**
         * 默认是standard，每次都会在栈里面新建一个activity
         *
         * singleTop：栈顶复用模式.  如果在栈顶，则复用
         *
         * singleTask 栈内单例模式：在同一个任务栈中，Activity只会有一个实例。如果实例已存在，则系统会将该Activity上面的其他Activity出栈
         *
         * singleInstance :堆内单例：整个手机操作系统里面只有一个实例存在就是内存单例；
         *
         *
         *
         */

        mButton= findViewById<Button?>(R.id.main_btn).apply {
            setOnClickListener {
                /**
                 * 这里设置成FLAG_ACTIVITY_CLEAR_TOP栈里面只有一个单例不如singleTop，动画不自然。
                 */

                val intent= Intent(this@MainActivity,MainActivity::class.java)
                //当前的flag设置在mainAct里面
                intent.addFlags(FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
        }
    }
}