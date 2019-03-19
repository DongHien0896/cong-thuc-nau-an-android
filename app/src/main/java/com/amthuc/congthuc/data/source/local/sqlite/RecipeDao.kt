package com.amthuc.congthuc.data.source.local.sqlite

import androidx.room.*
import com.amthuc.congthuc.data.model.Recipe
import io.reactivex.Single

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipes: List<Recipe>)

    @Delete
    fun delete(recipe: Recipe)

    @Update
    fun update(recipe: Recipe)

    @Query("SELECT * FROM recipe")
    fun getRecipes(): Single<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE name LIKE :name")
    fun searchRecipes(name: String): Single<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getRecipe(id: Int): Single<Recipe>

    @Query("SELECT * FROM recipe WHERE idCategory = :idCategory")
    fun getRecipesByCategory(idCategory: Int): Single<List<Recipe>>
}