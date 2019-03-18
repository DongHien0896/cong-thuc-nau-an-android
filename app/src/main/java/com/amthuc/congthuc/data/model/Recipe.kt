package com.amthuc.congthuc.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *   Created by quangnv on 25/01/2019
 */

@Entity(tableName = "recipe")
@Parcelize
data class Recipe(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,
    var name: String? = null,
    var img: String? = null,
    var level: String? = null,
    var title: String? = null,
    var des: String? = null,
    var time: Int = 30,
    var serving: Int = 4,

    @Embedded
    @SerializedName("components")
    var ingredients: List<Ingredient>? = null,

    @Embedded
    @SerializedName("cook_steps")
    var cookSteps: List<Step>? = null
) : Parcelable