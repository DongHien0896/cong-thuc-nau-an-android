package com.amthuc.congthuc.di

import com.amthuc.congthuc.data.repository.CategoryRepository
import com.amthuc.congthuc.data.repository.RecipeRepository
import com.amthuc.congthuc.data.source.CategoryDataSource
import com.amthuc.congthuc.data.source.RecipeDataSource
import com.amthuc.congthuc.data.source.local.CategoryLocalDataSource
import com.amthuc.congthuc.data.source.local.RecipeLocalDataSource
import org.koin.dsl.module.module
import org.koin.experimental.builder.create
import org.koin.experimental.builder.singleBy

val repositoryModule = module {
    single { create<CategoryRepository>() }
    single { create<RecipeRepository>() }
    singleBy<CategoryDataSource.Local, CategoryLocalDataSource>()
    singleBy<RecipeDataSource.Local, RecipeLocalDataSource>()
}