package com.lsk.ciper;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @Author:林立可
 * @Date:2021/8/20 15:05
 * @PackageName:20data_structure com.lsk.ciper
 * @Description:
 */
public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "1";
        String encode = Base64.encode(s.getBytes("UTF8"));
        byte[] bytes = s.getBytes();
        for(byte b:bytes){
            System.out.println(b);
            System.out.println(Integer.toBinaryString(b));
        }
        System.out.println(encode);
    }
}
