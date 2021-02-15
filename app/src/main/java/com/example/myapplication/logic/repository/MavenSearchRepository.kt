package com.example.myapplication.logic.repository

object MavenSearchRepository:NetRepository (){
    suspend fun getMavenList()=api.getMavenList()
}