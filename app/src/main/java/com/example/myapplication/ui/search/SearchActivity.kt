package com.example.myapplication.ui.search

import android.content.Intent
import android.view.Menu
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySearchBinding
import com.example.myapplication.logic.model.bean.ArticleVO
import com.example.myapplication.logic.model.bean.SearchInfo
import com.example.myapplication.ui.content.ArticleListAdapter
import com.example.myapplication.ui.content.ContentActivity
import com.example.myapplication.ui.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class SearchActivity:BaseActivity<SearchViewModel,ActivitySearchBinding>() {
    private lateinit var mAdapter: ArticleListAdapter
    private lateinit var mKey: String
    private var page: Int = 0
    var list: ArrayList<ArticleVO>? = null
    override fun initData() {

    }

    override fun initListener() {
        mAdapter.itemClick {
            val intent = Intent(mContext, ContentActivity::class.java).apply {
                putExtra(ContentActivity.WEB_URL, mAdapter.listData[it].link)
            }
            startActivity(intent)
        }

    }

    override fun initView() {
        setSupportActionBar(toolbar)
        list = ArrayList()
        mAdapter = ArticleListAdapter(mContext, list!!)
        v.mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        v.mRecyclerView.adapter = mAdapter
    }

    override fun initVM() {
        vm.articles.observe(this, Observer {
            if (page == 0) list!!.clear()
            if (it != null) {
                list!!.addAll(it)
            }
            mAdapter.notifyDataSetChanged()
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //引用menu文件
        menuInflater.inflate(R.menu.menu_search, menu)

        //找到SearchView并配置相关参数
        val searchItem = menu.findItem(R.id.action_search)
        val mSearchView = searchItem.actionView as SearchView

        //搜索图标是否显示在搜索框内
        mSearchView.setIconifiedByDefault(true)
        //设置搜索框展开时是否显示提交按钮，可不显示
        mSearchView.isSubmitButtonEnabled = true
        //让键盘的回车键设置成搜索
        mSearchView.imeOptions = EditorInfo.IME_ACTION_SEARCH
        //搜索框是否展开，false表示展开
        mSearchView.isIconified = true
        //获取焦点
        mSearchView.isFocusable = true
        mSearchView.requestFocusFromTouch()
        //设置提示词
        mSearchView.queryHint = "请输入关键字"
        //设置输入框文字颜色
        val editText = mSearchView.findViewById<EditText>(R.id.search_src_text)
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.color_DCDCDC))
        editText.setTextColor(ContextCompat.getColor(this, R.color.white))

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // 当内容不为空，点击搜索按钮时触发该方法
            override fun onQueryTextSubmit(query: String): Boolean {

                mKey = query
                page = 0 //重置分页，避免二次加载分页混乱
                //搜索请求
                val  searchInfo=SearchInfo(page,mKey)
                vm.giveSearch(searchInfo)
                //清除焦点，收软键盘
                mSearchView.clearFocus()
                return false
            }

            // 当搜索内容改变时触发该方法
            override fun onQueryTextChange(newText: String): Boolean {
                //do something
                //当没有输入任何内容的时候清除结果，看实际需求
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}