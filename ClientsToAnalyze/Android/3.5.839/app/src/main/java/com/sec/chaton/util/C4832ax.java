package com.sec.chaton.util;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.ax */
/* loaded from: classes.dex */
class C4832ax extends LinkedHashMap<String, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ C4831aw f17642a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4832ax(C4831aw c4831aw, int i, float f, boolean z) {
        super(i, f, z);
        this.f17642a = c4831aw;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        if (size() <= 5) {
            return false;
        }
        C4831aw.f17636b.put(entry.getKey(), new SoftReference(entry.getValue()));
        removeEldestEntry(entry);
        return true;
    }
}
