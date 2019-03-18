package com.amthuc.congthuc.data.source.local.prefs

/**
 *   Created by quangnv on 25/01/2019
 */

interface SharePrefsApi {

    fun <T> get(key: String, clazz: Class<T>): T?

    fun <T> put(key: String, data: T)

    fun delete(key: String)

    fun clear()
}
