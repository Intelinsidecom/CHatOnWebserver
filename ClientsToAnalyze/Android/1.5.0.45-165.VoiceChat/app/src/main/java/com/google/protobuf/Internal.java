package com.google.protobuf;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class Internal {

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public static String stringDefaultValue(String bytes) {
        try {
            return new String(bytes.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static ByteString bytesDefaultValue(String bytes) {
        try {
            return ByteString.copyFrom(bytes.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static boolean isValidUtf8(ByteString byteString) {
        int size = byteString.size();
        int index = 0;
        while (index < size) {
            int index2 = index + 1;
            int byte1 = byteString.byteAt(index) & 255;
            if (byte1 < 128) {
                index = index2;
            } else {
                if (byte1 < 194 || byte1 > 244 || index2 >= size) {
                    return false;
                }
                index = index2 + 1;
                int byte2 = byteString.byteAt(index2) & 255;
                if (byte2 < 128 || byte2 > 191) {
                    return false;
                }
                if (byte1 <= 223) {
                    continue;
                } else {
                    if (index >= size) {
                        return false;
                    }
                    int index3 = index + 1;
                    int byte3 = byteString.byteAt(index) & 255;
                    if (byte3 < 128 || byte3 > 191) {
                        return false;
                    }
                    if (byte1 <= 239) {
                        if (byte1 == 224 && byte2 < 160) {
                            return false;
                        }
                        if (byte1 == 237 && byte2 > 159) {
                            return false;
                        }
                        index = index3;
                    } else {
                        if (index3 >= size) {
                            return false;
                        }
                        index = index3 + 1;
                        int byte4 = byteString.byteAt(index3) & 255;
                        if (byte4 < 128 || byte4 > 191) {
                            return false;
                        }
                        if ((byte1 == 240 && byte2 < 144) || (byte1 == 244 && byte2 > 143)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
