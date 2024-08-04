package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ButtonActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)


        /**
         * 研究一下 action_move 事件
         * 先点击button，让后从上面滑动出去，看看相应什么时间
         *
         *
         * result：
         *(MyButton.java:32) -->ACTION_DOWN
         * (MyButton.java:36) -->ACTION_MOVE
         * (MyButton.java:36) -->ACTION_MOVE
         * (MyButton.java:36) -->ACTION_MOVE
         * (MyButton.java:36) -->ACTION_MOVE
         * (MyButton.java:36) -->ACTION_MOVE
         * (MyButton.java:39) -->ACTION_UP
         *
         * 滑出view后依然可以收到ACTION_MOVE和ACTION_UP事件。
         * 为什么有人会认为滑出view后会收到ACTION_CANCEL呢？
         * 我想是因为滑出view后，view的onClick()不会触发了，所以有人就以为是触发了ACTION_CANCEL。
         * 那么为什么滑出view后不会触发onClick呢？再来看看View的源码：
         *
         * 并且没有相应点击事件

         *
         */
        findViewById<Button>(R.id.bt_my).setOnClickListener {
            Toast.makeText(this@ButtonActivity, "第一个响应了点击事件", Toast.LENGTH_SHORT).show()
        }


        /**
         * 上面是一个button，下面换成两个并列button
         *
         *
         * Button默认会在ACTION_DOWN时返回true，因此它通常会消耗掉该触摸事件的后续事件。
         * 所以第二个没有响应什么事件
         * 结果跟第一种一样
         */

        findViewById<Button>(R.id.bt_my1).setOnClickListener {
            Toast.makeText(this@ButtonActivity, "第二个响应了点击事件", Toast.LENGTH_SHORT).show()
        }

        /**
         * cancel 事件什么时候触发
         * 1. 事件被父控件拦截，比如控件接收到了Down事件，但是父控件拦截了Up事件，此时Up事件就会被转发为Cancel事件分发给子View
         * 2.  事件流程被异常情况打断，比如处理事件的过程中，系统更新功能弹出，意外发生了界面切换，再回到APP时，会补发一个Cancel事件来取消之前的操作
         * 3.  事件处理过程中，被父控件移除
         * 4.  事件处理过程中，被从Window中移除
         * 5.  要特别注意的是，手指滑出控件区域时，Move事件仍会继续执行，并不会取消当前事件，也就是说，手指滑动出view区域，并没有收到cancel，易错点！！跟网上不一样，注意这一点
         */


    }
}