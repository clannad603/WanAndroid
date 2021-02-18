package com.example.myapplication.logic.network

import androidx.lifecycle.LiveData
import com.example.myapplication.logic.model.bean.BannerVO
import com.example.myapplication.logic.model.BaseResponse
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.logic.model.bean.PageVO
import com.example.myapplication.logic.model.bean.RegisterVO
import retrofit2.http.*

interface ApiService {

    @GET("banner/json")
    fun bannerList(): LiveData<BaseResponse<List<BannerVO>>>
    @GET("maven_pom/package/json")
   fun getMavenList():LiveData<BaseResponse<List<String>>>
    @GET("article/list/{page}/json")
    fun articleList(
            @Path("page") page: Int
    ): LiveData<BaseResponse<PageVO<ArticleVO>>>
    /**
     * 置顶文章列表
     */
    @GET("article/top/json")
    fun articleTopList(
    ): LiveData<BaseResponse<List<ArticleVO>>>
    //注册

    @POST("user/register")
     fun register(
            @Query("username") username: String?,
            @Query("password") password: String?,
            @Query("repassword") repassword: String?
    ): LiveData<BaseResponse<RegisterVO>>

    @POST("user/login")
    fun login(
            @Query("username") username: String,
            @Query("password") password: String
    ): LiveData<BaseResponse<RegisterVO>>

}