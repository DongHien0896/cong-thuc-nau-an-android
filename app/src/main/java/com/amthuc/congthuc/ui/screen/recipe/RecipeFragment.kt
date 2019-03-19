package com.amthuc.congthuc.ui.screen.recipe

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.databinding.FragmentRecipeBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_recipe.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel>() {

    companion object {
        const val ARGUMENT_CATEGORY = "ARGUMENT_CATEGORY"
        const val ARGUMENT_TITLE = "ARGUMENT_TITLE"
    }

    override val viewModel: RecipeViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_recipe

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val safeArgs: RecipeFragmentArgs by navArgs()
        val category = safeArgs.ARGUMENTCATEGORY

        val adapter = RecipeAdapter(::openRecipeDetail)
        setupRecyclerRecipe(adapter)

        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.getRecipesByCategory(category.id)
    }

    private fun setupRecyclerRecipe(adapter: RecipeAdapter) {
        recycler_recipe.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    private fun openRecipeDetail(recipe: Recipe) {

    }
}