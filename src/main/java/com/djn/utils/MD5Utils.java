package com.djn.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author ChristmasKey
 * @date 2021-12-04-15:10
 */
public class MD5Utils {

    /**
     * MD5加密方法
     * @param str 源字符串
     * @return 加密字符串
     */
    public static String encrypt(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuilder builder = new StringBuilder("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    builder.append("0");
                }

                builder.append(Integer.toHexString(i));
            }

            //32位加密
            return builder.toString();
            //16位加密
            // return buffer.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}