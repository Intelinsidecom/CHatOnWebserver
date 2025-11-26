package com.sec.chaton.p018c.p022d;

import java.util.StringTokenizer;

/* compiled from: FaultCodeExtractor.java */
/* renamed from: com.sec.chaton.c.d.b */
/* loaded from: classes.dex */
public class C0497b {
    /* renamed from: a */
    public static String m2520a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "[]");
        String strNextToken = "";
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            i++;
            if (i == 3) {
                strNextToken = stringTokenizer.nextToken();
            } else {
                stringTokenizer.nextToken();
            }
        }
        return strNextToken;
    }
}
