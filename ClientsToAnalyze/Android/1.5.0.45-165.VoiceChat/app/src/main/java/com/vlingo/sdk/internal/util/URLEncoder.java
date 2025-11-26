package com.vlingo.sdk.internal.util;

import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/* loaded from: classes.dex */
public class URLEncoder {
    private static String _dontNeedEncoding = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ -_.*";

    public static String encode(String s, String enc) throws IOException {
        int d;
        boolean needToChange = false;
        boolean wroteUnencodedChar = false;
        StringBuffer out = new StringBuffer(s.length());
        ByteArrayOutputStream buf = new ByteArrayOutputStream(10);
        OutputStreamWriter writer = new OutputStreamWriter(buf, enc);
        int i = 0;
        while (i < s.length()) {
            int c = s.charAt(i);
            if (dontNeedEncoding(c)) {
                if (c == 32) {
                    c = 43;
                    needToChange = true;
                }
                out.append((char) c);
                wroteUnencodedChar = true;
            } else {
                if (wroteUnencodedChar) {
                    try {
                        OutputStreamWriter writer2 = new OutputStreamWriter(buf, enc);
                        wroteUnencodedChar = false;
                        writer = writer2;
                    } catch (IOException e) {
                        buf.reset();
                    }
                }
                writer.write(c);
                if (c >= 55296 && c <= 56319 && i + 1 < s.length() && (d = s.charAt(i + 1)) >= 56320 && d <= 57343) {
                    writer.write(d);
                    i++;
                }
                writer.flush();
                byte[] ba = buf.toByteArray();
                for (int j = 0; j < ba.length; j++) {
                    out.append('%');
                    char ch = CCharacter.forDigit((ba[j] >> 4) & 15, 16);
                    out.append(ch);
                    char ch2 = CCharacter.forDigit(ba[j] & ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE, 16);
                    out.append(ch2);
                }
                buf.reset();
                needToChange = true;
            }
            i++;
        }
        return needToChange ? out.toString() : s;
    }

    static class CCharacter {
        CCharacter() {
        }

        public static char forDigit(int digit, int radix) {
            if (digit >= radix || digit < 0 || radix < 2 || radix > 36) {
                return (char) 0;
            }
            if (digit < 10) {
                return (char) (digit + 48);
            }
            return (char) (digit + 87);
        }
    }

    public static boolean dontNeedEncoding(int ch) {
        int len = _dontNeedEncoding.length();
        for (int i = 0; i < len; i++) {
            if (_dontNeedEncoding.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }
}
