package com.sec.chaton.util;

import java.io.File;
import java.util.Comparator;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.r */
/* loaded from: classes.dex */
final class C4897r implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ String f17857a;

    C4897r(String str) {
        this.f17857a = str;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(String str, String str2) {
        return new File(new StringBuilder().append(this.f17857a).append(str).toString()).lastModified() > new File(new StringBuilder().append(this.f17857a).append(str2).toString()).lastModified() ? -1 : 1;
    }
}
