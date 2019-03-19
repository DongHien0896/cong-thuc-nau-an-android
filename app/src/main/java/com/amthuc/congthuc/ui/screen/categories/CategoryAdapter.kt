package com.amthuc.congthuc.ui.screen.categories

import androidx.recyclerview.widget.DiffUtil
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.databinding.ItemCategoryBinding
import com.amthuc.congthuc.ui.base.BaseRecyclerAdapter

class CategoryAdapter(private val listener: (Category) -> Unit) :
    BaseRecyclerAdapter<Category, ItemCategoryBinding>(object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem == newItem
    }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_category

    override fun bindFirstTime(binding: ItemCategoryBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {
                    listener.invoke(this)
                }
            }
        }
    }
}