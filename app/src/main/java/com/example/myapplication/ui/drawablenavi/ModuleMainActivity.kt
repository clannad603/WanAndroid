package com.example.myapplication.ui.drawablenavi

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.ui.account.login.LoginActivity
import com.example.myapplication.ui.account.register.RegisterActivity
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.base.BaseViewModel
import com.example.myapplication.ui.drawablenavi.fragmentcollect.dashboard.DashboardFragment
import com.example.myapplication.ui.drawablenavi.fragmentcollect.home.HomeFragment
import com.example.myapplication.ui.drawablenavi.fragmentcollect.notifications.NotificationsFragment
import com.example.myapplication.ui.search.SearchActivity
import com.example.myapplication.utils.ToastUtil
import com.example.myapplication.utils.Util
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class ModuleMainActivity : BaseActivity<BaseViewModel,ActivityMain2Binding>() {

    /**
     * Drawer关联Toolbar
     */
    private fun initActionBarDrawer() {
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }
    /**
     * 初始化Fragment
     */
    private fun initFragments() {
        val viewPagerAdapter = CommonViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment())
        viewPagerAdapter.addFragment(NotificationsFragment())
        viewPagerAdapter.addFragment(DashboardFragment())
        view_pager.offscreenPageLimit = 1
        view_pager.adapter = viewPagerAdapter
    }

    override fun initData() {

    }

    override fun initListener() {
        /**
         * view_pager 滑动监听
         */
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottom_navigation.menu.getItem(position).isChecked = true
                //设置checked为true，但是不能触发ItemSelected事件，所以滑动时也要设置一下标题
                when (position) {
                    0 -> {
                        toolbar.title = resources.getString(R.string.title_home)
                    }
                    1 -> {
                        toolbar.title = resources.getString(R.string.title_dashboard)
                    }
                    2 -> {
                        toolbar.title = resources.getString(R.string.title_notifications)
                    }
                    else -> {
                        toolbar.title = resources.getString(R.string.welcome)
                    }
                }
            }
        })
        /**
         * bottom_navigation 点击事件
         */
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    view_pager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false
        }

    }

    override fun initView() {
        /**
         * 侧边栏点击事件
         */
        initActionBarDrawer()
        initFragments()
        nav_view.setNavigationItemSelectedListener {
            // Handle navigation view item clicks here.
            when (it.itemId) {
                R.id.nav_home -> {
                    if (vm.isLogin.value==="true"){
                    startAnotherActivity(LoginActivity::class.java)}else{
                        ToastUtil.showLongToast(this,"已登陆")
                    }
                }
                /***
                 * 在这里跳转至其他活动，预计
                 */
                R.id.nav_gallery->{
                    startAnotherActivity(MainActivity::class.java)
                }
            }
            //关闭侧边栏
            drawer_layout.closeDrawer(GravityCompat.START)

            true
        }
        search_button.setOnClickListener {
            startAnotherActivity(SearchActivity::class.java)
        }
    }

    override fun initVM() {

    }
}