package com.amthuc.congthuc.ui.screen.main

import com.amthuc.congthuc.data.repository.CategoryRepository
import com.amthuc.congthuc.ui.base.BaseViewModel

class MainViewModel(repository: CategoryRepository) : BaseViewModel() {

    val categories = repository.getCategories()
}