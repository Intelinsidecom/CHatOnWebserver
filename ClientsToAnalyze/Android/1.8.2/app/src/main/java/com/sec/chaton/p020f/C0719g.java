package com.sec.chaton.p020f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: ListItem.java */
/* renamed from: com.sec.chaton.f.g */
/* loaded from: classes.dex */
public class C0719g {

    /* renamed from: a */
    public final int f2683a;

    /* renamed from: b */
    public final Drawable f2684b;

    /* renamed from: c */
    public final int f2685c;

    public C0719g(Resources resources, int i, int i2, int i3) {
        this.f2683a = i;
        if (i2 != -1) {
            this.f2684b = resources.getDrawable(i2);
        } else {
            this.f2684b = null;
        }
        this.f2685c = i3;
    }
}
