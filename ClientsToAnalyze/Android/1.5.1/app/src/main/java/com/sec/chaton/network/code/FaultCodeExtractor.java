package com.sec.chaton.network.code;

import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class FaultCodeExtractor {
    /* renamed from: a */
    public static String m2825a(String str) {
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
