package com.amthuc.congthuc.ui.screen.detail

import androidx.recyclerview.widget.DiffUtil
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Step
import com.amthuc.congthuc.databinding.ItemStepBinding
import com.amthuc.congthuc.ui.base.BaseRecyclerAdapter

class StepAdapter :
    BaseRecyclerAdapter<Step, ItemStepBinding>(object : DiffUtil.ItemCallback<Step>() {

        override fun areItemsTheSame(oldItem: Step, newItem: Step): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Step, newItem: Step): Boolean = oldItem == newItem
    }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_step
}