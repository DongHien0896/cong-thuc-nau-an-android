package com.amthuc.congthuc.data.repository

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.data.source.CategoryDataSource

class CategoryRepository(private val local: CategoryDataSource.Local) : CategoryDataSource.Local {

    override fun insert(category: Category) = local.insert(category)

    override fun insert(categories: List<Category>) = local.insert(categories)

    override fun update(category: Category) = local.update(category)

    override fun delete(category: Category) = local.delete(category)

    override fun getCategories(): LiveData<List<Category>> = local.getCategories()
}