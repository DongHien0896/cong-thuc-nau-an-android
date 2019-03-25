package com.amthuc.congthuc.ui.screen.search

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Recipe
import com.amthuc.congthuc.databinding.FragmentSearchBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import com.amthuc.congthuc.ui.screen.main.MainViewModel
import com.amthuc.congthuc.ui.screen.recipe.RecipeAdapter
import com.amthuc.congthuc.utils.createNavOptions
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    private val mainViewModel: MainViewModel by sharedViewModel()

    override val viewModel: SearchViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.isShowToolbar.value = false

        val adapter = RecipeAdapter(::openRecipeDetail)

        recycler_recipe.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.isBack.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                findNavController().popBackStack()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.isShowToolbar.value = true
    }

    private fun openRecipeDetail(recipe: Recipe) {
//        findNavController().navigate(
//            R.id.recipe_detail_dest,
//            bundleOf(
//                RecipeDetailFragment.ARGUMENT_RECIPE to recipe,
//                RecipeDetailFragment.ARGUMENT_TITLE to recipe.name
//            ),
//            createNavOptions()
//        )

        findNavController().navigate(
            SearchFragmentDirections.toRecipeDetail(recipe, recipe.name!!),
            createNavOptions()
        )
    }
}