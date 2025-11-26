package com.sec.chaton.util;

import android.os.AsyncTask;
import com.sec.chaton.p007a.p008a.C0102c;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.al */
/* loaded from: classes.dex */
class AsyncTaskC1729al extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ C1726ai f6334a;

    /* renamed from: b */
    private String f6335b;

    /* renamed from: c */
    private String f6336c;

    /* renamed from: d */
    private InterfaceC1731an f6337d;

    public AsyncTaskC1729al(C1726ai c1726ai, InterfaceC1731an interfaceC1731an) {
        this.f6334a = c1726ai;
        this.f6337d = interfaceC1731an;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0102c doInBackground(String... strArr) {
        this.f6335b = strArr[0];
        this.f6336c = strArr[1];
        return this.f6334a.m5907a(this.f6335b + "&r=" + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0102c c0102c) {
        if (isCancelled()) {
            c0102c.m678a(null);
        }
        if (c0102c.m679b() != EnumC1730am.ERROR) {
            this.f6334a.m5908a(this.f6335b, c0102c.m677a());
        }
        this.f6337d.mo2412a(this.f6336c, c0102c.m677a(), c0102c.m679b());
    }
}
