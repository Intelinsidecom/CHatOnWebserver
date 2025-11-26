package com.sec.chaton.p031h;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: ListItem.java */
/* renamed from: com.sec.chaton.h.b */
/* loaded from: classes.dex */
public class C0717b {

    /* renamed from: a */
    public final int f2434a;

    /* renamed from: b */
    public final Drawable f2435b;

    /* renamed from: c */
    public final int f2436c;

    public C0717b(Resources resources, int i, int i2, int i3) {
        this.f2434a = i;
        if (i2 != -1) {
            this.f2435b = resources.getDrawable(i2);
        } else {
            this.f2435b = null;
        }
        this.f2436c = i3;
    }
}
