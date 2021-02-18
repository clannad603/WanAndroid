package com.example.myapplication.logic.repository

class RegisterRepository:NetRepository() {
    fun register(username: String, password: String, repassword: String) =
           api.register(username, password, repassword)
}