package com.example.myapplication.logic.network

import androidx.lifecycle.LiveData
import com.example.myapplication.logic.model.bean.BannerVO
import com.example.myapplication.logic.model.BaseResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("banner/json")
    fun bannerList(): LiveData<BaseResponse<List<BannerVO>>>
    @GET("maven_pom/package/json")
    fun getMavenList():LiveData<BaseResponse<List<String>>>

}