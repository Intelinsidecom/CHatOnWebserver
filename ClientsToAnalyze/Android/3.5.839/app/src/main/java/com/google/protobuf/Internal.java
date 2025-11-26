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

    public static String stringDefaultValue(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static ByteString bytesDefaultValue(String str) {
        try {
            return ByteString.copyFrom(str.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static boolean isValidUtf8(ByteString byteString) {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int iByteAt = byteString.byteAt(i) & 255;
            if (iByteAt < 128) {
                i = i2;
            } else {
                if (iByteAt < 194 || iByteAt > 244) {
                    return false;
                }
                if (i2 >= size) {
                    return false;
                }
                int i3 = i2 + 1;
                int iByteAt2 = byteString.byteAt(i2) & 255;
                if (iByteAt2 < 128 || iByteAt2 > 191) {
                    return false;
                }
                if (iByteAt <= 223) {
                    i = i3;
                } else {
                    if (i3 >= size) {
                        return false;
                    }
                    i = i3 + 1;
                    int iByteAt3 = byteString.byteAt(i3) & 255;
                    if (iByteAt3 < 128 || iByteAt3 > 191) {
                        return false;
                    }
                    if (iByteAt <= 239) {
                        if ((iByteAt == 224 && iByteAt2 < 160) || (iByteAt == 237 && iByteAt2 > 159)) {
                            return false;
                        }
                    } else {
                        if (i >= size) {
                            return false;
                        }
                        int i4 = i + 1;
                        int iByteAt4 = byteString.byteAt(i) & 255;
                        if (iByteAt4 < 128 || iByteAt4 > 191) {
                            return false;
                        }
                        if ((iByteAt == 240 && iByteAt2 < 144) || (iByteAt == 244 && iByteAt2 > 143)) {
                            return false;
                        }
                        i = i4;
                    }
                }
            }
        }
        return true;
    }
}
