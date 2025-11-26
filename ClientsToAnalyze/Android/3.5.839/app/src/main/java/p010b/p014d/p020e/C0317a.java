package p010b.p014d.p020e;

import java.util.ArrayList;

/* compiled from: z_T4JInternalStringUtil.java */
/* renamed from: b.d.e.a */
/* loaded from: classes.dex */
public class C0317a {
    /* renamed from: a */
    public static String m1073a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String[] m1074a(String str, String str2) {
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
}
