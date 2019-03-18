package com.amthuc.congthuc.data.repository

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.data.source.CategoryDataSource
import io.reactivex.Completable

class CategoryRepository(private val local: CategoryDataSource.Local) : CategoryDataSource.Local {

    override fun insert(category: Category): Completable = local.insert(category)

    override fun insert(categories: List<Category>): Completable = local.insert(categories)

    override fun update(category: Category): Completable = local.update(category)

    override fun delete(category: Category): Completable = local.delete(category)

    override fun getCategories(): LiveData<List<Category>> = local.getCategories()
}