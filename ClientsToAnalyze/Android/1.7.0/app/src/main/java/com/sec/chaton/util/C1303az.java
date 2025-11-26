package com.sec.chaton.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* compiled from: HangulJamoUtil.java */
/* renamed from: com.sec.chaton.util.az */
/* loaded from: classes.dex */
public class C1303az {

    /* renamed from: a */
    public static final char[] f4507a = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: b */
    public static final char[] f4508b = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};

    /* renamed from: c */
    public static final char[] f4509c = {0, 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: d */
    public static Hashtable f4510d = new Hashtable();

    /* renamed from: e */
    public static Hashtable f4511e = new Hashtable();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(f4509c[1]));
        arrayList.add(Character.valueOf(f4509c[19]));
        f4510d.put(Character.valueOf(f4509c[3]), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Character.valueOf(f4509c[4]));
        arrayList2.add(Character.valueOf(f4509c[22]));
        f4510d.put(Character.valueOf(f4509c[5]), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Character.valueOf(f4509c[4]));
        arrayList3.add(Character.valueOf(f4509c[27]));
        f4510d.put(Character.valueOf(f4509c[6]), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(Character.valueOf(f4509c[8]));
        arrayList4.add(Character.valueOf(f4509c[1]));
        f4510d.put(Character.valueOf(f4509c[9]), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(Character.valueOf(f4509c[8]));
        arrayList5.add(Character.valueOf(f4509c[16]));
        f4510d.put(Character.valueOf(f4509c[10]), arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(Character.valueOf(f4509c[8]));
        arrayList6.add(Character.valueOf(f4509c[17]));
        f4510d.put(Character.valueOf(f4509c[11]), arrayList6);
        arrayList6.add(Character.valueOf(f4509c[8]));
        arrayList6.add(Character.valueOf(f4509c[19]));
        f4510d.put(Character.valueOf(f4509c[12]), arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(Character.valueOf(f4509c[8]));
        arrayList7.add(Character.valueOf(f4509c[25]));
        f4510d.put(Character.valueOf(f4509c[13]), arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(Character.valueOf(f4509c[8]));
        arrayList8.add(Character.valueOf(f4509c[26]));
        f4510d.put(Character.valueOf(f4509c[14]), arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(Character.valueOf(f4509c[8]));
        arrayList9.add(Character.valueOf(f4509c[27]));
        f4510d.put(Character.valueOf(f4509c[15]), arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(Character.valueOf(f4509c[17]));
        arrayList10.add(Character.valueOf(f4509c[19]));
        f4510d.put(Character.valueOf(f4509c[18]), arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(Character.valueOf(f4508b[8]));
        arrayList11.add(Character.valueOf(f4508b[0]));
        f4511e.put(Character.valueOf(f4508b[9]), arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(Character.valueOf(f4508b[8]));
        arrayList12.add(Character.valueOf(f4508b[1]));
        f4511e.put(Character.valueOf(f4508b[10]), arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(Character.valueOf(f4508b[8]));
        arrayList13.add(Character.valueOf(f4508b[20]));
        f4511e.put(Character.valueOf(f4508b[11]), arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(Character.valueOf(f4508b[13]));
        arrayList14.add(Character.valueOf(f4508b[4]));
        f4511e.put(Character.valueOf(f4508b[14]), arrayList14);
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(Character.valueOf(f4508b[13]));
        arrayList15.add(Character.valueOf(f4508b[5]));
        f4511e.put(Character.valueOf(f4508b[15]), arrayList15);
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(Character.valueOf(f4508b[13]));
        arrayList16.add(Character.valueOf(f4508b[20]));
        f4511e.put(Character.valueOf(f4508b[16]), arrayList16);
        ArrayList arrayList17 = new ArrayList();
        arrayList17.add(Character.valueOf(f4508b[18]));
        arrayList17.add(Character.valueOf(f4508b[20]));
        f4511e.put(Character.valueOf(f4508b[19]), arrayList17);
    }

    /* renamed from: b */
    private static List m4553b(char c) {
        if (f4510d.containsKey(Character.valueOf(c))) {
            return (List) f4510d.get(Character.valueOf(c));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c));
        return arrayList;
    }

    /* renamed from: c */
    private static List m4554c(char c) {
        if (f4511e.containsKey(Character.valueOf(c))) {
            return (List) f4511e.get(Character.valueOf(c));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Character.valueOf(c));
        return arrayList;
    }

    /* renamed from: a */
    public static List m4551a(char c) {
        ArrayList arrayList = new ArrayList();
        if (c >= 44032 && c <= 55203) {
            int i = c - 44032;
            int i2 = i / 588;
            int i3 = i % 588;
            int i4 = i3 / 28;
            int i5 = i3 % 28;
            arrayList.add(Character.valueOf(f4507a[i2]));
            arrayList.addAll(m4554c(f4508b[i4]));
            if (i5 != 0) {
                arrayList.addAll(m4553b(f4509c[i5]));
            }
        } else {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m4549a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m4550a(m4551a(str.charAt(i))));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m4550a(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((Character) it.next()).toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m4552a(String str, String str2) {
        C1341p.m4658b("****** SEARCH : " + str + "," + str2, null);
        if (str.length() < str2.length()) {
            return false;
        }
        if (str.toUpperCase().contains(str2.toUpperCase())) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m4551a(str.charAt(i)).get(0));
        }
        if (sb.indexOf(str2) != -1) {
            return true;
        }
        try {
            int iIndexOf = m4551a(str2.charAt(0)).size() > 1 ? str.indexOf(str2.charAt(0)) : 0;
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
                        String strM4549a = m4549a(String.valueOf(strSubstring.toUpperCase().charAt(i2)));
                        String strM4549a2 = m4549a(String.valueOf(str2.toUpperCase().charAt(i2)));
                        String strM4549a3 = m4549a(String.valueOf(str2.charAt(i2)));
                        if (TextUtils.isEmpty(strM4549a) || TextUtils.isEmpty(strM4549a2) || TextUtils.isEmpty(strM4549a3) || !String.valueOf(strM4549a.charAt(0)).equals(String.valueOf(strM4549a2.charAt(0))) || strM4549a3.length() != 1) {
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
            C1341p.m4658b("****** SEARCH EXCEPTION : " + e.toString(), null);
            return false;
        }
    }
}
