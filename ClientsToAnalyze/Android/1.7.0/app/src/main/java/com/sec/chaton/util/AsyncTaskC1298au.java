package com.sec.chaton.util;

import android.os.AsyncTask;
import com.sec.chaton.p015b.p016a.C0253a;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.au */
/* loaded from: classes.dex */
class AsyncTaskC1298au extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ C1308bd f4502a;

    /* renamed from: b */
    private String f4503b;

    /* renamed from: c */
    private String f4504c;

    /* renamed from: d */
    private InterfaceC1290am f4505d;

    public AsyncTaskC1298au(C1308bd c1308bd, InterfaceC1290am interfaceC1290am) {
        this.f4502a = c1308bd;
        this.f4505d = interfaceC1290am;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0253a doInBackground(String... strArr) {
        this.f4503b = strArr[0];
        this.f4504c = strArr[1];
        return this.f4502a.m4559a(this.f4503b + "&r=" + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0253a c0253a) {
        if (isCancelled()) {
            c0253a.m915a(null);
        }
        if (c0253a.m916b() != EnumC1304b.ERROR) {
            this.f4502a.m4560a(this.f4503b, c0253a.m914a());
        }
        this.f4505d.mo2368a(this.f4504c, c0253a.m914a(), c0253a.m916b());
    }
}
