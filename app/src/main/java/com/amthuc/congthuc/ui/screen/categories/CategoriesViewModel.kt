package com.amthuc.congthuc.ui.screen.categories

import com.amthuc.congthuc.data.repository.CategoryRepository
import com.amthuc.congthuc.ui.base.BaseViewModel

class CategoriesViewModel(repository: CategoryRepository) : BaseViewModel() {

    val categories = repository.getCategories()
}