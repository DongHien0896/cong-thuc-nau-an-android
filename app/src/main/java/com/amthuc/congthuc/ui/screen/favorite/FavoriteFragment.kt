package com.amthuc.congthuc.ui.screen.favorite

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.databinding.FragmentFavoriteBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import com.amthuc.congthuc.ui.screen.detail.RecipeDetailFragment
import com.amthuc.congthuc.ui.screen.recipe.RecipeAdapter
import com.amthuc.congthuc.utils.createNavOptions
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    override val viewModel: FavoriteViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_favorite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = RecipeAdapter(::openRecipeDetail)

        recycler_recipe.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.getData()
    }

    private fun openRecipeDetail(recipe: Recipe) {
        findNavController().navigate(
            R.id.recipe_detail_dest,
            bundleOf(
                RecipeDetailFragment.ARGUMENT_RECIPE to recipe,
                RecipeDetailFragment.ARGUMENT_TITLE to recipe.name
            ),
            createNavOptions()
        )
    }
}