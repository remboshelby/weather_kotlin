package com.example.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isNoInternetConnection:  MutableLiveData<Boolean> = MutableLiveData();

    fun addDisposible (disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun getCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }
}