package com.amthuc.congthuc.ui.screen.recipe

import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.databinding.ItemRecipeBinding
import com.amthuc.congthuc.ui.base.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipeAdapter(private val listener: (Recipe, ImageView, Int) -> Unit) :
    BaseRecyclerAdapter<Recipe, ItemRecipeBinding>(object : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean =
            oldItem == newItem
    }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_recipe

    override fun bindView(binding: ItemRecipeBinding, item: Recipe, position: Int) {
        ViewCompat.setTransitionName(binding.imageRecipe, "transition$position")
        binding.apply {
            root.setOnClickListener {view ->
                item.apply {
                    listener.invoke(this, view.imageRecipe, position)
                }
            }
        }
    }
}