package com.amthuc.congthuc.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 *   Created by quangnv on 25/01/2019
 */

@Entity(tableName = "category")
@Parcelize
data class Category (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    val title: String? = null,
    val source: String? = null,
    val images: List<String>? = null,
    val recipes: Int = 0
) : Parcelable