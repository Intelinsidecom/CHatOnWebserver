package com.sec.p007b.p008a.p010b;

/* compiled from: StringBuilderHelper.java */
/* renamed from: com.sec.b.a.b.c */
/* loaded from: classes.dex */
public class C0114c {
    /* renamed from: a */
    public static String m587a(Object... objArr) {
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
