package com.example.call_mapbox_api.homescreen.data

import com.example.call_mapbox_api.homescreen.data.EvPointDataSource
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow

class SearchListRepository(
    private val evPointDataSource: EvPointDataSource,
    //private val localData: LocalData
) {
//    val LatestList: Flow<List<EvPointDetails>> =
//        evPointDataSource.latestEVPoint.shareIn (externalScope, WhileSubscribed())
    fun getlatestList():  Flow<List<EvPointDetails>>{
        return evPointDataSource.getLatestEvPoint()
    }
}
