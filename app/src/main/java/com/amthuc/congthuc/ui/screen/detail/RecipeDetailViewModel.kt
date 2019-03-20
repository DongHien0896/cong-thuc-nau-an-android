package com.amthuc.congthuc.ui.screen.detail

import androidx.lifecycle.MutableLiveData
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.ui.base.BaseViewModel

class RecipeDetailViewModel : BaseViewModel() {

    val recipe: MutableLiveData<Recipe> = MutableLiveData()
}