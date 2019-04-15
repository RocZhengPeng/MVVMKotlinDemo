package com.zp.mvvmkotlindemo.data.db

/**
 * Created by zhengpeng on 2019/4/15.
 */
object AllMainDatabase {
    private var mainDao: MainDao? = null

    fun getMainDao(): MainDao {
        if (mainDao == null) mainDao = MainDao()
        return mainDao!!
    }
}