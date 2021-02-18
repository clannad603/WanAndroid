package com.example.myapplication.ui.drawablenavi.fragmentcollect.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.logic.model.BaseResponse
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.logic.network.ServiceCreator
import com.example.myapplication.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val articleList =
            Transformations.switchMap(page) {
               ServiceCreator.get().articleList(it)
            }
    private val topArticleList =
            Transformations.switchMap(page) {
                if (it == 0) ServiceCreator.get().articleTopList()
                else {
                    val data = MutableLiveData<BaseResponse<List<ArticleVO>>>()
                    data.value =
                            BaseResponse(
                                    null,
                                    0,
                                    ""
                            )
                    data
                }
            }
}