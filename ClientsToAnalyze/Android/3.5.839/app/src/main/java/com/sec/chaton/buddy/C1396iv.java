package com.sec.chaton.buddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

/* compiled from: TellFriendsFragment.java */
/* renamed from: com.sec.chaton.buddy.iv */
/* loaded from: classes.dex */
public class C1396iv {

    /* renamed from: a */
    private final Drawable f5015a;

    /* renamed from: b */
    private final String f5016b;

    /* renamed from: c */
    private Intent f5017c;

    /* renamed from: d */
    private int f5018d = 0;

    public C1396iv(Drawable drawable, CharSequence charSequence) {
        this.f5015a = drawable;
        this.f5016b = charSequence.toString();
    }

    /* renamed from: a */
    public void m7502a(Context context, String str) {
        this.f5017c = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", TellFriendsFragment.m7015a(context));
        this.f5017c.setPackage(str);
    }

    /* renamed from: a */
    public void m7503a(Intent intent) {
        this.f5017c = intent;
    }

    /* renamed from: a */
    public Drawable m7500a() {
        return this.f5015a;
    }

    /* renamed from: b */
    public String m7504b() {
        return this.f5016b;
    }

    /* renamed from: c */
    public Intent m7505c() {
        return this.f5017c;
    }

    /* renamed from: a */
    public void m7501a(int i) {
        this.f5018d = i;
    }

    /* renamed from: d */
    public int m7506d() {
        return this.f5018d;
    }
}
