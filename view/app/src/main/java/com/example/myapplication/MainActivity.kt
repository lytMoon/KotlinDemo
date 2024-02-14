package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mVp: ViewPager2 = findViewById(R.id.main_vp2)
        val fragmentAdapter = MyFragmentAdapter(this)
        mVp.adapter = fragmentAdapter

        /**
         * 如果设置了 mVp.isUserInputEnabled=false 则没有拦截
         * 如果默认则内层的fragment划不动
         */
    }

    inner class MyFragmentAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> BlankFragment1()
                1 -> BlankFragment2()
                else -> BlankFragment3()
            }
        }
    }
}