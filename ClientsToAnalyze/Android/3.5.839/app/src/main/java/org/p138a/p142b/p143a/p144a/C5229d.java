package org.p138a.p142b.p143a.p144a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p138a.p142b.p143a.p145b.C5233a;

/* compiled from: DecoderUtil.java */
/* renamed from: org.a.b.a.a.d */
/* loaded from: classes.dex */
public class C5229d {

    /* renamed from: a */
    private static Log f19065a = LogFactory.getLog(C5229d.class);

    /* renamed from: a */
    public static byte[] m19923a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C5230e c5230e = new C5230e(new ByteArrayInputStream(str.getBytes("US-ASCII")));
            while (true) {
                int i = c5230e.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(i);
            }
        } catch (IOException e) {
            f19065a.error(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public static byte[] m19925b(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C5226a c5226a = new C5226a(new ByteArrayInputStream(str.getBytes("US-ASCII")));
            while (true) {
                int i = c5226a.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(i);
            }
        } catch (IOException e) {
            f19065a.error(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static String m19922a(String str, String str2) {
        return new String(m19925b(str), str2);
    }

    /* renamed from: b */
    public static String m19924b(String str, String str2) {
        StringBuilder sb = new StringBuilder(128);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '_') {
                sb.append("=20");
            } else {
                sb.append(cCharAt);
            }
        }
        return new String(m19923a(sb.toString()), str2);
    }

    /* renamed from: c */
    public static String m19926c(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf("=?", i);
            int iIndexOf2 = iIndexOf == -1 ? -1 : str.indexOf("?=", iIndexOf + 2);
            if (iIndexOf2 == -1) {
                break;
            }
            int i2 = iIndexOf2 + 2;
            String strSubstring = str.substring(i, iIndexOf);
            String strM19921a = m19921a(str, iIndexOf, i2);
            if (strM19921a == null) {
                sb.append(strSubstring);
                sb.append(str.substring(iIndexOf, i2));
            } else {
                if (!z || !C5233a.m19941a(strSubstring)) {
                    sb.append(strSubstring);
                }
                sb.append(strM19921a);
            }
            z = strM19921a != null;
            i = i2;
        }
        if (i != 0) {
            sb.append(str.substring(i));
            return sb.toString();
        }
        return str;
    }

    /* renamed from: a */
    private static String m19921a(String str, int i, int i2) {
        int iIndexOf;
        String strM19922a = null;
        int iIndexOf2 = str.indexOf(63, i + 2);
        if (iIndexOf2 != i2 - 2 && (iIndexOf = str.indexOf(63, iIndexOf2 + 1)) != i2 - 2) {
            String strSubstring = str.substring(i + 2, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1, iIndexOf);
            String strSubstring3 = str.substring(iIndexOf + 1, i2 - 2);
            String strM19943c = C5233a.m19943c(strSubstring);
            if (strM19943c == null) {
                if (f19065a.isWarnEnabled()) {
                    f19065a.warn("MIME charset '" + strSubstring + "' in encoded word '" + str.substring(i, i2) + "' doesn't have a corresponding Java charset");
                }
            } else if (!C5233a.m19942b(strM19943c)) {
                if (f19065a.isWarnEnabled()) {
                    f19065a.warn("Current JDK doesn't support decoding of charset '" + strM19943c + "' (MIME charset '" + strSubstring + "' in encoded word '" + str.substring(i, i2) + "')");
                }
            } else if (strSubstring3.length() == 0) {
                if (f19065a.isWarnEnabled()) {
                    f19065a.warn("Missing encoded text in encoded word: '" + str.substring(i, i2) + "'");
                }
            } else {
                try {
                    if (strSubstring2.equalsIgnoreCase("Q")) {
                        strM19922a = m19924b(strSubstring3, strM19943c);
                    } else if (strSubstring2.equalsIgnoreCase("B")) {
                        strM19922a = m19922a(strSubstring3, strM19943c);
                    } else if (f19065a.isWarnEnabled()) {
                        f19065a.warn("Warning: Unknown encoding in encoded word '" + str.substring(i, i2) + "'");
                    }
                } catch (UnsupportedEncodingException e) {
                    if (f19065a.isWarnEnabled()) {
                        f19065a.warn("Unsupported encoding in encoded word '" + str.substring(i, i2) + "'", e);
                    }
                } catch (RuntimeException e2) {
                    if (f19065a.isWarnEnabled()) {
                        f19065a.warn("Could not decode encoded word '" + str.substring(i, i2) + "'", e2);
                    }
                }
            }
        }
        return strM19922a;
    }
}
