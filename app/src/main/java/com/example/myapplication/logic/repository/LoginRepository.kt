package com.example.myapplication.logic.repository

class LoginRepository:NetRepository() {
    fun login(username: String, password: String) =
            api.login(username, password)
}