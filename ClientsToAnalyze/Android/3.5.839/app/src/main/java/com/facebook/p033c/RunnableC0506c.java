package com.facebook.p033c;

import android.content.Context;
import java.io.IOException;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.c */
/* loaded from: classes.dex */
class RunnableC0506c implements Runnable {

    /* renamed from: a */
    private Context f1273a;

    /* renamed from: b */
    private C0509f f1274b;

    /* renamed from: c */
    private boolean f1275c;

    RunnableC0506c(Context context, C0509f c0509f, boolean z) {
        this.f1273a = context;
        this.f1274b = c0509f;
        this.f1275c = z;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        C0503a.m1855b(this.f1274b, this.f1273a, this.f1275c);
    }
}
