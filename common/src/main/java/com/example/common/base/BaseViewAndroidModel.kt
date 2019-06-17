package com.example.common.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewAndroidModel(application: Application) : AndroidViewModel(application) {
    val compositeDisposable = CompositeDisposable()
    var isNoInternetConnection = MutableLiveData<Boolean>()

    protected fun addDisposible(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun onViewCreated() {}

}