package com.zp.mvvmkotlindemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zp.mvvmkotlindemo.data.MainRepository

/**
 * 主页工厂生产数据
 */
class MainModelFactory(private val repository: MainRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}