package org.jboss.netty.util.internal;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConversionUtil {
    private static final String[] INTEGERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

    private ConversionUtil() {
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

    public static int toInt(Object obj) {
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(String.valueOf(obj));
    }

    public static String toString(int i) {
        return (i < 0 || i >= INTEGERS.length) ? Integer.toString(i) : INTEGERS[i];
    }

    public static String[] toStringArray(Object obj) {
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        if (!(obj instanceof Iterable)) {
            return String.valueOf(obj).split("[, \\t\\n\\r\\f\\e\\a]");
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (obj2 == null) {
                arrayList.add(null);
            } else {
                arrayList.add(String.valueOf(obj2));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
