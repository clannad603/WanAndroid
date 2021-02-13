package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.myapplication.logic.network.ApiService
import com.example.myapplication.logic.network.ServiceCreator

/***
 * 2021.2.13 心酸日志，模拟器导致无法接收返回值
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }
    private fun loadData() {
        val bannerList = ServiceCreator.get().bannerList()
        bannerList.observe(this, Observer {
            Log.e("main", "res:$it")
        })
    }

}