package com.lsk.ciper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:林立可
 * @Date:2021/8/20 15:43
 * @PackageName:20data_structure com.lsk.ciper
 * @Description:
 */
public class MessageDigestTest {
    public static void main(String[] args) throws Exception {
        String input = "林立可";
        String md5 = getDigest(input, "MD5");
        System.out.println(md5);

        String sha1 = getDigest(input, "SHA-1");
        System.out.println(sha1);

        String sha256 = getDigest(input, "SHA-256");
        System.out.println(sha256);

        String sha512 = getDigest(input, "SHA-512");
        System.out.println(sha512);
    }

    public static String toHex(byte[] bytes) {
        //        消息摘要通常使用十六进制显示
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
//            首先toHexString传参为32位的int，8位的byte通过&0xff,能够取最低的8位，保证byte向上转型的的不变性
//            我们以前的十进制不会涉及此问题，所以没有怎么关注
//            0x表示十六进制，ff表示二进制下的1111 1111
            String string = Integer.toHexString(b & 0xff);
            if (string.length() == 1) {
                string = "0" + string;
            }
            sb.append(string);
        }
        return sb.toString();
    }

    private static String getDigest(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(algorithm);
        byte[] digest = instance.digest(input.getBytes());
        System.out.println("消息签名长度为：" + digest.length);
        return toHex(digest);
    }

}
