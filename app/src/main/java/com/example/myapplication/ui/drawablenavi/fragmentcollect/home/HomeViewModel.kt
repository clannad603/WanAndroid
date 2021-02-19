package com.example.myapplication.ui.drawablenavi.fragmentcollect.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.logic.model.BaseResponse
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.logic.network.ServiceCreator
import com.example.myapplication.logic.repository.ArticleRepository
import com.example.myapplication.logic.repository.MavenSearchRepository
import com.example.myapplication.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    private val pageLiveData=MutableLiveData<Int>()
    private val articleLists = Transformations.switchMap(pageLiveData) { it->
        repository.getArticleList(it)
    }
    val articleList=ArrayList<ArticleVO>()
    val articles = Transformations.map(articleLists) {
        it.data?.articles
    }
    private val repository by lazy { ArticleRepository() }
    fun giveCheck(page:Int){
      pageLiveData.value=page
    }
}