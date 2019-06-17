package com.example.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    fun getRoot() : BaseActivity {
        return activity as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inject()
        return inflate(layoutInflater, container)
    }

    protected abstract fun inflate(inflater: LayoutInflater, container: ViewGroup?) : View

    protected abstract fun inject()

    public fun pushFragmentIntoFragment(fragment: BaseFragment){
        if (!childFragmentManager.popBackStackImmediate(fragment::class.qualifiedName, 0)) {
            childFragmentManager.beginTransaction()
                .replace(containerResId(), fragment,fragment::class.qualifiedName)
                .addToBackStack(fragment::class.qualifiedName)
                .commit()
        }
    }

    protected fun containerResId(): Int {
        return 0;
    }
    fun hideKeyboard(){
        if (getRoot().currentFocus==null){
            val imm = getRoot().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(getRoot().currentFocus.windowToken, 0)
        }
    }
}