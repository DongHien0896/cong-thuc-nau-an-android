package com.amthuc.congthuc.data.source.local.sqlite

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun objectToString(value: List<String>): String = gson.toJson(value)

    @TypeConverter
    fun stringToObject(value: String): List<String> =
        gson.fromJson<List<String>>(value, object : TypeToken<List<String>>() {}.type)
}