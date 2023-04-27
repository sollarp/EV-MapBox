package com.soldevcode.call_mapbox_api.data

import com.soldevcode.evmapbox.data.RetrofitClient
import com.soldevcode.evmapbox.util.Constants.MOCK_BASE_URL
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