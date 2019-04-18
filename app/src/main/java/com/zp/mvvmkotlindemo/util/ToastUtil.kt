package com.zp.mvvmkotlindemo.util

import android.widget.Toast
import com.zp.mvvmkotlindemo.MyApplication

/**
 * Created by zhengpeng on 2019/4/17.
 */
object ToastUtil {
    fun showToast(content: String) {
        Toast.makeText(MyApplication.context,content,Toast.LENGTH_SHORT).show()
    }
}