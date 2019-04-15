package com.zp.mvvmkotlindemo.ui

import androidx.lifecycle.ViewModel
import com.zp.mvvmkotlindemo.data.MainRepository

/**
 * Created by zhengpeng on 2019/4/15.
 */
class MainViewModel(private val repository: MainRepository) : ViewModel() {
    fun isLogin() = repository.isLogin()
}