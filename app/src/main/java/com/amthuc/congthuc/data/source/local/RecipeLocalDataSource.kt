package com.amthuc.congthuc.data.source.local

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.source.RecipeDataSource
import com.amthuc.congthuc.data.source.local.sqlite.RecipeDao

class RecipeLocalDataSource(private val dao: RecipeDao) : RecipeDataSource.Local {

    override fun insert(recipe: Recipe) = dao.insert(recipe)

    override fun insert(recipes: List<Recipe>) = dao.insert(recipes)

    override fun update(recipe: Recipe) = dao.update(recipe)

    override fun delete(recipe: Recipe) = dao.delete(recipe)

    override fun getRecipes(): LiveData<List<Recipe>> = dao.getRecipes()

    override fun searchRecipes(q: String): LiveData<List<Recipe>> = dao.searchRecipes(q)

    override fun getRecipe(id: String): LiveData<Recipe> = dao.getRecipe(id)
}