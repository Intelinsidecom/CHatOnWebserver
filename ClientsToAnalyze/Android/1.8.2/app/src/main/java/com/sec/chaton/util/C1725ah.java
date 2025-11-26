package com.sec.chaton.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* compiled from: HangulJamoUtil.java */
/* renamed from: com.sec.chaton.util.ah */
/* loaded from: classes.dex */
public class C1725ah {

    /* renamed from: a */
    public static final char[] f6320a = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: b */
    public static final char[] f6321b = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};

    /* renamed from: c */
    public static final char[] f6322c = {0, 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: d */
    public static Hashtable f6323d = new Hashtable();

    /* renamed from: e */
    public static Hashtable f6324e = new Hashtable();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(f6322c[1]));
        arrayList.add(Character.valueOf(f6322c[19]));
        f6323d.put(Character.valueOf(f6322c[3]), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Character.valueOf(f6322c[4]));
        arrayList2.add(Character.valueOf(f6322c[22]));
        f6323d.put(Character.valueOf(f6322c[5]), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Character.valueOf(f6322c[4]));
        arrayList3.add(Character.valueOf(f6322c[27]));
        f6323d.put(Character.valueOf(f6322c[6]), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(Character.valueOf(f6322c[8]));
        arrayList4.add(Character.valueOf(f6322c[1]));
        f6323d.put(Character.valueOf(f6322c[9]), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(Character.valueOf(f6322c[8]));
        arrayList5.add(Character.valueOf(f6322c[16]));
        f6323d.put(Character.valueOf(f6322c[10]), arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(Character.valueOf(f6322c[8]));
        arrayList6.add(Character.valueOf(f6322c[17]));
        f6323d.put(Character.valueOf(f6322c[11]), arrayList6);
        arrayList6.add(Character.valueOf(f6322c[8]));
        arrayList6.add(Character.valueOf(f6322c[19]));
        f6323d.put(Character.valueOf(f6322c[12]), arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(Character.valueOf(f6322c[8]));
        arrayList7.add(Character.valueOf(f6322c[25]));
        f6323d.put(Character.valueOf(f6322c[13]), arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(Character.valueOf(f6322c[8]));
        arrayList8.add(Character.valueOf(f6322c[26]));
        f6323d.put(Character.valueOf(f6322c[14]), arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(Character.valueOf(f6322c[8]));
        arrayList9.add(Character.valueOf(f6322c[27]));
        f6323d.put(Character.valueOf(f6322c[15]), arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(Character.valueOf(f6322c[17]));
        arrayList10.add(Character.valueOf(f6322c[19]));
        f6323d.put(Character.valueOf(f6322c[18]), arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(Character.valueOf(f6321b[8]));
        arrayList11.add(Character.valueOf(f6321b[0]));
        f6324e.put(Character.valueOf(f6321b[9]), arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(Character.valueOf(f6321b[8]));
        arrayList12.add(Character.valueOf(f6321b[1]));
        f6324e.put(Character.valueOf(f6321b[10]), arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(Character.valueOf(f6321b[8]));
        arrayList13.add(Character.valueOf(f6321b[20]));
        f6324e.put(Character.valueOf(f6321b[11]), arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(Character.valueOf(f6321b[13]));
        arrayList14.add(Character.valueOf(f6321b[4]));
        f6324e.put(Character.valueOf(f6321b[14]), arrayList14);
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(Character.valueOf(f6321b[13]));
        arrayList15.add(Character.valueOf(f6321b[5]));
        f6324e.put(Character.valueOf(f6321b[15]), arrayList15);
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(Character.valueOf(f6321b[13]));
        arrayList16.add(Character.valueOf(f6321b[20]));
        f6324e.put(Character.valueOf(f6321b[16]), arrayList16);
        ArrayList arrayList17 = new ArrayList();
        arrayList17.add(Character.valueOf(f6321b[18]));
        arrayList17.add(Character.valueOf(f6321b[20]));
        f6324e.put(Character.valueOf(f6321b[19]), arrayList17);
    }

    /* renamed from: b */
    private static List m5901b(char c) {
        if (f6323d.containsKey(Character.valueOf(c))) {
            return (List) f6323d.get(Character.valueOf(c));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c));
        return arrayList;
    }

    /* renamed from: c */
    private static List m5902c(char c) {
        if (f6324e.containsKey(Character.valueOf(c))) {
            return (List) f6324e.get(Character.valueOf(c));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c));
        return arrayList;
    }

    /* renamed from: a */
    public static List m5899a(char c) {
        ArrayList arrayList = new ArrayList();
        if (c >= 44032 && c <= 55203) {
            int i = c - 44032;
            int i2 = i / 588;
            int i3 = i % 588;
            int i4 = i3 / 28;
            int i5 = i3 % 28;
            arrayList.add(Character.valueOf(f6320a[i2]));
            arrayList.addAll(m5902c(f6321b[i4]));
            if (i5 != 0) {
                arrayList.addAll(m5901b(f6322c[i5]));
            }
        } else {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m5897a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m5898a(m5899a(str.charAt(i))));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m5898a(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((Character) it.next()).toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m5900a(String str, String str2) {
        C1786r.m6061b("****** SEARCH : " + str + "," + str2, null);
        if (str.length() < str2.length()) {
            return false;
        }
        if (str.toUpperCase().contains(str2.toUpperCase())) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m5899a(str.charAt(i)).get(0));
        }
        if (sb.indexOf(str2) != -1) {
            return true;
        }
        try {
            int iIndexOf = m5899a(str2.charAt(0)).size() > 1 ? str.indexOf(str2.charAt(0)) : 0;
            if (iIndexOf == -1) {
                return false;
            }
            String strSubstring = str.substring(iIndexOf);
            if (strSubstring.length() < str2.length()) {
                return false;
            }
            int i2 = 0;
            while (i2 < str2.length()) {
                if (!String.valueOf(strSubstring.toUpperCase().charAt(i2)).equals(String.valueOf(str2.toUpperCase().charAt(i2)))) {
                    while (i2 < str2.length()) {
                        String strM5897a = m5897a(String.valueOf(strSubstring.toUpperCase().charAt(i2)));
                        String strM5897a2 = m5897a(String.valueOf(str2.toUpperCase().charAt(i2)));
                        String strM5897a3 = m5897a(String.valueOf(str2.charAt(i2)));
                        if (TextUtils.isEmpty(strM5897a) || TextUtils.isEmpty(strM5897a2) || TextUtils.isEmpty(strM5897a3) || !String.valueOf(strM5897a.charAt(0)).equals(String.valueOf(strM5897a2.charAt(0))) || strM5897a3.length() != 1) {
                            return false;
                        }
                        i2++;
                    }
                    return true;
                }
                i2++;
            }
            return true;
        } catch (Exception e) {
            C1786r.m6061b("****** SEARCH EXCEPTION : " + e.toString(), null);
            return false;
        }
    }
}
