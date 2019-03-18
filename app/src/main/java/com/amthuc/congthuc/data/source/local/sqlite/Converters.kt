package com.amthuc.congthuc.data.source.local.sqlite

import androidx.room.TypeConverter
import com.amthuc.congthuc.data.model.Ingredient
import com.amthuc.congthuc.data.model.Step
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun objectToString(value: List<String>): String = gson.toJson(value)

    @TypeConverter
    fun stringToObject(value: String): List<String> =
        gson.fromJson<List<String>>(value, object : TypeToken<List<String>>() {}.type)

    @TypeConverter
    fun ingredientToString(value: List<Ingredient>): String = gson.toJson(value)

    @TypeConverter
    fun stringToIngredient(value: String): List<Ingredient> =
        gson.fromJson<List<Ingredient>>(value, object : TypeToken<List<Ingredient>>() {}.type)

    @TypeConverter
    fun stepToString(value: List<Step>): String = gson.toJson(value)

    @TypeConverter
    fun stringToStep(value: String): List<Step> =
        gson.fromJson<List<Step>>(value, object : TypeToken<List<Step>>() {}.type)
}