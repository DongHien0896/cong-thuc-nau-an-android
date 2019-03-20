package com.amthuc.congthuc.ui.screen.recipe

import androidx.recyclerview.widget.DiffUtil
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Ingredient
import com.amthuc.congthuc.databinding.ItemIngredientBinding
import com.amthuc.congthuc.ui.base.BaseRecyclerAdapter

class IngredientAdapter : BaseRecyclerAdapter<Ingredient, ItemIngredientBinding>(object :
    DiffUtil.ItemCallback<Ingredient>() {

    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean =
        oldItem == newItem
}) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_ingredient
}