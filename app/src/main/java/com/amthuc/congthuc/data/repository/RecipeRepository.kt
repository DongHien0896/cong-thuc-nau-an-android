package com.amthuc.congthuc.data.repository

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.source.RecipeDataSource

class RecipeRepository(private val local: RecipeDataSource.Local) : RecipeDataSource.Local {

    override fun insert(recipe: Recipe) = local.insert(recipe)

    override fun insert(recipes: List<Recipe>) = local.insert(recipes)

    override fun update(recipe: Recipe) = local.update(recipe)

    override fun delete(recipe: Recipe) = local.delete(recipe)

    override fun getRecipes(): LiveData<List<Recipe>> = local.getRecipes()

    override fun searchRecipes(q: String): LiveData<List<Recipe>> = local.searchRecipes(q)

    override fun getRecipe(id: String): LiveData<Recipe> = local.getRecipe(id)
}