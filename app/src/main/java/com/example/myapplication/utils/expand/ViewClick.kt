package com.example.myapplication.utils.expand

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.utils.expand.ViewClickDelay.SPACE_TIME
import com.example.myapplication.utils.expand.ViewClickDelay.hash
import com.example.myapplication.utils.expand.ViewClickDelay.lastClickTime
import java.io.Serializable

object ViewClickDelay {
    var hash: Int = 0
    var lastClickTime: Long = 0
    var SPACE_TIME: Long = 1000
}

infix fun View.clicks(clickAction: () -> Unit) {
    this.setOnClickListener {
        if (this.hashCode() != hash) {
            hash = this.hashCode()
            lastClickTime = System.currentTimeMillis()
            clickAction()
        } else {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime > SPACE_TIME) {
                lastClickTime = System.currentTimeMillis()
                clickAction()
            }
        }
    }
}
/**
 * 防止重复点击
 */
var lastClickTime = 0L
fun View.setOnclickNoRepeat(interval: Long = 500, onClick: (View) -> Unit) {
    this.setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && (currentTime - lastClickTime < interval)) {
            return@setOnClickListener
        }
        lastClickTime = currentTime
        onClick.invoke(it)
    }
}
