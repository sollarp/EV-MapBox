package com.example.ev_mapbox.fakeData

import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.data.remote.dto.AddressInfo
import com.example.ev_mapbox.data.remote.dto.ConnectionType
import com.example.ev_mapbox.data.remote.dto.Connections

fun fakeEvPointsEntity(): EvPointsEntity {

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
    val fakeConnectionTypeId = ConnectionType(
        FormalName = "Formal",
        IsDiscontinued = true,
        IsObsolete = false,
        ID = 3,
        Title = "title",
    )

    val fakeConnetion = Connections(
        ConnectionType = listOf(fakeConnectionTypeId),
        CurrentTypeID = 4,
        ID = 7,
        Voltage = 7,
        Amps = 9,
        LevelID = 0,
        PowerKW = 1.4,
        Quantity = 8,
        StatusTypeID = 8
    )
    return EvPointsEntity(
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
        AddressInfo = fakeAddressInfo,
        ConnectionType = listOf(fakeConnectionTypeId)
    )
}
