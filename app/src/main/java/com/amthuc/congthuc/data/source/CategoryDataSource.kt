package com.amthuc.congthuc.data.source

import androidx.lifecycle.LiveData
import com.amthuc.congthuc.data.model.Category
import io.reactivex.Completable

interface CategoryDataSource {

    /**
     * Local
     */
    interface Local {

        fun insert(category: Category): Completable

        fun insert(categories: List<Category>): Completable

        fun update(category: Category): Completable

        fun delete(category: Category): Completable

        fun getCategories(): LiveData<List<Category>>
    }
}