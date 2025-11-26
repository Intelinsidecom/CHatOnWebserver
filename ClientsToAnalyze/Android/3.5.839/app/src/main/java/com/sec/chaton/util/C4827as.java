package com.sec.chaton.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* compiled from: HangulJamoUtil.java */
/* renamed from: com.sec.chaton.util.as */
/* loaded from: classes.dex */
public class C4827as {

    /* renamed from: f */
    private static final char[] f17621f = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: a */
    public static final char[] f17616a = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: b */
    public static final char[] f17617b = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};

    /* renamed from: c */
    public static final char[] f17618c = {0, 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: d */
    public static Hashtable<Character, List<Character>> f17619d = new Hashtable<>();

    /* renamed from: e */
    public static Hashtable<Character, List<Character>> f17620e = new Hashtable<>();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(f17618c[1]));
        arrayList.add(Character.valueOf(f17618c[19]));
        f17619d.put(Character.valueOf(f17618c[3]), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Character.valueOf(f17618c[4]));
        arrayList2.add(Character.valueOf(f17618c[22]));
        f17619d.put(Character.valueOf(f17618c[5]), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Character.valueOf(f17618c[4]));
        arrayList3.add(Character.valueOf(f17618c[27]));
        f17619d.put(Character.valueOf(f17618c[6]), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(Character.valueOf(f17618c[8]));
        arrayList4.add(Character.valueOf(f17618c[1]));
        f17619d.put(Character.valueOf(f17618c[9]), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(Character.valueOf(f17618c[8]));
        arrayList5.add(Character.valueOf(f17618c[16]));
        f17619d.put(Character.valueOf(f17618c[10]), arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(Character.valueOf(f17618c[8]));
        arrayList6.add(Character.valueOf(f17618c[17]));
        f17619d.put(Character.valueOf(f17618c[11]), arrayList6);
        arrayList6.add(Character.valueOf(f17618c[8]));
        arrayList6.add(Character.valueOf(f17618c[19]));
        f17619d.put(Character.valueOf(f17618c[12]), arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(Character.valueOf(f17618c[8]));
        arrayList7.add(Character.valueOf(f17618c[25]));
        f17619d.put(Character.valueOf(f17618c[13]), arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(Character.valueOf(f17618c[8]));
        arrayList8.add(Character.valueOf(f17618c[26]));
        f17619d.put(Character.valueOf(f17618c[14]), arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(Character.valueOf(f17618c[8]));
        arrayList9.add(Character.valueOf(f17618c[27]));
        f17619d.put(Character.valueOf(f17618c[15]), arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(Character.valueOf(f17618c[17]));
        arrayList10.add(Character.valueOf(f17618c[19]));
        f17619d.put(Character.valueOf(f17618c[18]), arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(Character.valueOf(f17617b[8]));
        arrayList11.add(Character.valueOf(f17617b[0]));
        f17620e.put(Character.valueOf(f17617b[9]), arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(Character.valueOf(f17617b[8]));
        arrayList12.add(Character.valueOf(f17617b[1]));
        f17620e.put(Character.valueOf(f17617b[10]), arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(Character.valueOf(f17617b[8]));
        arrayList13.add(Character.valueOf(f17617b[20]));
        f17620e.put(Character.valueOf(f17617b[11]), arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(Character.valueOf(f17617b[13]));
        arrayList14.add(Character.valueOf(f17617b[4]));
        f17620e.put(Character.valueOf(f17617b[14]), arrayList14);
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(Character.valueOf(f17617b[13]));
        arrayList15.add(Character.valueOf(f17617b[5]));
        f17620e.put(Character.valueOf(f17617b[15]), arrayList15);
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(Character.valueOf(f17617b[13]));
        arrayList16.add(Character.valueOf(f17617b[20]));
        f17620e.put(Character.valueOf(f17617b[16]), arrayList16);
        ArrayList arrayList17 = new ArrayList();
        arrayList17.add(Character.valueOf(f17617b[18]));
        arrayList17.add(Character.valueOf(f17617b[20]));
        f17620e.put(Character.valueOf(f17617b[19]), arrayList17);
    }

    /* renamed from: d */
    private static List<Character> m18272d(char c2) {
        if (f17619d.containsKey(Character.valueOf(c2))) {
            return f17619d.get(Character.valueOf(c2));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c2));
        return arrayList;
    }

    /* renamed from: e */
    private static List<Character> m18273e(char c2) {
        if (f17620e.containsKey(Character.valueOf(c2))) {
            return f17620e.get(Character.valueOf(c2));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c2));
        return arrayList;
    }

    /* renamed from: a */
    public static List<Character> m18267a(char c2) {
        ArrayList arrayList = new ArrayList();
        if (c2 >= 44032 && c2 <= 55203) {
            int i = c2 - 44032;
            int i2 = i / 588;
            int i3 = i % 588;
            int i4 = i3 / 28;
            int i5 = i3 % 28;
            arrayList.add(Character.valueOf(f17616a[i2]));
            arrayList.addAll(m18273e(f17617b[i4]));
            if (i5 != 0) {
                arrayList.addAll(m18272d(f17618c[i5]));
            }
        } else {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m18265a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m18266a(m18267a(str.charAt(i))));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m18266a(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m18269b(char c2) {
        for (char c3 : f17621f) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private static char m18274f(char c2) {
        return f17621f[(c2 - 44032) / 588];
    }

    /* renamed from: c */
    public static boolean m18271c(char c2) {
        return 44032 <= c2 && c2 <= 55203;
    }

    /* renamed from: a */
    public static boolean m18268a(String str, String str2) {
        int length = str.length() - str2.length();
        int length2 = str2.length();
        if (length < 0) {
            return false;
        }
        for (int i = 0; i <= length; i++) {
            int i2 = 0;
            while (i2 < length2) {
                if (m18269b(str2.charAt(i2)) && m18271c(str.charAt(i + i2))) {
                    if (m18274f(str.charAt(i + i2)) != str2.charAt(i2)) {
                        break;
                    }
                    i2++;
                } else {
                    if (str.charAt(i + i2) != str2.charAt(i2)) {
                        break;
                    }
                    i2++;
                }
            }
            if (i2 == length2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static C4872cj m18264a(String str, String str2, String str3) {
        int length = str.length() - str2.length();
        str2.length();
        String str4 = "";
        if (length < 0) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (m18271c(str.charAt(i))) {
                str4 = str4 + m18274f(str.charAt(i));
            } else {
                str4 = str4 + str.charAt(i);
            }
        }
        String str5 = "";
        for (int i2 = 0; i2 < str2.length(); i2++) {
            if (m18271c(str2.charAt(i2))) {
                str5 = str5 + m18274f(str2.charAt(i2));
            } else {
                str5 = str5 + str2.charAt(i2);
            }
        }
        int iIndexOf = str.indexOf(str2);
        return new C4872cj(iIndexOf == -1 ? str4.indexOf(str5) : iIndexOf, (str2.length() + r0) - 1);
    }

    @Deprecated
    /* renamed from: b */
    public static boolean m18270b(String str, String str2) {
        if (str.length() < str2.length()) {
            return false;
        }
        if (str.toUpperCase().contains(str2.toUpperCase())) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m18267a(str.charAt(i)).get(0));
        }
        if (sb.indexOf(str2) != -1) {
            return true;
        }
        try {
            int iIndexOf = m18267a(str2.charAt(0)).size() > 1 ? str.indexOf(str2.charAt(0)) : 0;
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
                        String strM18265a = m18265a(String.valueOf(strSubstring.toUpperCase().charAt(i2)));
                        String strM18265a2 = m18265a(String.valueOf(str2.toUpperCase().charAt(i2)));
                        String strM18265a3 = m18265a(String.valueOf(str2.charAt(i2)));
                        if (TextUtils.isEmpty(strM18265a) || TextUtils.isEmpty(strM18265a2) || TextUtils.isEmpty(strM18265a3) || !String.valueOf(strM18265a.charAt(0)).equals(String.valueOf(strM18265a2.charAt(0))) || strM18265a3.length() != 1) {
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
            C4904y.m18639b("****** SEARCH EXCEPTION : " + e.toString(), null);
            return false;
        }
    }
}
