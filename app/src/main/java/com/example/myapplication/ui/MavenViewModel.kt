package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.myapplication.logic.repository.MavenSearchRepository
import com.example.myapplication.logic.repository.NetRepository
import com.example.myapplication.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MavenViewModel:BaseViewModel() {
    private val checkLiveData=MutableLiveData<Boolean>()
    private var mavens=MutableLiveData<List<String>>()
    val mavenLiveData: LiveData<List<String>> = Transformations.map(mavens) {
        it?: ArrayList()
    }
  fun setCheck(boolean: Boolean){
      checkLiveData.value=boolean
  }



}