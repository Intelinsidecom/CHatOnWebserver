package com.sec.chaton.p067j.p069b;

import java.util.StringTokenizer;

/* compiled from: FaultCodeExtractor.java */
/* renamed from: com.sec.chaton.j.b.b */
/* loaded from: classes.dex */
public class C2432b {
    /* renamed from: a */
    public static String m10533a(String str) {
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
