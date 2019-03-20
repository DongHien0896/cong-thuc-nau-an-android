package com.amthuc.congthuc.ui.screen.favorite

import androidx.lifecycle.MutableLiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.ui.base.BaseViewModel
import com.amthuc.congthuc.utils.rx.BaseSchedulerProvider

class FavoriteViewModel(
    private val repository: RecipeRepository,
    private val scheduler: BaseSchedulerProvider
) : BaseViewModel() {

    val recipes: MutableLiveData<List<Recipe>> = MutableLiveData()

    fun getData() {
        addDisposable(repository.getFavorite()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({
                recipes.value = it
            }, {
                errorMessage.value = it.message
            })
        )
    }
}