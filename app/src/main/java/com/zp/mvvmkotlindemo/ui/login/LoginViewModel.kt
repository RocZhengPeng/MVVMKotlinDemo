package com.zp.mvvmkotlindemo.ui.login

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zp.mvvmkotlindemo.MyApplication
import com.zp.mvvmkotlindemo.data.MainRepository
import kotlinx.coroutines.launch

/**
 * Created by zhengpeng on 2019/4/15.
 */
class LoginViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var userName: String = "roczheng"
    var password: String = "qq306608923"

    var loginResult = MutableLiveData<Boolean>()

    //加载进度条
    var isLoading = MutableLiveData<Boolean>()

    fun postLogin(username: String, password: String) {
        launch({
            //开始提交数据
            mainRepository.posLogin(username, password)
            loginResult.value = true
        }, {
            loginResult.value = false
            Toast.makeText(MyApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) = viewModelScope.launch {
        try {
            isLoading.value = true
            block()
        } catch (e: Throwable) {
            isLoading.value = false
            error(e)
        }
    }
}