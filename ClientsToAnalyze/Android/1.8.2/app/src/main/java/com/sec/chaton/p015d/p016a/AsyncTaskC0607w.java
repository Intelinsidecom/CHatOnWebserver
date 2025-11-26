package com.sec.chaton.p015d.p016a;

import android.os.AsyncTask;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1783o;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.d.a.w */
/* loaded from: classes.dex */
public class AsyncTaskC0607w extends AsyncTask {

    /* renamed from: a */
    private String f2386a;

    /* renamed from: b */
    private String f2387b;

    /* renamed from: c */
    private String f2388c;

    /* renamed from: d */
    private boolean f2389d;

    /* renamed from: e */
    private String f2390e;

    /* renamed from: f */
    private long f2391f;

    /* renamed from: g */
    private EnumC0695j f2392g;

    /* renamed from: h */
    private String f2393h;

    public AsyncTaskC0607w(String str, String str2, String str3, boolean z, String str4, long j, EnumC0695j enumC0695j, String str5) {
        this.f2386a = str;
        this.f2387b = str2;
        this.f2388c = str3;
        this.f2389d = z;
        this.f2390e = str4;
        this.f2391f = j;
        this.f2392g = enumC0695j;
        this.f2393h = str5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        return C1783o.m6033a(this.f2386a, this.f2387b, this.f2388c, this.f2389d, this.f2390e, this.f2391f, this.f2392g, this.f2393h);
    }
}
