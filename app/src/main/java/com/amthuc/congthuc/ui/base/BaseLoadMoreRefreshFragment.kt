package com.amthuc.congthuc.ui.base

import androidx.databinding.ViewDataBinding
import com.amthuc.congthuc.R

/**
 *   Created by quangnv on 17/03/2019
 */

abstract class BaseLoadMoreRefreshFragment<ViewBinding : ViewDataBinding, ViewModel : BaseLoadMoreRefreshViewModel<Item>, Item> :
    BaseFragment<ViewBinding, ViewModel>() {

    override val layoutId: Int = R.layout.fragment_loadmore_refresh

    override fun handleShowLoading(isLoading: Boolean) {
        // use progress bar
    }
}