package com.alipay.lyf.rxjavasample.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by 01F on 2017/6/27.
 */

public class AESUtil {
    /**
     * 生成密钥
     *
     * @param keysize
     * @return
     */
    public static byte[] initKey(int keysize) {
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(keysize);  //192 256
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * AES 加密
     *
     * @param data
     * @param key
     * @return
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherBytes = cipher.doFinal(data);
            return cipherBytes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES 解密
     *
     * @param data
     * @param key
     * @return
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] plainBytes = cipher.doFinal(data);
            return plainBytes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
