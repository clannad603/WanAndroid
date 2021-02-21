package com.example.myapplication.logic.network

import androidx.lifecycle.LiveData
import com.example.myapplication.logic.model.BaseResponse
import com.example.myapplication.logic.model.bean.*
import retrofit2.http.*

interface ApiService {
 /***
  * 厂库列表
  */
    @GET("maven_pom/package/json")
   fun getMavenList():LiveData<BaseResponse<List<String>>>

 /***
  * 获取文章
  */
 @GET("article/list/{page}/json")
    fun articleList(
            @Path("page") page: Int
    ): LiveData<BaseResponse<PageVO<ArticleVO>>>

 /***
  * 用户信息
  */
 @GET("lg/coin/userinfo/json")
    fun getMyCoin():LiveData<BaseResponse<UserInfo>>


 /***
  * 退出
  */
 @GET("user/logout/json")
    fun logout():LiveData<BaseResponse<String>>

 /***
  * 注册
  */
 @POST("user/register")
     fun register(
            @Query("username") username: String?,
            @Query("password") password: String?,
            @Query("repassword") repassword: String?
    ): LiveData<BaseResponse<RegisterVO>>

 /***
  * 登录
  */
 @POST("user/login")
      fun login(
              @Query("username") username: String,
              @Query("password") password: String
      ): LiveData<BaseResponse<RegisterVO>>
     /**
      * 搜索
      */
     @POST("article/query/{page}/json")
     fun searchArticlePage(
             @Path("page") page: Int,
             @Query("k") keyword: String
     ): LiveData<BaseResponse<PageVO<ArticleVO>>>

      /***
       * 知识体系下文章
       */
      @GET("article/list/{page}/json")
      fun articleList(
              @Path("page") page: Int,
              @Query("cid") cid: Int
      ): LiveData<BaseResponse<PageVO<ArticleVO>>>
    /***
     * 广场
     */
     @GET("user_article/list/{page}/json")
     fun getSquare(
             @Path("page") page:Int
     ):LiveData<BaseResponse<PageVO<ArticleVO>>>

 /***
  * 获取项目
  */

 @GET("project/tree/json")
 fun getProject():LiveData<BaseResponse<MutableList<ProjectVO>>>

 //项目列表数据
 @GET("project/list/{page}/json?")
 fun getProjectChild(
         @Path("page") page: Int,
         @Query("cid") cid: Int
 ): LiveData<BaseResponse<PageVO<ArticleVO>>>
    @GET("wenda/list/{page}/json ")
    fun qaList(
            @Path("page") page: Int
    ): LiveData<BaseResponse<PageVO<ArticleVO>>>

    /***
     * 积分变化
     */
    @GET("lg/coin/list/1/json")
    fun getCoinChange():LiveData<BaseResponse<PageVO<UserInfoVO>>>

    /***
     * 个人收藏
     */
    @GET("lg/collect/list/{page}/json")
    fun getMyCollect(
        @Path("page") page: Int
    ):LiveData<BaseResponse<PageVO<ArticleVO>>>
    /***
     * 公众号
     */
    @GET("wxarticle/chapters/json")
    fun getOfficialAccount():LiveData<BaseResponse<MutableList<ProjectVO>>>

    //公众号列表数据
    @GET(" wxarticle/list/{id}/1/json?")
    fun getOfficialChild(
        @Path("id") id: Int,
    ): LiveData<BaseResponse<PageVO<ArticleVO>>>
}