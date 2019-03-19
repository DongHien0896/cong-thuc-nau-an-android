package com.amthuc.congthuc.ui.widgets

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.congthuc.utils.AppUtils
import com.amthuc.congthuc.utils.Constants

class SpacesItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private var space: Int = AppUtils.dpToPx(context, Constants.SPACE_CATEGORY)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position % 2 != 0) {
            outRect.left = space / 2
            outRect.right = space
            outRect.bottom = 0
            outRect.top = space
        } else {
            outRect.left = space
            outRect.right = space / 2
            outRect.bottom = 0
            outRect.top = space
        }
    }
}