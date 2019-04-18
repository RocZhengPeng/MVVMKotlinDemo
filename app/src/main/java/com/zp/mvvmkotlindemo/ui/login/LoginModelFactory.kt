package com.zp.mvvmkotlindemo.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zp.mvvmkotlindemo.data.MainRepository

/**
 * Created by zhengpeng on 2019/4/15.
 */
class LoginModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(mainRepository) as T
    }
}