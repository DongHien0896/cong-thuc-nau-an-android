package com.amthuc.congthuc.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by quangnv on 25/01/2019
 */

@Parcelize
data class Ingredient(
    var name: String? = null,
    var quantity: String? = null,
    var unit: String? = null
) : Parcelable