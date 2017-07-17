package com.alipay.lyf.rxjavasample.encrypt;

import com.alipay.lyf.rxjavasample.app.BaseApplication;
import com.jiang.common.utils.LogUtils;
import com.jiang.common.utils.PrefUtils;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 01F on 2017/6/29.
 */

public final class MediaEncrypt {
    private static final int REVERSE_LENGTH = 100;
    public static void deEncrypt(String strFile) {
        boolean isEncrypt = PrefUtils.getBoolean(BaseApplication.getAppContext(), strFile, false);
        LogUtils.loge("22  "+isEncrypt);
        if (isEncrypt) {
            int len = REVERSE_LENGTH;
            try {
                File f = new File(strFile);
                RandomAccessFile raf = new RandomAccessFile(f, "rw");
                long totalLen = raf.length();

                if (totalLen < REVERSE_LENGTH)
                    len = (int) totalLen;

                FileChannel channel = raf.getChannel();
                MappedByteBuffer buffer = channel.map(
                        FileChannel.MapMode.READ_WRITE, 0, REVERSE_LENGTH);
                byte tmp;
                for (int i = 0; i < len; ++i) {
                    byte rawByte = buffer.get(i);
                    tmp = (byte) (rawByte ^ i);
                    buffer.put(i, tmp);
                }
                PrefUtils.putBoolean(BaseApplication.getAppContext(), strFile, !isEncrypt);
                buffer.force();
                buffer.clear();
                channel.close();
                raf.close();
            } catch (Exception e) {
            }
        }
    }
    public static void encrypt( String strFile) {
        boolean isEncrypt = PrefUtils.getBoolean(BaseApplication.getAppContext(), strFile, false);
        LogUtils.loge("22  "+isEncrypt);
        if (!isEncrypt) {
            int len = REVERSE_LENGTH;
            try {
                File f = new File(strFile);
                RandomAccessFile raf = new RandomAccessFile(f, "rw");
                long totalLen = raf.length();

                if (totalLen < REVERSE_LENGTH)
                    len = (int) totalLen;

                FileChannel channel = raf.getChannel();
                MappedByteBuffer buffer = channel.map(
                        FileChannel.MapMode.READ_WRITE, 0, REVERSE_LENGTH);
                byte tmp;
                for (int i = 0; i < len; ++i) {
                    byte rawByte = buffer.get(i);
                    tmp = (byte) (rawByte ^ i);
                    buffer.put(i, tmp);
                }
                PrefUtils.putBoolean(BaseApplication.getAppContext(), strFile, !isEncrypt);
                buffer.force();
                buffer.clear();
                channel.close();
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
