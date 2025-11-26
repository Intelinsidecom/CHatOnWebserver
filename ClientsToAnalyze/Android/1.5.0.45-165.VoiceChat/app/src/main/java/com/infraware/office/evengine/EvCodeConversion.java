package com.infraware.office.evengine;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class EvCodeConversion {
    static EvCodeConversion mEvCodeConversion = null;

    protected EvCodeConversion() {
    }

    static EvCodeConversion getCodeConversion() {
        if (mEvCodeConversion == null) {
            mEvCodeConversion = new EvCodeConversion();
        }
        return mEvCodeConversion;
    }

    String DecodeToUnicode(int nCodePage, ByteBuffer byteBuffer) {
        Charset charset;
        switch (nCodePage) {
            case 936:
                charset = Charset.forName("windows-936");
                break;
            case 949:
                charset = Charset.forName("windows-949");
                break;
            case 65001:
                charset = Charset.forName("windows-949");
                break;
            default:
                charset = Charset.forName("windows-949");
                break;
        }
        CharBuffer charBuffer = charset.decode(byteBuffer);
        String UCode = charBuffer.toString();
        return UCode;
    }

    void EncodeToAscii(int nCodePage, String str, byte[] buffer) {
        Charset charset;
        switch (nCodePage) {
            case 936:
                charset = Charset.forName("windows-936");
                break;
            case 949:
                charset = Charset.forName("windows-949");
                break;
            default:
                charset = Charset.forName("windows-949");
                break;
        }
        ByteBuffer byteBuffer = charset.encode(str);
        byteBuffer.get(buffer, 0, byteBuffer.limit());
    }
}
