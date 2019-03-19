package com.amthuc.congthuc.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Step(
    var step: Int = 0,
    var des: String? = null,
    var pictures: List<String>? = null
) : Parcelable