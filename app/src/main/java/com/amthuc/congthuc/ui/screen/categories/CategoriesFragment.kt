package com.amthuc.congthuc.ui.screen.categories

import com.amthuc.congthuc.R
import com.amthuc.congthuc.databinding.FragmentCategoriesBinding
import com.amthuc.congthuc.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>() {

    override val viewModel: CategoriesViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_categories
}