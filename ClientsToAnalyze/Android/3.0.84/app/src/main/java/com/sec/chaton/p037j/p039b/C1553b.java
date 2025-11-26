package com.sec.chaton.p037j.p039b;

import java.util.StringTokenizer;

/* compiled from: FaultCodeExtractor.java */
/* renamed from: com.sec.chaton.j.b.b */
/* loaded from: classes.dex */
public class C1553b {
    /* renamed from: a */
    public static String m6588a(String str) {
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

    /* renamed from: b */
    public static String m6589b(String str) {
        if (new StringTokenizer(str, "[]").countTokens() > 3) {
            return m6588a(str);
        }
        return null;
    }
}
