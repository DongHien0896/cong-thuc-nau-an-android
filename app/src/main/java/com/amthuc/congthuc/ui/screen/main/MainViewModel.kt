package com.amthuc.congthuc.ui.screen.main

import android.app.Application
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.repository.CategoryRepository
import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.data.source.local.assets.read
import com.amthuc.congthuc.data.source.local.prefs.SharePrefsApi
import com.amthuc.congthuc.data.source.local.prefs.SharedPrefKeys
import com.amthuc.congthuc.ui.base.BaseViewModel
import com.amthuc.congthuc.utils.Constants
import com.amthuc.congthuc.utils.ioThread
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel(
    private val application: Application,
    private val prefsApi: SharePrefsApi,
    private val categoryRepository: CategoryRepository,
    private val recipeRepository: RecipeRepository
) : BaseViewModel() {

    val categories = categoryRepository.getCategories()

    fun fillDb() {
        if (prefsApi.get(SharedPrefKeys.PREF_FIRST_FILL_DB, Boolean::class.java) == true) return

        ioThread {
            var data = read(application, Constants.CATEGORIES_PATH)
            val gson = Gson()
            val categories: List<Category> = gson.fromJson<List<Category>>(
                data,
                object : TypeToken<List<Category>>() {}.type
            )
            categoryRepository.insert(categories)

            for (category in categories) {
                category.source?.apply {
                    data = read(application, this)
                    val recipes: List<Recipe> = gson.fromJson<List<Recipe>>(
                        data,
                        object : TypeToken<List<Recipe>>() {}.type
                    )
                    for (recipe in recipes) {
                        recipe.idCategory = category.id
                    }
                    recipeRepository.insert(recipes)
                }
            }
            prefsApi.put(SharedPrefKeys.PREF_FIRST_FILL_DB, true)
        }
    }
}