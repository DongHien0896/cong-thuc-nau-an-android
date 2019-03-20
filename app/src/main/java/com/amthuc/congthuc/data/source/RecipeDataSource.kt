package com.amthuc.congthuc.data.source

import com.amthuc.congthuc.data.model.Recipe
import io.reactivex.Single

/**
 *   Created by quangnv on 25/01/2019
 */

interface RecipeDataSource {

    /**
     * Local
     */
    interface Local {

        fun insert(recipe: Recipe)

        fun insert(recipes: List<Recipe>)

        fun update(recipe: Recipe)

        fun delete(recipe: Recipe)

        fun getRecipes(): Single<List<Recipe>>

        fun searchRecipes(q: String): Single<List<Recipe>>

        fun getRecipe(id: Int): Single<Recipe>

        fun getRecipesByCategory(idCategory: Int): Single<List<Recipe>>

        fun getFavorite(): Single<List<Recipe>>
    }
}