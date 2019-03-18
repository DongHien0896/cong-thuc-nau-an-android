package com.amthuc.congthuc.di

import com.amthuc.congthuc.utils.rx.BaseSchedulerProvider
import com.amthuc.congthuc.utils.rx.SchedulerProvider
import org.koin.dsl.module.module
import org.koin.experimental.builder.singleBy

val rxModule = module {
    singleBy<BaseSchedulerProvider, SchedulerProvider>()
}