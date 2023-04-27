package com.soldevcode.evmapbox.data.local

import androidx.room.TypeConverter
import com.soldevcode.evmapbox.data.remote.dto.AddressInfo
import com.soldevcode.evmapbox.data.remote.dto.ConnectionType
import com.soldevcode.evmapbox.data.remote.dto.Connections
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
object ConnectionTypeConverter {
    @TypeConverter
    fun fromString(value: String?): ConnectionType {
        val listType: Type = object : TypeToken<ConnectionType?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ConnectionType): String {
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