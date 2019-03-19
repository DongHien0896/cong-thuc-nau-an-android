package com.amthuc.congthuc.di

import android.content.Context
import androidx.room.Room
import com.amthuc.congthuc.data.source.local.prefs.SharePrefsApi
import com.amthuc.congthuc.data.source.local.prefs.SharePrefsImpl
import com.amthuc.congthuc.data.source.local.sqlite.AppDatabase
import com.amthuc.congthuc.utils.Constants
import org.koin.dsl.module.module
import org.koin.experimental.builder.singleBy

val databaseModule = module {
    single { createDatabase(get()) }
    single { createCategoryDao(get()) }
    single { createRecipeDao(get()) }
    singleBy<SharePrefsApi, SharePrefsImpl<*>>()
}

fun createDatabase(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME).build()

fun createCategoryDao(database: AppDatabase) = database.categoryDao()

fun createRecipeDao(database: AppDatabase) = database.recipeDao()