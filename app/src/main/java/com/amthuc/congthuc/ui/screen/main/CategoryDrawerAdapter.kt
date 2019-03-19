package com.amthuc.congthuc.ui.screen.main

import androidx.recyclerview.widget.DiffUtil
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.databinding.ItemCategoryDrawerBinding
import com.amthuc.congthuc.ui.base.BaseRecyclerAdapter

class CategoryDrawerAdapter(val listener: (Category) -> Unit) :
    BaseRecyclerAdapter<Category, ItemCategoryDrawerBinding>(object :
        DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem == newItem
    }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_category_drawer

    override fun bindFirstTime(binding: ItemCategoryDrawerBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {
                    listener.invoke(this)
                }
            }
        }
    }
}