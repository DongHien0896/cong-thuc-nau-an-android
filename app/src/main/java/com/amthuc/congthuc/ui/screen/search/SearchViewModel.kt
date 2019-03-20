package com.amthuc.congthuc.ui.screen.search

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.ui.base.BaseViewModel
import com.amthuc.congthuc.utils.rx.BaseSchedulerProvider

class SearchViewModel(
    private val repository: RecipeRepository,
    private val scheduler: BaseSchedulerProvider
) : BaseViewModel() {

    val recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val query: MutableLiveData<String> = MutableLiveData()
    val isBack: MutableLiveData<Boolean> = MutableLiveData(false)

    val editorListener = TextView.OnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val q = v.text.toString()
            if (!q.isEmpty()) {
                searchRecipe("%$q%")
            }
        }
        true
    }

    fun searchRecipe(q: String) {
        addDisposable(
            repository.searchRecipes(q)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe({
                    recipes.value = it
                }, {
                    errorMessage.value = it.message
                })
        )
    }

    fun clearQuery() {
        query.value = ""
    }

    fun back() {
        isBack.value = true
    }
}