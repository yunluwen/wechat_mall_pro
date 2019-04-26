package com.zyh.mall.utils;

import com.zyh.mall.enums.CodeEnum;

/**
 * 获取枚举中的值
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
