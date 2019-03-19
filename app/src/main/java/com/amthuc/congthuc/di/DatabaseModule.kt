package com.amthuc.congthuc.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.source.local.assets.read
import com.amthuc.congthuc.data.source.local.sqlite.AppDatabase
import com.amthuc.congthuc.utils.Constants
import com.amthuc.congthuc.utils.ioThread
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.dsl.module.module

val databaseModule = module {
    single { createDatabase(get()) }
    single { createCategoryDao(get()) }
    single { createRecipeDao(get()) }
}

fun createDatabase(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME).addCallback(
        object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                fillDb(context.applicationContext)
            }
        }).build()

private fun fillDb(context: Context) {
    ioThread {
        val database = createDatabase(context)

        var data = read(context, Constants.CATEGORIES_PATH)
        val gson = Gson()
        val categories: List<Category> = gson.fromJson<List<Category>>(
            data,
            object : TypeToken<List<Category>>() {}.type
        )

        database.categoryDao().insert(categories)

        for (category in categories) {
            category.source?.apply {
                data = read(context, this)
                val recipes: List<Recipe> = gson.fromJson<List<Recipe>>(
                    data,
                    object : TypeToken<List<Recipe>>() {}.type
                )
                database.recipeDao().insert(recipes)
            }
        }
    }
}

fun createCategoryDao(database: AppDatabase) = database.categoryDao()

fun createRecipeDao(database: AppDatabase) = database.recipeDao()