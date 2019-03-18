package com.amthuc.congthuc.data.source

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Category

interface CategoryDataSource {

    /**
     * Local
     */
    interface Local {

        fun insert(category: Category)

        fun insert(categories: List<Category>)

        fun update(category: Category)

        fun delete(category: Category)

        fun getCategories(): LiveData<List<Category>>
    }
}