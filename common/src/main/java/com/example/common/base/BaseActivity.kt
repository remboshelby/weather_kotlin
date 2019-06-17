package com.example.common.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    fun pushFragment(fragment: BaseFragment, shoudlAddToBackStack: Boolean) {
        if (!supportFragmentManager.popBackStackImmediate(fragment::class.qualifiedName, 0)) {
            if (shoudlAddToBackStack)
                supportFragmentManager.beginTransaction()
                    .replace(containerResId(), fragment, fragment::class.qualifiedName)
                    .addToBackStack(fragment::class.qualifiedName)
                    .commit()
            else
                supportFragmentManager.beginTransaction()
                    .replace(containerResId(), fragment, fragment::class.qualifiedName)
                    .commit()
        }
    }
    protected fun containerResId(): Int {
        return 0
    }
    fun removeFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
    }
}