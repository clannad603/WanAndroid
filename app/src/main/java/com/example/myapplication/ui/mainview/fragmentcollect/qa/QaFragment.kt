package com.example.myapplication.ui.mainview.fragmentcollect.qa

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentQaBinding
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.ui.content.ArticleListAdapter
import com.example.myapplication.ui.content.ContentActivity
import com.example.myapplication.ui.base.BaseFragment

class QaFragment:BaseFragment<QaFragmentViewModel,FragmentQaBinding>() {
    var adapter: ArticleListAdapter? = null
    var page:Int=0
    var list: ArrayList<ArticleVO>? = null
    override fun initClick() {
        adapter!!.itemClick {
            val intent = Intent(requireContext(), ContentActivity::class.java).apply {
                putExtra(ContentActivity.WEB_URL, adapter!!.listData[it].link)
            }
            startActivity(intent)
        }
    }

    override fun initData() {
        vm.giveCheck(page)
    }

    override fun initView() {
        list = ArrayList()
        adapter = ArticleListAdapter(mContext, list!!)
        v.mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        v.mRecyclerView.adapter = adapter
    }

    override fun initVM() {
        vm.articles.observe(this, Observer {
            if (page == 0) list!!.clear()
            if (it != null) {
                list!!.addAll(it)
            }
            adapter!!.notifyDataSetChanged()
        })
    }
}