package com.sec.chaton.util;

import java.util.ArrayList;

/* compiled from: StringUtils.java */
/* renamed from: com.sec.chaton.util.bx */
/* loaded from: classes.dex */
public final class C1768bx {
    /* renamed from: a */
    public static ArrayList m6004a(String str, char c) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                arrayList.add(stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }
}
