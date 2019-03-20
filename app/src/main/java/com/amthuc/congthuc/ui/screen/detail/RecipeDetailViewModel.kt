package com.amthuc.congthuc.ui.screen.detail

import androidx.lifecycle.MutableLiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.ui.base.BaseViewModel
import com.amthuc.congthuc.utils.ioThread

class RecipeDetailViewModel(
    private val repository: RecipeRepository
) : BaseViewModel() {

    val recipe: MutableLiveData<Recipe> = MutableLiveData()
    val favorite: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkFavorite() {
        if (favorite.value == true) {
            favorite.value = false
            recipe.value?.isFavorite = false
        } else {
            favorite.value = true
            recipe.value?.isFavorite = true
        }
        recipe.value?.apply {
            ioThread {
                repository.update(this)
            }
        }
    }

    fun updateRecipe() {
        recipe.value?.apply {
            favorite.value = this.isFavorite
        }
    }
}