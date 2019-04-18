package com.zp.mvvmkotlindemo.data

import android.util.Log
import com.google.gson.Gson
import com.zp.mvvmkotlindemo.data.db.MainDao
import com.zp.mvvmkotlindemo.data.model.user.Login
import com.zp.mvvmkotlindemo.data.network.MainNetwork
import com.zp.mvvmkotlindemo.util.GsonUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

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

    //登录
    suspend fun posLogin(userName: String, password: String): Login? {
        var login = requestLogin(userName, password)
        return login
    }

    private suspend fun requestLogin(userName: String, password: String) = withContext(Dispatchers.IO) {
        val heWeather = network.postLogin(userName, password)
        //json数据转换为实体类
        //TODO()    val login = Gson().fromJson(heWeather.string(), Login::class.javaObjectType),要分成两部，否则装换失败
        val jsonData = heWeather.string()

        val login = Gson().fromJson(jsonData, Login::class.javaObjectType)

        //存储token到本地
        mainDao.cacheLoginTaken(login)
        login
    }


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