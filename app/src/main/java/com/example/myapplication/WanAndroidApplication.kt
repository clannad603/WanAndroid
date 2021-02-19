package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log

class WanAndroidApplication:Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }

}