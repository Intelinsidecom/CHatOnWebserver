package com.facebook.p033c;

import android.content.Context;
import com.facebook.p032b.C0477t;
import java.net.URL;

/* compiled from: ImageRequest.java */
/* renamed from: com.facebook.c.i */
/* loaded from: classes.dex */
public class C0512i {

    /* renamed from: a */
    private Context f1289a;

    /* renamed from: b */
    private URL f1290b;

    /* renamed from: c */
    private InterfaceC0513j f1291c;

    /* renamed from: d */
    private boolean f1292d;

    /* renamed from: e */
    private Object f1293e;

    public C0512i(Context context, URL url) {
        C0477t.m1721a(url, "imageUrl");
        this.f1289a = context;
        this.f1290b = url;
    }

    /* renamed from: a */
    public C0512i m1874a(InterfaceC0513j interfaceC0513j) {
        this.f1291c = interfaceC0513j;
        return this;
    }

    /* renamed from: a */
    public C0512i m1875a(Object obj) {
        this.f1293e = obj;
        return this;
    }

    /* renamed from: a */
    public C0510g m1873a() {
        return new C0510g(this);
    }
}
