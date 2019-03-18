package com.amthuc.congthuc.data.repository

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.source.RecipeDataSource
import io.reactivex.Completable

class RecipeRepository(private val local: RecipeDataSource.Local) : RecipeDataSource.Local {

    override fun insert(recipe: Recipe): Completable = local.insert(recipe)

    override fun insert(recipes: List<Recipe>): Completable = local.insert(recipes)

    override fun update(recipe: Recipe): Completable = local.update(recipe)

    override fun delete(recipe: Recipe): Completable = local.delete(recipe)

    override fun getRecipes(): LiveData<List<Recipe>> = local.getRecipes()

    override fun searchRecipes(q: String): LiveData<List<Recipe>> = local.searchRecipes(q)

    override fun getRecipe(id: String): LiveData<Recipe> = local.getRecipe(id)
}