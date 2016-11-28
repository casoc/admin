package com.example.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author casoc
 * @version $Id: MD5Util.java, v 0.1 2016/11/28 15:09 casoc Exp $
 */
public class MD5Util {

    /**
     * 对文本进行32位小写MD5加密
     *
     * @param text
     * @return 加密后的内容
     */
    public static String textToMD5L32(String text) {
        try {
            MessageDigest md5Encoder = MessageDigest.getInstance("MD5");
            byte[] textBytes = text.getBytes();
            md5Encoder.update(textBytes);
            byte[] encodedBytes = md5Encoder.digest();
            StringBuffer resultBuffer = new StringBuffer();
            for (byte perByte : encodedBytes) {
                int bt = perByte & 0xff;
                if (bt < 16) {
                    resultBuffer.append(0);
                }
                resultBuffer.append(Integer.toHexString(bt));
            }
            return resultBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new AdminBaseException("exception.encoding");
        }
    }
}
