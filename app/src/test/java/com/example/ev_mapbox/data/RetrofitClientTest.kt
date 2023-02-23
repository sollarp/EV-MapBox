package com.example.call_mapbox_api.data

import com.example.ev_mapbox.data.RetrofitClient
import com.example.ev_mapbox.util.Constants.MOCK_BASE_URL
import org.junit.Test
import retrofit2.Retrofit

class RetrofitClientTest{

    @Test
    fun testRetrofitInstance() {
        //Get an instance of Retrofit
        val instance: Retrofit = RetrofitClient().retrofit
        //Assert that, Retrofit's base url matches to our BASE_URL
        assert(instance.baseUrl().toUrl().toString() == MOCK_BASE_URL)

    }
}