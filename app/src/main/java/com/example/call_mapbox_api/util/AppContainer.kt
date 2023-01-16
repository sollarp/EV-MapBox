package com.example.call_mapbox_api.util

import com.example.call_mapbox_api.MyApplication
import com.example.call_mapbox_api.data.*
import com.example.call_mapbox_api.data.local.EvPointDataBase.Companion.getInstance
import com.example.call_mapbox_api.data.repository.SearchListRepository
import com.example.call_mapbox_api.domain.SearchListUseCase
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {

    private val dataBase by lazy { getInstance(MyApplication.appContext).evPointsDao }

    private fun getRetrofitResult(): Retrofit {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()
        //  https://api.openchargemap.io/
        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://d01abe6f-6cca-4fc5-aaf9-18b2ff7178f4.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build()
        }
        return retrofit
    }

    private fun getRemoteDataSource(): EvPointRemoteDataSource {
        return EvPointRemoteDataSource(getRetrofitResult().create(OpenMapApi::class.java))
    }

    private fun getLocalDataSource(): EvPointLocalDataSource{
        return EvPointLocalDataSource(dataBase)
    }

    private fun getDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    fun getSearchListUseCase(): SearchListUseCase {
        return SearchListUseCase(getRepository(), getDispatcher())
    }

    private fun getRepository(): SearchListRepository {
        return SearchListRepository(getRemoteDataSource(), getLocalDataSource())
    }
}
