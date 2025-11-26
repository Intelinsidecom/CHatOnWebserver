package com.sec.common.p056b.p060d;

/* compiled from: StringBuilderHelper.java */
/* renamed from: com.sec.common.b.d.c */
/* loaded from: classes.dex */
public class C1828c {
    /* renamed from: a */
    public static String m6207a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            try {
                sb.append(obj.toString());
            } catch (NullPointerException e) {
                sb.append("null");
            }
        }
        return sb.toString();
    }
}
