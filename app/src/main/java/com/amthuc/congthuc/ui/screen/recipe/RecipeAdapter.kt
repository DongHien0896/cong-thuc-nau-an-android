package com.amthuc.congthuc.ui.screen.recipe

import androidx.recyclerview.widget.DiffUtil
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.databinding.ItemRecipeBinding
import com.amthuc.congthuc.ui.base.BaseRecyclerAdapter

class RecipeAdapter(private val listener: (Recipe) -> Unit) :
    BaseRecyclerAdapter<Recipe, ItemRecipeBinding>(object : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean =
            oldItem == newItem
    }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_recipe

    override fun bindFirstTime(binding: ItemRecipeBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {
                    listener.invoke(this)
                }
            }
        }
    }
}