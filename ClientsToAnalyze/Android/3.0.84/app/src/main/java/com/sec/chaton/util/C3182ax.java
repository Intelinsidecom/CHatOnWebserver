package com.sec.chaton.util;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.ax */
/* loaded from: classes.dex */
class C3182ax extends LinkedHashMap<String, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ C3181aw f11527a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3182ax(C3181aw c3181aw, int i, float f, boolean z) {
        super(i, f, z);
        this.f11527a = c3181aw;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        if (size() <= 5) {
            return false;
        }
        C3181aw.f11521b.put(entry.getKey(), new SoftReference(entry.getValue()));
        removeEldestEntry(entry);
        return true;
    }
}
