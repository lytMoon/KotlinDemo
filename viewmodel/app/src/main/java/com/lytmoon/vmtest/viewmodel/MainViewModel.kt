package com.lytmoon.vmtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _mLiveData: MutableLiveData<Any> = MutableLiveData<Any>()

    val mLiveData: LiveData<Any> get() = _mLiveData


    fun post(it: Any) {
        _mLiveData.postValue(it)
    }


}