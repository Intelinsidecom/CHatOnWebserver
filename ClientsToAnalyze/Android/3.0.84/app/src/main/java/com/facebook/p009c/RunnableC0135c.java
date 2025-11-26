package com.facebook.p009c;

import android.content.Context;
import java.io.IOException;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.c */
/* loaded from: classes.dex */
class RunnableC0135c implements Runnable {

    /* renamed from: a */
    private Context f304a;

    /* renamed from: b */
    private C0138f f305b;

    /* renamed from: c */
    private boolean f306c;

    RunnableC0135c(Context context, C0138f c0138f, boolean z) {
        this.f304a = context;
        this.f305b = c0138f;
        this.f306c = z;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        C0132a.m412b(this.f305b, this.f304a, this.f306c);
    }
}
