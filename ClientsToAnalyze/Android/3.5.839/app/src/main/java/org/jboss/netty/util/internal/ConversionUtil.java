package org.jboss.netty.util.internal;

import com.sec.chaton.privateplugin.data.Spam;

/* loaded from: classes.dex */
public class ConversionUtil {
    private static final String[] INTEGERS = {Spam.ACTIVITY_CANCEL, Spam.ACTIVITY_REPORT, Spam.ACTIVITY_CHECK, "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

    public static int toInt(Object obj) {
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(String.valueOf(obj));
    }

    public static boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0;
        }
        String strValueOf = String.valueOf(obj);
        if (strValueOf.length() == 0) {
            return false;
        }
        try {
            return Integer.parseInt(strValueOf) != 0;
        } catch (NumberFormatException e) {
            switch (Character.toUpperCase(strValueOf.charAt(0))) {
                case 'T':
                case 'Y':
                    return true;
                default:
                    return false;
            }
        }
    }
}
