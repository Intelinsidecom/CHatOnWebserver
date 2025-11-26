package com.sec.chaton.util;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.f */
/* loaded from: classes.dex */
class C1331f extends LinkedHashMap {

    /* renamed from: a */
    final /* synthetic */ C1308bd f4556a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1331f(C1308bd c1308bd, int i, float f, boolean z) {
        super(i, f, z);
        this.f4556a = c1308bd;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        if (size() <= 5) {
            return false;
        }
        C1308bd.f4520b.put(entry.getKey(), new SoftReference(entry.getValue()));
        removeEldestEntry(entry);
        return true;
    }
}
