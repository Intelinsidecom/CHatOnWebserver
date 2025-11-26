package com.sec.chaton.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class HangulJamoUtil {

    /* renamed from: a */
    public static final char[] f3673a = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: b */
    public static final char[] f3674b = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};

    /* renamed from: c */
    public static final char[] f3675c = {0, 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: d */
    public static Hashtable f3676d = new Hashtable();

    /* renamed from: e */
    public static Hashtable f3677e = new Hashtable();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(f3675c[1]));
        arrayList.add(Character.valueOf(f3675c[19]));
        f3676d.put(Character.valueOf(f3675c[3]), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Character.valueOf(f3675c[4]));
        arrayList2.add(Character.valueOf(f3675c[22]));
        f3676d.put(Character.valueOf(f3675c[5]), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Character.valueOf(f3675c[4]));
        arrayList3.add(Character.valueOf(f3675c[27]));
        f3676d.put(Character.valueOf(f3675c[6]), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(Character.valueOf(f3675c[8]));
        arrayList4.add(Character.valueOf(f3675c[1]));
        f3676d.put(Character.valueOf(f3675c[9]), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(Character.valueOf(f3675c[8]));
        arrayList5.add(Character.valueOf(f3675c[16]));
        f3676d.put(Character.valueOf(f3675c[10]), arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(Character.valueOf(f3675c[8]));
        arrayList6.add(Character.valueOf(f3675c[17]));
        f3676d.put(Character.valueOf(f3675c[11]), arrayList6);
        arrayList6.add(Character.valueOf(f3675c[8]));
        arrayList6.add(Character.valueOf(f3675c[19]));
        f3676d.put(Character.valueOf(f3675c[12]), arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(Character.valueOf(f3675c[8]));
        arrayList7.add(Character.valueOf(f3675c[25]));
        f3676d.put(Character.valueOf(f3675c[13]), arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(Character.valueOf(f3675c[8]));
        arrayList8.add(Character.valueOf(f3675c[26]));
        f3676d.put(Character.valueOf(f3675c[14]), arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(Character.valueOf(f3675c[8]));
        arrayList9.add(Character.valueOf(f3675c[27]));
        f3676d.put(Character.valueOf(f3675c[15]), arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(Character.valueOf(f3675c[17]));
        arrayList10.add(Character.valueOf(f3675c[19]));
        f3676d.put(Character.valueOf(f3675c[18]), arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(Character.valueOf(f3674b[8]));
        arrayList11.add(Character.valueOf(f3674b[0]));
        f3677e.put(Character.valueOf(f3674b[9]), arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(Character.valueOf(f3674b[8]));
        arrayList12.add(Character.valueOf(f3674b[1]));
        f3677e.put(Character.valueOf(f3674b[10]), arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(Character.valueOf(f3674b[8]));
        arrayList13.add(Character.valueOf(f3674b[20]));
        f3677e.put(Character.valueOf(f3674b[11]), arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(Character.valueOf(f3674b[13]));
        arrayList14.add(Character.valueOf(f3674b[4]));
        f3677e.put(Character.valueOf(f3674b[14]), arrayList14);
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(Character.valueOf(f3674b[13]));
        arrayList15.add(Character.valueOf(f3674b[5]));
        f3677e.put(Character.valueOf(f3674b[15]), arrayList15);
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(Character.valueOf(f3674b[13]));
        arrayList16.add(Character.valueOf(f3674b[20]));
        f3677e.put(Character.valueOf(f3674b[16]), arrayList16);
        ArrayList arrayList17 = new ArrayList();
        arrayList17.add(Character.valueOf(f3674b[18]));
        arrayList17.add(Character.valueOf(f3674b[20]));
        f3677e.put(Character.valueOf(f3674b[19]), arrayList17);
    }

    /* renamed from: a */
    public static String m3579a(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 = str2 + m3580a(m3581a(str.charAt(i)));
        }
        return str2;
    }

    /* renamed from: a */
    private static String m3580a(List list) {
        String str = "";
        Iterator it = list.iterator();
        while (it.hasNext()) {
            str = str + ((Character) it.next()).toString();
        }
        return str;
    }

    /* renamed from: a */
    public static List m3581a(char c) {
        ArrayList arrayList = new ArrayList();
        if (c < 44032 || c > 55203) {
            arrayList.add(Character.valueOf(c));
        } else {
            int i = c - 44032;
            int i2 = i / 588;
            int i3 = i % 588;
            int i4 = i3 / 28;
            int i5 = i3 % 28;
            arrayList.add(Character.valueOf(f3673a[i2]));
            arrayList.addAll(m3584c(f3674b[i4]));
            if (i5 != 0) {
                arrayList.addAll(m3583b(f3675c[i5]));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m3582a(String str, String str2) {
        ChatONLogWriter.m3506b("****** SEARCH : " + str + "," + str2, null);
        if (str.length() < str2.length()) {
            return false;
        }
        if (str.toUpperCase().contains(str2.toUpperCase())) {
            return true;
        }
        String str3 = "";
        for (int i = 0; i < str.length(); i++) {
            str3 = str3 + ((Character) m3581a(str.charAt(i)).get(0));
        }
        if (str3.indexOf(str2) != -1) {
            return true;
        }
        try {
            int iIndexOf = m3581a(str2.charAt(0)).size() > 1 ? str.indexOf(str2.charAt(0)) : 0;
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
                        if (!String.valueOf(m3579a(String.valueOf(strSubstring.toUpperCase().charAt(i2))).charAt(0)).equals(String.valueOf(m3579a(String.valueOf(str2.toUpperCase().charAt(i2))).charAt(0))) || m3579a(String.valueOf(str2.charAt(i2))).length() != 1) {
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
            ChatONLogWriter.m3506b("****** SEARCH EXCEPTION : " + e.toString(), null);
            return false;
        }
    }

    /* renamed from: b */
    private static List m3583b(char c) {
        if (f3676d.containsKey(Character.valueOf(c))) {
            return (List) f3676d.get(Character.valueOf(c));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c));
        return arrayList;
    }

    /* renamed from: c */
    private static List m3584c(char c) {
        if (f3677e.containsKey(Character.valueOf(c))) {
            return (List) f3677e.get(Character.valueOf(c));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c));
        return arrayList;
    }
}
