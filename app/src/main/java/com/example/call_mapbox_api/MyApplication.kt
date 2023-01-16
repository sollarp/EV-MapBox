package com.example.call_mapbox_api

import android.app.Application
import android.content.Context
import com.example.call_mapbox_api.domain.SearchListUseCase
import com.example.call_mapbox_api.util.AppContainer

class MyApplication : Application() {

    fun getMyApp(): SearchListUseCase {
        return AppContainer().getSearchListUseCase()
    }

     override fun onCreate() {
         super.onCreate()
         appContext = this
     }

     companion object {
         lateinit var appContext: Context
     }
}