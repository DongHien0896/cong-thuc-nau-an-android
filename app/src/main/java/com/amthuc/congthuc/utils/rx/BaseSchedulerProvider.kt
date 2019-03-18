package com.amthuc.congthuc.utils.rx

import io.reactivex.Scheduler

interface BaseSchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}