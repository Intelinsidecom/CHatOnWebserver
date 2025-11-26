package com.vlingo.sdk.internal.util;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class UrlUtils {
    public static String extractValueForKey(String urlKey, String urlString) {
        int valueIndex = urlString.indexOf(String.valueOf(urlKey) + "=");
        if (valueIndex == -1) {
            return null;
        }
        int valueIndex2 = valueIndex + urlKey.length() + 1;
        int valueEndIndex = urlString.indexOf("&", valueIndex2 + 1);
        if (valueEndIndex == -1) {
            valueEndIndex = urlString.length();
        }
        return urlDecode(urlString.substring(valueIndex2, valueEndIndex));
    }

    public static String urlEncode(String str) {
        if (str != null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return str;
            }
        }
        return str;
    }

    public static String urlDecode(String decodeStr) {
        if (decodeStr == null) {
            return null;
        }
        int less = 0;
        StringBuffer buf = null;
        for (int i = 0; i < decodeStr.length() - 2; i++) {
            char c = decodeStr.charAt(i);
            if (c == '%') {
                try {
                    char c2 = (char) Integer.parseInt(decodeStr.substring(i + 1, i + 3), 16);
                    if (buf == null) {
                        StringBuffer buf2 = new StringBuffer(decodeStr);
                        buf = buf2;
                    }
                    buf.delete(i - less, (i - less) + 3);
                    buf.insert(i - less, c2);
                    less += 2;
                } catch (Throwable th) {
                }
            }
        }
        if (buf == null) {
            return decodeStr.replace('+', ' ');
        }
        return buf.toString().replace('+', ' ');
    }
}
