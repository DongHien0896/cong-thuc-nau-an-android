package com.amthuc.congthuc.ui.screen.recipe

import androidx.lifecycle.MutableLiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.ui.base.BaseViewModel
import com.amthuc.congthuc.utils.rx.BaseSchedulerProvider

class RecipeViewModel(
    private val repository: RecipeRepository,
    private val scheduler: BaseSchedulerProvider
) : BaseViewModel() {

    val recipes: MutableLiveData<List<Recipe>> = MutableLiveData()

    fun getRecipesByCategory(idCategory: Int) {
        addDisposable(repository.getRecipesByCategory(idCategory)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({
                recipes.value = it.toMutableList()
            }, {

            }))
    }
}