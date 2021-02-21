package com.example.myapplication.ui.account.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMineBinding
import com.example.myapplication.ui.account.coindetai.CoinDetailActivity
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.utils.ToastUtil
import kotlin.concurrent.thread

class MineActivity : BaseActivity<MineViewModel,ActivityMineBinding>() {
    override fun initData() {
        if (isLogin){
            vm.makeLogin(true)
        }else{
            ToastUtil.showLongToast(this,"未登录")
        }
    }
    override fun initListener() {
        v.toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }
        v.btnCoin.setOnClickListener {
            startAnotherActivity(CoinDetailActivity::class.java)
        }
    }
    override fun initView() {

    }
    override fun initVM() {
       vm.userInfo.observe(this, Observer { userInfo->
               v.textViewName.text = userInfo?.username
               username=userInfo?.username.toString()
               v.textViewCoin.text=userInfo?.coinCount.toString()
               v.textViewRank.text=userInfo?.rank
               v.textViewUserCode.text=userInfo?.userId.toString()
               v.textViewLevel.text=userInfo?.level.toString()
               userLevel=userInfo?.level.toString()
    })
    }

}