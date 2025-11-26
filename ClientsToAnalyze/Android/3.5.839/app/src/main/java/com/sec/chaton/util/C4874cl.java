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
public final class C4874cl {
    /* renamed from: a */
    public static ArrayList<String> m18508a(String str, char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c2) {
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
    public static String m18505a(String str) {
        return str.replaceAll("^\\s+", "");
    }

    /* renamed from: a */
    public static String m18506a(String str, int i) {
        return m18507a(str, i, "...");
    }

    /* renamed from: a */
    public static String m18507a(String str, int i, String str2) {
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
    public static String m18510b(String str, int i, String str2) throws UnsupportedEncodingException {
        int length;
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes.length > i) {
                if (!TextUtils.isEmpty(str2) && (length = str2.getBytes("UTF-8").length) <= i) {
                    return m18510b(str, i - length, null) + str2;
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

    /* renamed from: b */
    public static int m18509b(String str) {
        return str.getBytes("UTF-8").length;
    }
}
