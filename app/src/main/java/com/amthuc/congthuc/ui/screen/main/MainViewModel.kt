package com.amthuc.congthuc.ui.screen.main

import com.amthuc.congthuc.data.repository.CategoryRepository
import com.amthuc.congthuc.ui.base.BaseViewModel
import com.amthuc.congthuc.utils.rx.BaseSchedulerProvider

class MainViewModel(
    private val repository: CategoryRepository,
    private val scheduler: BaseSchedulerProvider
) : BaseViewModel() {

    val categories = repository.getCategories()
}