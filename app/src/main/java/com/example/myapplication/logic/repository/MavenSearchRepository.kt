package com.example.myapplication.logic.repository

object MavenSearchRepository:NetRepository (){
    fun getMavenList()=api.getMavenList()
}