package com.facebook.p009c;

import android.content.Context;
import com.sec.chaton.p020c.C0817b;
import java.net.URL;

/* compiled from: ImageRequest.java */
/* renamed from: com.facebook.c.g */
/* loaded from: classes.dex */
public class C0139g {

    /* renamed from: a */
    private static final String f314a = C0817b.f3139k + "%s/picture";

    /* renamed from: b */
    private Context f315b;

    /* renamed from: c */
    private URL f316c;

    /* renamed from: d */
    private InterfaceC0142j f317d;

    /* renamed from: e */
    private boolean f318e;

    /* renamed from: f */
    private Object f319f;

    private C0139g(C0141i c0141i) {
        this.f315b = c0141i.f320a;
        this.f316c = c0141i.f321b;
        this.f317d = c0141i.f322c;
        this.f318e = c0141i.f323d;
        this.f319f = c0141i.f324e == null ? new Object() : c0141i.f324e;
    }

    /* renamed from: a */
    Context m420a() {
        return this.f315b;
    }

    /* renamed from: b */
    public URL m421b() {
        return this.f316c;
    }

    /* renamed from: c */
    InterfaceC0142j m422c() {
        return this.f317d;
    }

    /* renamed from: d */
    boolean m423d() {
        return this.f318e;
    }

    /* renamed from: e */
    Object m424e() {
        return this.f319f;
    }
}
