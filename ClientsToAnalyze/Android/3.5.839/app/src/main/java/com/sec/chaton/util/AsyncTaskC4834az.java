package com.sec.chaton.util;

import android.os.AsyncTask;
import com.sec.chaton.p046a.p047a.C0787k;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.az */
/* loaded from: classes.dex */
class AsyncTaskC4834az extends AsyncTask<String, Void, C0787k> {

    /* renamed from: a */
    final /* synthetic */ C4831aw f17644a;

    /* renamed from: b */
    private String f17645b;

    /* renamed from: c */
    private String f17646c;

    /* renamed from: d */
    private InterfaceC4837bb f17647d;

    public AsyncTaskC4834az(C4831aw c4831aw, InterfaceC4837bb interfaceC4837bb) {
        this.f17644a = c4831aw;
        this.f17647d = interfaceC4837bb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0787k doInBackground(String... strArr) {
        this.f17645b = strArr[0];
        this.f17646c = strArr[1];
        return this.f17644a.m18297a(this.f17645b + "&r=" + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0787k c0787k) {
        if (isCancelled()) {
            c0787k.m3150a(null);
        }
        if (c0787k.m3151b() != EnumC4836ba.ERROR) {
            this.f17644a.m18298a(this.f17645b, c0787k.m3149a());
        }
        this.f17647d.mo7395a(this.f17646c, c0787k.m3149a(), c0787k.m3151b());
    }
}
