package com.example.myapplication



import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentMavenBinding
import com.example.myapplication.ui.AllListAdapter

import com.example.myapplication.ui.MavenViewModel
import com.example.myapplication.ui.base.BaseActivity

/***
 * 2021.2.13 心酸日志，模拟器导致无法接收返回值
 */
class MainActivity : BaseActivity<MavenViewModel,FragmentMavenBinding> (){
   private var adapter: AllListAdapter?=null
   private var list:ArrayList<String>?=null

    override fun initData() {

    }


    override fun initListener() {
         v.MavenSearchBt.setOnClickListener {
             vm.setCheck(true)
        }
    }

    override fun initView() {
        list = ArrayList()
        adapter = AllListAdapter(mContext, list!!)
        v.recyclerView.layoutManager = LinearLayoutManager(mContext)
        v.recyclerView.adapter = adapter
    }

    override fun initVM() {
          vm.mavenLiveData.observe(this, Observer {

          it.run {

          }
          })
    }

}