package com.facebook.p009c;

import android.content.Context;
import com.facebook.p008b.C0106t;
import java.net.URL;

/* compiled from: ImageRequest.java */
/* renamed from: com.facebook.c.i */
/* loaded from: classes.dex */
public class C0141i {

    /* renamed from: a */
    private Context f320a;

    /* renamed from: b */
    private URL f321b;

    /* renamed from: c */
    private InterfaceC0142j f322c;

    /* renamed from: d */
    private boolean f323d;

    /* renamed from: e */
    private Object f324e;

    public C0141i(Context context, URL url) {
        C0106t.m277a(url, "imageUrl");
        this.f320a = context;
        this.f321b = url;
    }

    /* renamed from: a */
    public C0141i m431a(InterfaceC0142j interfaceC0142j) {
        this.f322c = interfaceC0142j;
        return this;
    }

    /* renamed from: a */
    public C0141i m432a(Object obj) {
        this.f324e = obj;
        return this;
    }

    /* renamed from: a */
    public C0139g m430a() {
        return new C0139g(this);
    }
}
