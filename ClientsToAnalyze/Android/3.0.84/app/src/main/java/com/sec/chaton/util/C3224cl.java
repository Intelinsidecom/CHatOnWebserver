package com.sec.chaton.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;

/* compiled from: StringUtils.java */
/* renamed from: com.sec.chaton.util.cl */
/* loaded from: classes.dex */
public final class C3224cl {
    /* renamed from: a */
    public static ArrayList<String> m11335a(String str, char c) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                arrayList.add(stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

    /* renamed from: a */
    public static String m11333a(String str, int i) {
        return m11334a(str, i, "...");
    }

    /* renamed from: a */
    public static String m11334a(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (i < 0) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (str.length() > i) {
                return str.substring(0, i) + str2;
            }
            return str;
        }
        return str;
    }

    /* renamed from: b */
    public static String m11336b(String str, int i, String str2) throws UnsupportedEncodingException {
        int length;
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes.length > i) {
                if (!TextUtils.isEmpty(str2) && (length = str2.getBytes("UTF-8").length) <= i) {
                    return m11336b(str, i - length, null) + str2;
                }
                CharsetDecoder charsetDecoderNewDecoder = Charset.forName("UTF-8").newDecoder();
                charsetDecoderNewDecoder.onMalformedInput(CodingErrorAction.IGNORE);
                charsetDecoderNewDecoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes, 0, i);
                CharBuffer charBufferAllocate = CharBuffer.allocate(i);
                charsetDecoderNewDecoder.decode(byteBufferWrap, charBufferAllocate, true);
                charsetDecoderNewDecoder.flush(charBufferAllocate);
                return new String(charBufferAllocate.array(), 0, charBufferAllocate.position());
            }
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public static int m11332a(String str) {
        return str.getBytes("UTF-8").length;
    }
}
