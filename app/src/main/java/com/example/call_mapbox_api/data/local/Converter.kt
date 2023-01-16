package com.example.call_mapbox_api.data.local

import androidx.room.TypeConverter
import com.example.call_mapbox_api.data.remote.AddressInfo
import com.example.call_mapbox_api.data.remote.Connections
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object ConnectionConverter {
    @TypeConverter
    fun fromString(value: String?): List<Connections> {
        val listType: Type = object : TypeToken<List<Connections?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<Connections?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}

object AddressConverter {

    @TypeConverter
    fun fromString(value: String?): AddressInfo {
        val listType: Type = object : TypeToken<AddressInfo?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: AddressInfo?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}