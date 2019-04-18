package com.zp.mvvmkotlindemo.data.model.user


/**
 * Created by zhengpeng on 2019/4/15.
 */

data class Login(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val chapterTops: List<Any>,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
)