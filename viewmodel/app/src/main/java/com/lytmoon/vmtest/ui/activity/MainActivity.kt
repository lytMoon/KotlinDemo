package com.lytmoon.vmtest.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.lytmoon.vmemo.R
import com.lytmoon.vmtest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.mLiveData.observe(this){

        }
    }
}