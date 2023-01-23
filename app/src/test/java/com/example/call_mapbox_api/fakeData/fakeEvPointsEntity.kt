package com.example.call_mapbox_api.fakeData

import com.example.call_mapbox_api.data.remote.AddressInfo
import com.example.call_mapbox_api.data.remote.Connections
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun fakeEvPointsEntity() : Flow<List<EvPointsEntity>> {

        val fakeAddressInfo = AddressInfo(
            AddressLine1 = "add1",
            AddressLine2 = "add2",
            CountryID = 4,
            DistanceUnit = 5,
            Distance = 3.4,
            ID = 4,
            Latitude = 5.6,
            Longitude = 3.2,
            Postcode = "postcode",
            StateOrProvince = "state",
            Title = "title",
            Town = "town"
        )

        val fakeConnetion = Connections(
            ConnectionTypeID = 3,
            CurrentTypeID = 4,
            ID = 7,
            Voltage = 7,
            Amps = 9,
            LevelID = 0,
            PowerKW = 1.4,
            Quantity = 8,
            StatusTypeID = 8
        )
        val fakeEvPointsEntity = EvPointsEntity(
            ID = 4,
            DateLastVerified = "Datalast",
            DataProviderID = 5,
            DataQualityLevel = 8,
            DateCreated = "datacreated",
            DateLastStatusUpdate = "date",
            NumberOfPoints = 5,
            IsRecentlyVerified = true,
            OperatorID = 3,
            StatusTypeID = 5,
            SubmissionStatusTypeID = 5,
            UUID = "uuid",
            UsageCost = "usagecostmoney",
            UsageTypeID = 5,
            Connections = listOf(fakeConnetion),
            AddressInfo = fakeAddressInfo
        )
        return flow {
            emit(listOf(fakeEvPointsEntity))
        }
    }
