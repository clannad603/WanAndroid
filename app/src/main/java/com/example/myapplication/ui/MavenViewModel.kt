package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.myapplication.logic.model.BaseResponse
import com.example.myapplication.logic.repository.MavenSearchRepository
import com.example.myapplication.ui.base.BaseViewModel

class MavenViewModel:BaseViewModel() {
    private val checkLiveData=MutableLiveData<Boolean>()
    private val mavenLis:LiveData<BaseResponse<List<String>>> = Transformations.switchMap(checkLiveData) {
        MavenSearchRepository.getMavenList()
    }
    val mavenLiveData: LiveData<List<String>> = Transformations.map(mavenLis) {
        it.data ?: ArrayList()
    }
  fun setCheck(boolean: Boolean){
      checkLiveData.value=boolean
  }


}