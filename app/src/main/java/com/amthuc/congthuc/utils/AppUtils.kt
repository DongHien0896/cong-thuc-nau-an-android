package com.amthuc.congthuc.utils

import android.content.Context
import android.util.TypedValue

object AppUtils {

    fun dpToPx(context: Context, dp: Float): Int {
        return Math.round(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.resources.displayMetrics
            )
        )
    }
}