package com.sec.chaton.sharedialog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

/* compiled from: ShareAppItem.java */
/* renamed from: com.sec.chaton.sharedialog.c */
/* loaded from: classes.dex */
public class C3695c {

    /* renamed from: a */
    private Drawable f13308a;

    /* renamed from: b */
    private String f13309b;

    /* renamed from: c */
    private Intent f13310c;

    public C3695c(Drawable drawable, CharSequence charSequence) {
        this.f13308a = drawable;
        this.f13309b = charSequence.toString();
    }

    /* renamed from: a */
    public void m13959a(Context context, String str, Intent intent, String str2) {
        this.f13310c = new Intent(intent);
        this.f13310c.setPackage(str);
        this.f13310c.setComponent(new ComponentName(str, str2));
    }

    /* renamed from: a */
    public Drawable m13958a() {
        return this.f13308a;
    }

    /* renamed from: b */
    public String m13960b() {
        return this.f13309b;
    }

    /* renamed from: c */
    public Intent m13961c() {
        return this.f13310c;
    }
}
