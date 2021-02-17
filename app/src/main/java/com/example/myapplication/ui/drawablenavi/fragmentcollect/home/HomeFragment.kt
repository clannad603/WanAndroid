package com.example.myapplication.ui.drawablenavi.fragmentcollect.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.base.BaseFragment


class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {
    override fun initView() {

    }

    override fun initVM() {
     vm.text.observe(this, Observer {
         v.textHome.text=it
     })
    }


}