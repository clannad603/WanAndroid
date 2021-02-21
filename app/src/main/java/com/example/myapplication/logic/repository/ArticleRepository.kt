package com.example.myapplication.logic.repository

import com.example.myapplication.logic.model.bean.SearchInfo

object ArticleRepository :NetRepository(){
    fun getArticleList(page:Int) =
        api.articleList(page)
    fun searchArticleList(searchInfo: SearchInfo)=api.searchArticlePage(searchInfo.page, searchInfo.keyword)
    fun getSquare(page:Int) =
            api.getSquare(page)
    fun getQa(page: Int)=api.qaList(page)
    fun getMyCollect(page: Int)=api.getMyCollect(page)
    fun getOfficialAccount()=api.getOfficialAccount()
    fun getOfficialChild(id:Int)=api.getOfficialChild(id)
}