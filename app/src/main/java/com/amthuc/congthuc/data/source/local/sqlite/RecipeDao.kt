package com.amthuc.congthuc.data.source.local.sqlite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.amthuc.congthuc.data.model.Recipe
import io.reactivex.Completable

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipes: List<Recipe>): Completable

    @Delete
    fun delete(recipe: Recipe): Completable

    @Update
    fun update(recipe: Recipe): Completable

    @Query("SELECT * FROM recipe")
    fun getRecipes(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE name LIKE :name")
    fun searchRecipes(name: String): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getRecipe(id: String): LiveData<Recipe>
}