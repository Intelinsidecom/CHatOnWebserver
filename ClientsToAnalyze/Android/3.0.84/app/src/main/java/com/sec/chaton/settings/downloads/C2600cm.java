package com.sec.chaton.settings.downloads;

import android.graphics.Bitmap;
import android.graphics.drawable.StateListDrawable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SkinHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.cm */
/* loaded from: classes.dex */
class C2600cm extends StateListDrawable {

    /* renamed from: a */
    private List<Bitmap> f9827a;

    private C2600cm() {
        this.f9827a = new ArrayList();
    }

    /* synthetic */ C2600cm(C2592ce c2592ce) {
        this();
    }

    /* renamed from: a */
    public void m9590a(Bitmap bitmap) {
        this.f9827a.add(bitmap);
    }

    /* renamed from: a */
    public List<Bitmap> m9589a() {
        return this.f9827a;
    }
}
