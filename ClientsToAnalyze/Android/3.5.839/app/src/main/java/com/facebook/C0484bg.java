package com.facebook;

import android.app.Activity;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* compiled from: Session.java */
/* renamed from: com.facebook.bg */
/* loaded from: classes.dex */
public class C0484bg implements Serializable {

    /* renamed from: a */
    private final InterfaceC0490bm f1191a;

    /* renamed from: d */
    private InterfaceC0491bn f1194d;

    /* renamed from: h */
    private String f1198h;

    /* renamed from: i */
    private String f1199i;

    /* renamed from: b */
    private EnumC0495br f1192b = EnumC0495br.SSO_WITH_FALLBACK;

    /* renamed from: c */
    private int f1193c = 64206;

    /* renamed from: e */
    private boolean f1195e = false;

    /* renamed from: f */
    private List<String> f1196f = Collections.emptyList();

    /* renamed from: g */
    private EnumC0494bq f1197g = EnumC0494bq.FRIENDS;

    C0484bg(Activity activity) {
        this.f1191a = new C0485bh(this, activity);
    }

    /* renamed from: a */
    public void m1783a(boolean z) {
        this.f1195e = z;
    }

    /* renamed from: a */
    C0484bg mo1778a(InterfaceC0491bn interfaceC0491bn) {
        this.f1194d = interfaceC0491bn;
        return this;
    }

    /* renamed from: a */
    InterfaceC0491bn m1781a() {
        return this.f1194d;
    }

    /* renamed from: a */
    C0484bg mo1779a(EnumC0495br enumC0495br) {
        if (enumC0495br != null) {
            this.f1192b = enumC0495br;
        }
        return this;
    }

    /* renamed from: a */
    C0484bg mo1777a(int i) {
        if (i >= 0) {
            this.f1193c = i;
        }
        return this;
    }

    /* renamed from: a */
    C0484bg mo1780a(List<String> list) {
        if (list != null) {
            this.f1196f = list;
        }
        return this;
    }

    /* renamed from: b */
    List<String> m1784b() {
        return this.f1196f;
    }

    /* renamed from: a */
    void m1782a(String str) {
        this.f1198h = str;
    }

    /* renamed from: c */
    C0536j m1785c() {
        return new C0536j(this.f1192b, this.f1193c, this.f1195e, this.f1196f, this.f1197g, this.f1198h, this.f1199i, new C0486bi(this));
    }
}
