package com.sec.chaton.util;

import android.os.AsyncTask;
import com.sec.chaton.p016a.p017a.C0271h;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.az */
/* loaded from: classes.dex */
class AsyncTaskC3184az extends AsyncTask<String, Void, C0271h> {

    /* renamed from: a */
    final /* synthetic */ C3181aw f11529a;

    /* renamed from: b */
    private String f11530b;

    /* renamed from: c */
    private String f11531c;

    /* renamed from: d */
    private InterfaceC3187bb f11532d;

    public AsyncTaskC3184az(C3181aw c3181aw, InterfaceC3187bb interfaceC3187bb) {
        this.f11529a = c3181aw;
        this.f11532d = interfaceC3187bb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0271h doInBackground(String... strArr) {
        this.f11530b = strArr[0];
        this.f11531c = strArr[1];
        return this.f11529a.m11124a(this.f11530b + "&r=" + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0271h c0271h) {
        if (isCancelled()) {
            c0271h.m1363a(null);
        }
        if (c0271h.m1364b() != EnumC3186ba.ERROR) {
            this.f11529a.m11125a(this.f11530b, c0271h.m1362a());
        }
        this.f11532d.mo4324a(this.f11531c, c0271h.m1362a(), c0271h.m1364b());
    }
}
