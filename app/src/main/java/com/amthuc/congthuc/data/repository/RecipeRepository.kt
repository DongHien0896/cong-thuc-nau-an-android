package com.amthuc.congthuc.data.repository

import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.source.RecipeDataSource
import io.reactivex.Single

class RecipeRepository(private val local: RecipeDataSource.Local) : RecipeDataSource.Local {

    override fun insert(recipe: Recipe) = local.insert(recipe)

    override fun insert(recipes: List<Recipe>) = local.insert(recipes)

    override fun update(recipe: Recipe) = local.update(recipe)

    override fun delete(recipe: Recipe) = local.delete(recipe)

    override fun getRecipes(): Single<List<Recipe>> = local.getRecipes()

    override fun searchRecipes(q: String): Single<List<Recipe>> = local.searchRecipes(q)

    override fun getRecipe(id: Int): Single<Recipe> = local.getRecipe(id)

    override fun getRecipesByCategory(idCategory: Int): Single<List<Recipe>> =
        local.getRecipesByCategory(idCategory)

    override fun getFavorite(): Single<List<Recipe>> = local.getFavorite()
}