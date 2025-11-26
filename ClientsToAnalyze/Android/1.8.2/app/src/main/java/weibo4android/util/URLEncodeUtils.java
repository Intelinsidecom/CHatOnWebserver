package weibo4android.util;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.BitSet;

/* loaded from: classes.dex */
public class URLEncodeUtils {
    static BitSet dontNeedEncoding = new BitSet(AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT);

    static {
        for (int i = 97; i <= 122; i++) {
            dontNeedEncoding.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            dontNeedEncoding.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            dontNeedEncoding.set(i3);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
        dontNeedEncoding.set(43);
        dontNeedEncoding.set(37);
    }

    public static final boolean isURLEncoded(String str) {
        if (str == null && "".equals(str)) {
            return false;
        }
        boolean z = false;
        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c) && dontNeedEncoding.get(c)) {
                if (c == '%') {
                    z = true;
                }
            }
            return false;
        }
        return z;
    }

    public static final String encodeURL(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String decodeURL(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
