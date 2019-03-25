package com.amthuc.congthuc.utils

import androidx.navigation.navOptions
import com.amthuc.congthuc.R

fun createNavOptions() = navOptions {
    anim {
        enter = R.anim.slide_in_right
        exit = R.anim.slide_out_left
        popEnter = R.anim.slide_in_left
        popExit = R.anim.slide_out_right
    }
}

fun createNavOptions2() = navOptions {
    anim {
        enter = R.anim.slide_in_right
        exit = R.anim.slide_out_left_2
        popEnter = R.anim.slide_in_left
        popExit = R.anim.slide_out_right
    }
}