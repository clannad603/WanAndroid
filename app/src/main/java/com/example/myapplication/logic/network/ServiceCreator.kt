package com.example.myapplication.logic.network

import com.example.myapplication.logic.model.Constant.BASE_URL
import com.example.myapplication.logic.model.Constant.CONNECT_TIMEOUT
import com.example.myapplication.logic.model.Constant.READ_TIMEOUT
import com.example.myapplication.logic.model.Constant.WRITE_TIMEOUT
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
object ServiceCreator {

    private val okHttpClient= OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun <T>create(serviceClass: Class<T>):T= retrofit.create(serviceClass)
    inline fun <reified T>create():T= create(T::class.java)
}