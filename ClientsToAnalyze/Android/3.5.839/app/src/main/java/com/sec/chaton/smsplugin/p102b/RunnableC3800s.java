package com.sec.chaton.smsplugin.p102b;

import android.net.Uri;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;

/* compiled from: WorkingMessage.java */
/* renamed from: com.sec.chaton.smsplugin.b.s */
/* loaded from: classes.dex */
class RunnableC3800s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3790i f13647a;

    /* renamed from: b */
    final /* synthetic */ CharSequence f13648b;

    /* renamed from: c */
    final /* synthetic */ C3870p f13649c;

    /* renamed from: d */
    final /* synthetic */ Uri f13650d;

    /* renamed from: e */
    final /* synthetic */ C5097t f13651e;

    /* renamed from: f */
    final /* synthetic */ String f13652f;

    /* renamed from: g */
    final /* synthetic */ C3799r f13653g;

    RunnableC3800s(C3799r c3799r, C3790i c3790i, CharSequence charSequence, C3870p c3870p, Uri uri, C5097t c5097t, String str) {
        this.f13653g = c3799r;
        this.f13647a = c3790i;
        this.f13648b = charSequence;
        this.f13649c = c3870p;
        this.f13650d = uri;
        this.f13651e = c5097t;
        this.f13652f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5103z c5103zM14413b = C3799r.m14413b(this.f13647a, this.f13648b);
        this.f13649c.m14917f();
        this.f13653g.m14401a(this.f13647a, this.f13650d, this.f13651e, this.f13649c, c5103zM14413b, this.f13652f);
        this.f13653g.m14424d(this.f13647a);
    }
}
