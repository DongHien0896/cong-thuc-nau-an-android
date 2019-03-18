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

        fun insert(recipe: Recipe): Completable

        fun insert(recipes: List<Recipe>): Completable

        fun update(recipe: Recipe): Completable

        fun delete(recipe: Recipe): Completable

        fun getRecipes(): LiveData<List<Recipe>>

        fun searchRecipes(q: String): LiveData<List<Recipe>>

        fun getRecipe(id: String): LiveData<Recipe>
    }
}