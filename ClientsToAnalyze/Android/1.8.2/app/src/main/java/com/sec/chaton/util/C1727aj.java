package com.sec.chaton.util;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.aj */
/* loaded from: classes.dex */
class C1727aj extends LinkedHashMap {

    /* renamed from: a */
    final /* synthetic */ C1726ai f6332a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1727aj(C1726ai c1726ai, int i, float f, boolean z) {
        super(i, f, z);
        this.f6332a = c1726ai;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        if (size() <= 5) {
            return false;
        }
        C1726ai.f6326b.put(entry.getKey(), new SoftReference(entry.getValue()));
        removeEldestEntry(entry);
        return true;
    }
}
