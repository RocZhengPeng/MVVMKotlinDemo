package com.zp.mvvmkotlindemo.data.db

import android.preference.PreferenceManager
import com.zp.mvvmkotlindemo.MyApplication

/**
 * Created by zhengpeng on 2019/4/15.
 * 负责数据存储
 */
class MainDao {
    fun getCachedWeatherInfo(): String? {
        val token = PreferenceManager.getDefaultSharedPreferences(MyApplication.context).getString("token", null)
        if (token != null) {
            return token
        }
        return null
    }
}