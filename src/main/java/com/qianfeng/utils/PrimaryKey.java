package com.qianfeng.utils;

import java.util.UUID;

/**
 * 生成主键工具类
 */
public  class PrimaryKey {
    public static String makePrimaryKey(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
