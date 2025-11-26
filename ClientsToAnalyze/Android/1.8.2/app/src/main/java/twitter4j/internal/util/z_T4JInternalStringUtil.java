package twitter4j.internal.util;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class z_T4JInternalStringUtil {
    private z_T4JInternalStringUtil() {
        throw new AssertionError();
    }

    public static String maskString(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append("*");
        }
        return stringBuffer.toString();
    }

    public static String[] split(String str, String str2) {
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        int iIndexOf2 = iIndexOf;
        int length = 0;
        while (iIndexOf2 != -1) {
            arrayList.add(str.substring(length, iIndexOf2));
            length = str2.length() + iIndexOf2;
            iIndexOf2 = str.indexOf(str2, length);
        }
        if (length != str.length()) {
            arrayList.add(str.substring(length));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String join(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer(iArr.length * 11);
        for (int i : iArr) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }

    public static String join(long[] jArr) {
        StringBuffer stringBuffer = new StringBuffer(jArr.length * 11);
        for (long j : jArr) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(j);
        }
        return stringBuffer.toString();
    }

    public static String join(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(strArr.length * 11);
        for (String str : strArr) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
