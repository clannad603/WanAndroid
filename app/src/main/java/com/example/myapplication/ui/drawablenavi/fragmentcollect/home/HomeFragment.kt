package com.example.myapplication.ui.drawablenavi.fragmentcollect.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.ui.ArticleListAdapter
import com.example.myapplication.ui.base.BaseFragment
import kotlin.concurrent.thread


class HomeFragment : BaseFragment<HomeViewModel,ActivityMainBinding>() {
    var adapter: ArticleListAdapter? = null
    var list: ArrayList<ArticleVO>? = null

    override fun initView() {
        list = ArrayList()
        adapter = ArticleListAdapter(mContext, list!!)
        adapter!!.itemClick {

        }
        v.mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        v.mRecyclerView.adapter = adapter

    }

    override fun initVM() {

            vm.giveCheck(0)
            vm.articles.observe(this, Observer {
                 v.mRecyclerView.visibility=View.VISIBLE
                 if (it != null) {
                     vm.articleList.addAll(it)
                 }
                 adapter?.notifyDataSetChanged()

            })


    }


}