package com.amthuc.congthuc.ui.screen.categories

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.databinding.FragmentCategoriesBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import com.amthuc.congthuc.ui.screen.recipe.RecipeFragment
import com.amthuc.congthuc.ui.widgets.SpacesItemDecoration
import com.amthuc.congthuc.utils.Constants
import com.amthuc.congthuc.utils.createNavOptions
import kotlinx.android.synthetic.main.fragment_categories.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>() {

    override val viewModel: CategoriesViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_categories

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = CategoryAdapter(::openCategoryDetail)
        setupRecyclerCategory(adapter)

        viewModel.categories.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun setupRecyclerCategory(adapter: CategoryAdapter) {
        recycler_category.apply {
            layoutManager = GridLayoutManager(context, Constants.GRID_RECYCLER_CATEGORY)
            addItemDecoration(SpacesItemDecoration(context))
            this.adapter = adapter
        }
    }

    private fun openCategoryDetail(category: Category) {
        val title = category.title + " (" + category.recipes.toString() + " món)"
//        findNavController().navigate(
//            R.id.recipe_dest,
//            bundleOf(
//                RecipeFragment.ARGUMENT_CATEGORY to category,
//                RecipeFragment.ARGUMENT_TITLE to title
//            ),
//            createNavOptions()
//        )

        findNavController().navigate(
            CategoriesFragmentDirections.toRecipe(category, title))
    }
}