package com.dsunsoft.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 加密工具类
 */
public class EncodeUtils {
    private static final String DEFAULT_URL_ENCODING = "UTF-8";
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String md5(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes("utf8"));
            return md5.digest().toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Base64编码.
     */
    public static String encodeBase64(byte[] input) {
        return new String(Base64.encodeBase64(input));
    }

    /**
     * Base64编码.
     *
     * @throws UnsupportedEncodingException
     */
    public static String encodeBase64(String input) throws UnsupportedEncodingException {
        return new String(Base64.encodeBase64(input.getBytes(DEFAULT_URL_ENCODING)));
    }

    /**
     * Base64解码.
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input.getBytes());
    }

    /**
     * Base64解码.
     */
    public static String decodeBase64String(String input) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(input.getBytes()), DEFAULT_URL_ENCODING);
    }

    /**
     * Base62编码。
     */
    public static String encodeBase62(byte[] input) {
        char[] chars = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
        }
        return new String(chars);
    }


    /**
     * Hex编码.
     */
    public static String encodeHex(byte[] input) {
        return new String(Hex.encodeHex(input));
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) throws DecoderException {
        return Hex.decodeHex(input.toCharArray());
    }

    /**
     * URL 编码, Encode默认为UTF-8.
     */
    public static String urlEncode(String part) throws UnsupportedEncodingException {
        return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
    }

    /**
     * URL 解码, Encode默认为UTF-8.
     */
    public static String urlDecode(String part) throws UnsupportedEncodingException {
        return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
    }
}
