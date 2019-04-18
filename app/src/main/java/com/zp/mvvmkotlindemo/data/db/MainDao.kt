package com.zp.mvvmkotlindemo.data.db

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.zp.mvvmkotlindemo.MyApplication
import com.zp.mvvmkotlindemo.data.model.user.Login

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

    fun cacheLoginTaken(login: Login?) {
        if (login == null) return
        PreferenceManager.getDefaultSharedPreferences(MyApplication.context).edit()
        PreferenceManager.getDefaultSharedPreferences(MyApplication.context).edit {
            putString("token", login.data.id.toString())
        }
    }

    /**
     * kotlin扩展函数
     */
    private fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        action(editor)
        editor.apply()
    }
}