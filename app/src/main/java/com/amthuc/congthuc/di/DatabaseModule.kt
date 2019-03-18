package com.amthuc.congthuc.di

import android.content.Context
import androidx.room.Room
import com.amthuc.congthuc.data.source.local.sqlite.AppDatabase
import com.amthuc.congthuc.utils.Constants
import org.koin.dsl.module.module

val databaseModule = module {
    single { createDatabase(get()) }
    single { createCategoryDao(get()) }
    single { createRecipeDao(get()) }
}

fun createDatabase(context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME)

fun createCategoryDao(database: AppDatabase) = database.categoryDao()

fun createRecipeDao(database: AppDatabase) = database.recipeDao()