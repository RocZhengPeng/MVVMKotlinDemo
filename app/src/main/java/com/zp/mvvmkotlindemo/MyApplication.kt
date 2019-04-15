package com.zp.mvvmkotlindemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by zhengpeng on 2019/4/15.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}