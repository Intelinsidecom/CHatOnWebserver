package com.sec.chaton.p025d.p026a;

import android.os.AsyncTask;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3243r;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.d.a.ay */
/* loaded from: classes.dex */
public class AsyncTaskC1170ay extends AsyncTask<String, Integer, String> {

    /* renamed from: a */
    private String f4635a;

    /* renamed from: b */
    private String f4636b;

    /* renamed from: c */
    private String f4637c;

    /* renamed from: d */
    private boolean f4638d;

    /* renamed from: e */
    private String f4639e;

    /* renamed from: f */
    private long f4640f;

    /* renamed from: g */
    private EnumC1450r f4641g;

    /* renamed from: h */
    private String f4642h;

    public AsyncTaskC1170ay(String str, String str2, String str3, boolean z, String str4, long j, EnumC1450r enumC1450r, String str5) {
        this.f4635a = str;
        this.f4636b = str2;
        this.f4637c = str3;
        this.f4638d = z;
        this.f4639e = str4;
        this.f4640f = j;
        this.f4641g = enumC1450r;
        this.f4642h = str5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        return C3243r.m11416a(this.f4635a, this.f4636b, this.f4637c, this.f4638d, this.f4639e, this.f4640f, this.f4641g, this.f4642h);
    }
}
