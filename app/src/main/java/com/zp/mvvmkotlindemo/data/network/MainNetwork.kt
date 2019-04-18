package com.zp.mvvmkotlindemo.data.network

import com.zp.mvvmkotlindemo.data.network.api.ServiceCreator
import com.zp.mvvmkotlindemo.data.network.api.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by zhengpeng on 2019/4/15.
 */
class MainNetwork {

    /**
     * 请求登录
     */
    private val weatherService = ServiceCreator.create(UserService::class.java)

    suspend fun postLogin(username: String, password: String) = weatherService.postLogin(username, password).await()

    companion object {

        private var network: MainNetwork? = null

        fun getInstance(): MainNetwork {
            if (network == null) {
                synchronized(MainNetwork::class.java) {
                    if (network == null) {
                        network = MainNetwork()
                    }
                }
            }
            return network!!
        }
    }

    /**
     * kotlin协程
     */
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }
}