package com.example.myapplication.logic.model.bean

data class PageVO<T>(
        val curPage: Int,
        val articles: List<ArticleVO>,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int
)