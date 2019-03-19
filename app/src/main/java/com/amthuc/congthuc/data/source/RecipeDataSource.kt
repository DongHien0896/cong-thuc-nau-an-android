package com.amthuc.congthuc.data.source

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Recipe
import io.reactivex.Completable

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

        fun getRecipes(): LiveData<List<Recipe>>

        fun searchRecipes(q: String): LiveData<List<Recipe>>

        fun getRecipe(id: String): LiveData<Recipe>
    }
}