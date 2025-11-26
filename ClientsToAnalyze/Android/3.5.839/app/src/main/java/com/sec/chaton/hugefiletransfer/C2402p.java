package com.sec.chaton.hugefiletransfer;

import android.app.PendingIntent;
import com.sec.common.util.C5052r;

/* compiled from: UploadProgressInfo.java */
/* renamed from: com.sec.chaton.hugefiletransfer.p */
/* loaded from: classes.dex */
public class C2402p {

    /* renamed from: a */
    private long f8538a;

    /* renamed from: b */
    private String f8539b;

    /* renamed from: c */
    private int f8540c;

    /* renamed from: d */
    private int f8541d;

    /* renamed from: e */
    private PendingIntent f8542e;

    public C2402p(long j, String str, int i, int i2, PendingIntent pendingIntent) {
        this.f8538a = j;
        this.f8539b = str;
        this.f8540c = i;
        this.f8541d = i2;
        this.f8542e = pendingIntent;
    }

    /* renamed from: a */
    public long m10425a() {
        return this.f8538a;
    }

    /* renamed from: b */
    public String m10426b() {
        return this.f8539b;
    }

    /* renamed from: c */
    public int m10427c() {
        return this.f8540c;
    }

    /* renamed from: d */
    public int m10428d() {
        return this.f8541d;
    }

    /* renamed from: e */
    public PendingIntent m10429e() {
        return this.f8542e;
    }

    public String toString() {
        return C5052r.m19199a("mRequestId: ", Long.valueOf(this.f8538a), ", mFileName: ", this.f8539b, ", mSuccessChunkCount: ", Integer.valueOf(this.f8541d), ", mChunkCount: ", Integer.valueOf(this.f8540c));
    }
}
