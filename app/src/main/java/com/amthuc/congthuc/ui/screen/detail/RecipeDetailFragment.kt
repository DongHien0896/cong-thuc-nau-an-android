package com.amthuc.congthuc.ui.screen.detail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.databinding.FragmentRecipeDetailBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import com.amthuc.congthuc.ui.screen.recipe.IngredientAdapter
import com.amthuc.congthuc.ui.screen.recipe.StepAdapter
import kotlinx.android.synthetic.main.fragment_recipe_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeDetailFragment : BaseFragment<FragmentRecipeDetailBinding, RecipeDetailViewModel>() {

    companion object {
        const val ARGUMENT_RECIPE = "ARGUMENT_RECIPE"
        const val ARGUMENT_TITLE = "ARGUMENT_TITLE"
    }

    override val viewModel: RecipeDetailViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_recipe_detail

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val safeArgs: RecipeDetailFragmentArgs by navArgs()
        val recipe = safeArgs.ARGUMENTRECIPE

        viewModel.recipe.value = recipe

        val adapterIngredient = IngredientAdapter()
        recycler_ingredient.apply {
            adapter = adapterIngredient
            layoutManager = LinearLayoutManager(context)
        }
        adapterIngredient.submitList(recipe.ingredients)

        val adapterStep = StepAdapter()
        recycler_step.apply {
            adapter = adapterStep
            layoutManager = LinearLayoutManager(context)
        }
        adapterStep.submitList(recipe.steps)
    }
}