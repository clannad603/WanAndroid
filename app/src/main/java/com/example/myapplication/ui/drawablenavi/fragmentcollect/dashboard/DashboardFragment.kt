package com.example.myapplication.ui.drawablenavi.fragmentcollect.dashboard

import androidx.lifecycle.Observer
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.ui.base.BaseFragment


class DashboardFragment : BaseFragment<DashboardViewModel,FragmentDashboardBinding>() {


    override fun initView() {

    }

    override fun initVM() {
      vm.text.observe(this, Observer {
          v.textDashboard.text=it
      })
    }
}