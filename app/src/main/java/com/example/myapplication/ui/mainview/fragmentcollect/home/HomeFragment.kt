package com.example.myapplication.ui.mainview.fragmentcollect.home

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.ui.content.ArticleListAdapter
import com.example.myapplication.ui.content.ContentActivity
import com.example.myapplication.ui.base.BaseFragment


class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {
    var adapter: ArticleListAdapter? = null
    var page:Int=0
    var list: ArrayList<ArticleVO>? = null
    override fun initView() {
        list = ArrayList()
        adapter = ArticleListAdapter(mContext, list!!)
        v.mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        v.mRecyclerView.adapter = adapter

    }

//    private fun initSwipeRefreshLayout() {
//        .swipeRefresh.setColorSchemeResources(
//                android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light,
//                android.R.color.holo_orange_light
//        )
//       .swipeRefresh.setOnRefreshListener {
//            .swipeRefresh.postDelayed({
//                mCurrentPage = 0v
//                mViewModel.getCollectList(mCurrentPage)
//                mBinding.swipeRefresh.isRefreshing = false
//            }, 1000)
//        }
//    }
    override fun initVM() {
            vm.articles.observe(this, Observer {
                if (page == 0) list!!.clear()
                    if (it != null) {
                        list!!.addAll(it)
                    }
                adapter!!.notifyDataSetChanged()
            })
    }

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

    }

