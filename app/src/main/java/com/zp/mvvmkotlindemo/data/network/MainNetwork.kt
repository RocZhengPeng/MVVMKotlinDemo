package com.zp.mvvmkotlindemo.data.network

/**
 * Created by zhengpeng on 2019/4/15.
 */
class MainNetwork {
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
}