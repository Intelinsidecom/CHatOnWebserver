package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.google.android.p134a.p135a.C5094q;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cg */
/* loaded from: classes.dex */
final class RunnableC4152cg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f15449a;

    /* renamed from: b */
    final /* synthetic */ Uri f15450b;

    /* renamed from: c */
    final /* synthetic */ Handler f15451c;

    /* renamed from: d */
    final /* synthetic */ Runnable f15452d;

    /* renamed from: e */
    final /* synthetic */ InterfaceC4158cm f15453e;

    /* renamed from: f */
    final /* synthetic */ boolean f15454f;

    RunnableC4152cg(Context context, Uri uri, Handler handler, Runnable runnable, InterfaceC4158cm interfaceC4158cm, boolean z) {
        this.f15449a = context;
        this.f15450b = uri;
        this.f15451c = handler;
        this.f15452d = runnable;
        this.f15453e = interfaceC4158cm;
        this.f15454f = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C4342jh c4342jh = new C4342jh(this.f15449a, this.f15450b);
            int iM14707m = C3847e.m14707m();
            int iM14706l = C3847e.m14706l();
            if (c4342jh.m16524d() <= c4342jh.m16523c()) {
                iM14706l = iM14707m;
                iM14707m = iM14706l;
            }
            C5094q c5094qM16520a = c4342jh.m16520a(iM14706l, iM14707m, C3847e.m14697c() - 5000);
            this.f15451c.removeCallbacks(this.f15452d);
            this.f15451c.post(new RunnableC4153ch(this, c5094qM16520a));
        } catch (Throwable th) {
            this.f15451c.removeCallbacks(this.f15452d);
            throw th;
        }
    }
}
