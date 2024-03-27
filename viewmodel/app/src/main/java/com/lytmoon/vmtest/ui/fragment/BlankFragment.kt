package com.lytmoon.vmtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lytmoon.vmemo.R
import com.lytmoon.vmtest.viewmodel.MainViewModel

class BlankFragment : Fragment() {


    private val mViewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniData()


        /**
         * liveData不能在非主线程使用。所以下面的写法是错误的
         */
//        Thread{
//            mViewModel.mLiveData.observe(requireActivity()) {
//            }
//        }.start()


    }


    private fun iniData() {
        mViewModel.mLiveData.observe(requireActivity()) {

        }

    }


}