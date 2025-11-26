package com.facebook;

import android.app.Activity;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* compiled from: Session.java */
/* renamed from: com.facebook.bg */
/* loaded from: classes.dex */
public class C0113bg implements Serializable {

    /* renamed from: a */
    private final InterfaceC0119bm f222a;

    /* renamed from: d */
    private InterfaceC0120bn f225d;

    /* renamed from: h */
    private String f229h;

    /* renamed from: i */
    private String f230i;

    /* renamed from: b */
    private EnumC0124br f223b = EnumC0124br.SSO_WITH_FALLBACK;

    /* renamed from: c */
    private int f224c = 64206;

    /* renamed from: e */
    private boolean f226e = false;

    /* renamed from: f */
    private List<String> f227f = Collections.emptyList();

    /* renamed from: g */
    private EnumC0123bq f228g = EnumC0123bq.FRIENDS;

    C0113bg(Activity activity) {
        this.f222a = new C0114bh(this, activity);
    }

    /* renamed from: a */
    public void m340a(boolean z) {
        this.f226e = z;
    }

    /* renamed from: a */
    C0113bg mo335a(InterfaceC0120bn interfaceC0120bn) {
        this.f225d = interfaceC0120bn;
        return this;
    }

    /* renamed from: a */
    InterfaceC0120bn m338a() {
        return this.f225d;
    }

    /* renamed from: a */
    C0113bg mo336a(EnumC0124br enumC0124br) {
        if (enumC0124br != null) {
            this.f223b = enumC0124br;
        }
        return this;
    }

    /* renamed from: a */
    C0113bg mo334a(int i) {
        if (i >= 0) {
            this.f224c = i;
        }
        return this;
    }

    /* renamed from: a */
    C0113bg mo337a(List<String> list) {
        if (list != null) {
            this.f227f = list;
        }
        return this;
    }

    /* renamed from: b */
    List<String> m341b() {
        return this.f227f;
    }

    /* renamed from: a */
    void m339a(String str) {
        this.f229h = str;
    }

    /* renamed from: c */
    C0165j m342c() {
        return new C0165j(this.f223b, this.f224c, this.f226e, this.f227f, this.f228g, this.f229h, this.f230i, new C0115bi(this));
    }
}
