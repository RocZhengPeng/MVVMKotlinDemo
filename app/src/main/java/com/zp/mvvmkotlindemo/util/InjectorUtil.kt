package com.zp.mvvmkotlindemo.util


import com.zp.mvvmkotlindemo.data.MainRepository
import com.zp.mvvmkotlindemo.data.db.AllMainDatabase
import com.zp.mvvmkotlindemo.data.network.MainNetwork
import com.zp.mvvmkotlindemo.ui.MainModelFactory
import com.zp.mvvmkotlindemo.ui.login.LoginModelFactory

object InjectorUtil {

    private fun getWeatherRepository() = MainRepository.getInstance(AllMainDatabase.getMainDao(), MainNetwork.getInstance())

    fun getMainModelFactory() = MainModelFactory(getWeatherRepository())

    fun getLoginModelFactory() = LoginModelFactory(getWeatherRepository())

}