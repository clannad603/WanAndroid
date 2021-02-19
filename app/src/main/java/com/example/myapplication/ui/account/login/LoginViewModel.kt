package com.example.myapplication.ui.account.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.myapplication.logic.model.bean.LoginInfo
import com.example.myapplication.logic.model.bean.RegisterInfo
import com.example.myapplication.logic.repository.LoginRepository
import com.example.myapplication.logic.repository.RegisterRepository
import com.example.myapplication.ui.base.BaseViewModel

class LoginViewModel:BaseViewModel() {
    private val repository by lazy { LoginRepository() }
    private val haveBoston= MutableLiveData<LoginInfo>()
    private val login = Transformations.switchMap(haveBoston) { it->
        repository.login(it.username, it.password)
    }
    fun sendInfo(loginInfo: LoginInfo){
        haveBoston.value=loginInfo
    }
    /***
     * 转化
     */
    val loginUser = Transformations.map(login) {
        //  loading.value = false
        it.errorCode
    }
    val loginErrorMessage = Transformations.map(login) {
        //loading.value = false
        it.errorMsg
    }
}