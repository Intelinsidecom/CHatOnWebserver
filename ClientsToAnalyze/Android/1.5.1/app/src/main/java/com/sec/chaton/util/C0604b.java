package com.sec.chaton.util;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.sec.chaton.util.b */
/* loaded from: classes.dex */
class C0604b extends LinkedHashMap {

    /* renamed from: a */
    final /* synthetic */ ImageDownloader f3769a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0604b(ImageDownloader imageDownloader, int i, float f, boolean z) {
        super(i, f, z);
        this.f3769a = imageDownloader;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        if (size() <= 5) {
            return false;
        }
        ImageDownloader.f3679b.put(entry.getKey(), new SoftReference(entry.getValue()));
        removeEldestEntry(entry);
        return true;
    }
}
