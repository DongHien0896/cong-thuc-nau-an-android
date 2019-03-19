package com.amthuc.congthuc.di

import com.amthuc.congthuc.ui.screen.categories.CategoriesViewModel
import com.amthuc.congthuc.ui.screen.recipe.RecipeViewModel
import com.amthuc.congthuc.ui.screen.detail.DetailViewModel
import com.amthuc.congthuc.ui.screen.main.MainViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<MainViewModel>()
    viewModel<CategoriesViewModel>()
    viewModel<RecipeViewModel>()
    viewModel<DetailViewModel>()
}