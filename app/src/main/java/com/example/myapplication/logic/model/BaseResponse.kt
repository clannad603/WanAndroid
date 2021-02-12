package com.example.myapplication.logic.model

open class BaseResponse<T>(var data: T, var errorCode: Int = -1, var errorMsg: String = "")