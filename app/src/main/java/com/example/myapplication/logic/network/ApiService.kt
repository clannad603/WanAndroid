package com.example.myapplication.logic.network

import androidx.lifecycle.LiveData
import com.example.myapplication.logic.model.bean.BannerVO
import com.example.myapplication.logic.model.BaseResponse
import retrofit2.http.GET

interface ApiService {

    @GET("banner/json")
    fun bannerList(): LiveData<BaseResponse<List<BannerVO>>>

}