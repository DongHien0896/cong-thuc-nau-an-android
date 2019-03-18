package com.amthuc.congthuc.data.source.local

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.data.source.CategoryDataSource
import com.amthuc.congthuc.data.source.local.sqlite.CategoryDao

class CategoryLocalDataSource(private val dao: CategoryDao) : CategoryDataSource.Local {

    override fun insert(category: Category) = dao.insert(category)

    override fun insert(categories: List<Category>) = dao.insert(categories)

    override fun update(category: Category) = dao.update(category)

    override fun delete(category: Category) = dao.delete(category)

    override fun getCategories(): LiveData<List<Category>> = dao.getCategories()
}