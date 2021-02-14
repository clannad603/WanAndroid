package com.example.myapplication.ui

import android.app.Activity
import com.example.myapplication.databinding.MavenItemBinding
import com.example.myapplication.ui.base.BaseAdapter


class AllListAdapter(context: Activity,listData: ArrayList<String>)
    :BaseAdapter<MavenItemBinding,String>(context,listData) {
    override fun convert(v: MavenItemBinding, t: String, position: Int) {
        v.mavenNameTv.text=t
    }

}