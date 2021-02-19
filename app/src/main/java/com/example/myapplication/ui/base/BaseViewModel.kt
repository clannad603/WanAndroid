package com.example.myapplication.ui.base

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.utils.MyPreference
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
open class BaseViewModel :ViewModel(){

    protected val page = MutableLiveData<Int>()
    val isLogin=MutableLiveData<String>()
    fun makeLogin(string: String){
        isLogin.value=string
    }
}