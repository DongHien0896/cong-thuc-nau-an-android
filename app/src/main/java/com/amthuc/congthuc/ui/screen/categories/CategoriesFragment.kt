package com.amthuc.congthuc.ui.screen.categories

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.amthuc.congthuc.R
import com.amthuc.congthuc.databinding.FragmentCategoriesBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>() {

    override val viewModel: CategoriesViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_categories

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.categories.observe(viewLifecycleOwner, Observer {
            Log.d("test_fragment", it.size.toString())
        })
    }
}