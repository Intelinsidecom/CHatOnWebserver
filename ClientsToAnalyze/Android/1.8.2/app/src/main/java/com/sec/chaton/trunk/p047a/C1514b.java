package com.sec.chaton.trunk.p047a;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.Iterator;

/* compiled from: BitmapCacheLoader.java */
/* renamed from: com.sec.chaton.trunk.a.b */
/* loaded from: classes.dex */
public class C1514b extends AbstractC1513a {
    @Override // com.sec.chaton.trunk.p047a.AbstractC1513a
    /* renamed from: a */
    public synchronized void mo5364a() {
        Iterator it = this.f5542a.values().iterator();
        while (it.hasNext()) {
            Bitmap bitmap = (Bitmap) ((SoftReference) it.next()).get();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        super.mo5364a();
    }
}
