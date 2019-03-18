package com.amthuc.congthuc.data.source.local.assets

import android.content.Context

class AssetsHelper (private val context: Context) {

    fun read(source: String): String {
        return context.assets.open(source).bufferedReader().use { it.readText() }
    }
}