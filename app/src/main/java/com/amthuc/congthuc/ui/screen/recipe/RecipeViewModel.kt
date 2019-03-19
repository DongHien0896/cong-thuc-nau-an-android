package com.amthuc.congthuc.ui.screen.recipe

import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.ui.base.BaseViewModel

class RecipeViewModel(repository: RecipeRepository) : BaseViewModel() {

    val recipes = repository.getRecipes()
}