package com.zp.mvvmkotlindemo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * <pre>
 *     author : svenhe
 *     e-mail : hsw@huanjv.cn
 *     time   : 2017/11/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GsonUtils {


    private static Gson gson = getGson();

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return gson.fromJson(jsonStr, objClass);
    }

    public static <T> T json2Bean(String jsonStr, Type objClass) {
        return gson.fromJson(jsonStr, objClass);
    }

    public static String toJson(Object obj) {
        String reString = gson.toJson(obj);
        return reString;
    }

    private static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String.class, new StringConverter());
        Gson gson = gsonBuilder.create();
        return gson;
    }
}
