package com.sec.chaton.p022h.p024b;

import java.util.StringTokenizer;

/* compiled from: FaultCodeExtractor.java */
/* renamed from: com.sec.chaton.h.b.b */
/* loaded from: classes.dex */
public class C0775b {
    /* renamed from: a */
    public static String m3303a(String str) {
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
