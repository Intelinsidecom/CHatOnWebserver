package com.sec.chaton.smsplugin.p111h;

import android.net.Uri;
import android.widget.Toast;
import com.sec.google.android.p134a.C5111c;

/* compiled from: DownloadManager.java */
/* renamed from: com.sec.chaton.smsplugin.h.h */
/* loaded from: classes.dex */
class RunnableC3885h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f13981a;

    /* renamed from: b */
    final /* synthetic */ C3881d f13982b;

    RunnableC3885h(C3881d c3881d, Uri uri) {
        this.f13982b = c3881d;
        this.f13981a = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Toast.makeText(this.f13982b.f13972a, this.f13982b.m14971b(this.f13981a), 1).show();
        } catch (C5111c e) {
            C3890m.m14995a("DownloadManager", e.getMessage(), e);
        }
    }
}
