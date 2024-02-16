package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class BlankFragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_blank1, container, false)
        val mVp: ViewPager2 = rootView.findViewById(R.id.fragment1_vp2)
        val textList = listOf("Text 1", "Text 2", "Text 3")
        val adapter = TextViewPagerAdapter(textList)
        mVp.adapter = adapter
        return rootView

    }

}