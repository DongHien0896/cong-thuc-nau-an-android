package com.amthuc.congthuc.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amthuc.congthuc.data.source.remote.BaseException
import com.amthuc.congthuc.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext

/**
 *   Created by quangnv on 17/03/2019
 */

abstract class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>(false)
    val errorMessage = MutableLiveData<String>()

    // rx
    private val compositeDisposable = CompositeDisposable()

    // coroutines
    val parentJob = Job()
    val exceptionHandler: CoroutineContext = CoroutineExceptionHandler { _, throwable ->
        errorMessage.value = throwable.message
    }

    val noInternetConnectionEvent = SingleLiveEvent<Unit>()
    val connectTimeoutEvent = SingleLiveEvent<Unit>()
    val forceUpdateAppEvent = SingleLiveEvent<Unit>()
    val serverMaintainEvent = SingleLiveEvent<Unit>()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    open fun onLoadFail(throwable: Throwable) {
        when (throwable.cause) {
            is UnknownHostException -> {
                noInternetConnectionEvent.call()
            }
            is SocketTimeoutException -> {
                connectTimeoutEvent.call()
            }
            else -> {
                when (throwable) {
                    is BaseException -> {
                        when (throwable.httpCode) {
                            // custom server error code
                            else -> {

                            }
                        }
                    }
                    else -> {
                        errorMessage.value = throwable.message
                    }
                }
            }
        }
        isLoading.value = false
    }

    open fun showError(e: Throwable) {
        errorMessage.value = e.message
    }

    fun showLoading() {
        isLoading.value = true
    }

    fun hideLoading() {
        isLoading.value = false
    }

    fun onDestroy() {
        compositeDisposable.clear()
        parentJob.cancel()
    }
}