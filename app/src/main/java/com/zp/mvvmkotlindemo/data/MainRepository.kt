package com.zp.mvvmkotlindemo.data

import com.zp.mvvmkotlindemo.data.db.MainDao
import com.zp.mvvmkotlindemo.data.network.MainNetwork

/**
 * Created by zhengpeng on 2019/4/15.
 * 仓库层
 * 自主判断接口请求的数据应该是从数据库中读取还是从网络中获取，并将数据返回给调用方。如果是从网络中获取的话还要将这些数据存入到数据库当中，以避免下次重复从网络中获取
 */
class MainRepository private constructor(private val mainDao: MainDao, private val network: MainNetwork) {

    /**
     * 判断是否登录
     */
    fun isLogin() = mainDao.getCachedWeatherInfo() != null


    companion object {

        private var instance: MainRepository? = null

        fun getInstance(mainDao: MainDao, network: MainNetwork): MainRepository {
            if (instance == null) {
                synchronized(MainRepository::class.java) {
                    if (instance == null) {
                        instance = MainRepository(mainDao, network)
                    }
                }
            }
            return instance!!
        }

    }

}