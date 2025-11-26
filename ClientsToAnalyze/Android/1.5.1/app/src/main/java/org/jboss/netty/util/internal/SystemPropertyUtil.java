package org.jboss.netty.util.internal;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SystemPropertyUtil {
    private SystemPropertyUtil() {
    }

    public static int get(String str, int i) {
        String str2 = get(str);
        if (str2 != null && Pattern.matches("-?[0-9]+", str2)) {
            return Integer.parseInt(str2);
        }
        return i;
    }

    public static String get(String str) {
        try {
            return System.getProperty(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String get(String str, String str2) {
        String str3 = get(str);
        return str3 == null ? str2 : str3;
    }
}
