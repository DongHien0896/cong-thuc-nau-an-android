package com.amthuc.congthuc.data.source.local.sqlite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.amthuc.congthuc.data.model.Category

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: List<Category>)

    @Delete
    fun delete(category: Category)

    @Update
    fun update(category: Category)

    @Query("SELECT * FROM category")
    fun getCategories(): LiveData<List<Category>>
}