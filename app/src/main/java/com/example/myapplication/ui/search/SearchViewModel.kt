package com.example.myapplication.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.myapplication.logic.model.bean.SearchInfo
import com.example.myapplication.logic.repository.ArticleRepository
import com.example.myapplication.ui.base.BaseViewModel

class SearchViewModel:BaseViewModel() {
    private val searchInfoLiveData= MutableLiveData<SearchInfo>()
    private val articleLists = Transformations.switchMap(searchInfoLiveData) { it->
        ArticleRepository.searchArticleList(it)
    }
    val pageVO = Transformations.map(articleLists) {
        it.data
    }
    val articles= Transformations.map(pageVO){
        it?.datas
    }

    fun giveSearch(searchInfo: SearchInfo){
        searchInfoLiveData.value=searchInfo
    }



}