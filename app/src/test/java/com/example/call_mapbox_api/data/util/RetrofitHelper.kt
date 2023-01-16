package com.example.call_mapbox_api.data.util

import com.example.call_mapbox_api.data.OpenMapApi
import com.example.call_mapbox_api.util.MOCK_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun testApiInstance(baseUrl: String): OpenMapApi {

       /* val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()*/
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            //.addConverterFactory(GsonConverterFactory.create())
            //.client(mOkHttpClient)
            .build()
            .create(OpenMapApi::class.java)
    }

}


