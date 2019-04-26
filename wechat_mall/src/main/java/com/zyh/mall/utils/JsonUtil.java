package com.zyh.mall.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * gson操作json数据
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
