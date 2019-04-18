package com.zp.mvvmkotlindemo.data.network.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by zhengpeng on 2019/4/17.
 */
interface UserService {

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("/user/login")
    fun postLogin(
        @Field("username") userName: String,
        @Field("password") password: String
    ): Call<ResponseBody>


}