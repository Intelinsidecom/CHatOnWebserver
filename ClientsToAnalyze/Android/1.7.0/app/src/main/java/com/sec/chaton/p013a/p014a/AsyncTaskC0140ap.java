package com.sec.chaton.p013a.p014a;

import android.os.AsyncTask;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1324bt;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.a.a.ap */
/* loaded from: classes.dex */
public class AsyncTaskC0140ap extends AsyncTask {

    /* renamed from: a */
    private String f337a;

    /* renamed from: b */
    private String f338b;

    /* renamed from: c */
    private String f339c;

    /* renamed from: d */
    private boolean f340d;

    /* renamed from: e */
    private String f341e;

    /* renamed from: f */
    private long f342f;

    /* renamed from: g */
    private EnumC0665r f343g;

    /* renamed from: h */
    private String f344h;

    public AsyncTaskC0140ap(String str, String str2, String str3, boolean z, String str4, long j, EnumC0665r enumC0665r, String str5) {
        this.f337a = str;
        this.f338b = str2;
        this.f339c = str3;
        this.f340d = z;
        this.f341e = str4;
        this.f342f = j;
        this.f343g = enumC0665r;
        this.f344h = str5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        return C1324bt.m4582a(this.f337a, this.f338b, this.f339c, this.f340d, this.f341e, this.f342f, this.f343g, this.f344h);
    }
}
