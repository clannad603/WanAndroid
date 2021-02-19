package com.example.myapplication.logic.repository

class ArticleRepository :NetRepository(){
    fun getArticleList(page:Int) =
        api.articleList(page)
}