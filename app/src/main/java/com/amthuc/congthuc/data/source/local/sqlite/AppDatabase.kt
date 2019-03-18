package com.amthuc.congthuc.data.source.local.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.data.model.Recipe

@Database(entities = [Category::class, Recipe::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun recipeDao(): RecipeDao
}