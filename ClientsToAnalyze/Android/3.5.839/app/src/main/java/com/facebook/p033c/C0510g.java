package com.facebook.p033c;

import android.content.Context;
import com.sec.chaton.p051c.C1428b;
import java.net.URL;

/* compiled from: ImageRequest.java */
/* renamed from: com.facebook.c.g */
/* loaded from: classes.dex */
public class C0510g {

    /* renamed from: a */
    private static final String f1283a = C1428b.f5111q + "%s/picture";

    /* renamed from: b */
    private Context f1284b;

    /* renamed from: c */
    private URL f1285c;

    /* renamed from: d */
    private InterfaceC0513j f1286d;

    /* renamed from: e */
    private boolean f1287e;

    /* renamed from: f */
    private Object f1288f;

    private C0510g(C0512i c0512i) {
        this.f1284b = c0512i.f1289a;
        this.f1285c = c0512i.f1290b;
        this.f1286d = c0512i.f1291c;
        this.f1287e = c0512i.f1292d;
        this.f1288f = c0512i.f1293e == null ? new Object() : c0512i.f1293e;
    }

    /* renamed from: a */
    Context m1863a() {
        return this.f1284b;
    }

    /* renamed from: b */
    public URL m1864b() {
        return this.f1285c;
    }

    /* renamed from: c */
    InterfaceC0513j m1865c() {
        return this.f1286d;
    }

    /* renamed from: d */
    boolean m1866d() {
        return this.f1287e;
    }

    /* renamed from: e */
    Object m1867e() {
        return this.f1288f;
    }
}
