package com.amthuc.congthuc.data.source.local.sqlite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.amthuc.congthuc.data.model.Category
import io.reactivex.Completable

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: List<Category>): Completable

    @Delete
    fun delete(category: Category): Completable

    @Update
    fun update(category: Category): Completable

    @Query("SELECT * FROM category")
    fun getCategories(): LiveData<List<Category>>
}