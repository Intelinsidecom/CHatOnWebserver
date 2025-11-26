package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.facebook.p031a.C0425a;
import com.facebook.p031a.C0428d;
import com.facebook.p031a.InterfaceC0427c;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.j */
/* loaded from: classes.dex */
class C4426j implements InterfaceC0427c {

    /* renamed from: a */
    final /* synthetic */ C4374a f15983a;

    /* renamed from: b */
    private int f15984b;

    /* renamed from: c */
    private AbstractC4424h f15985c;

    /* synthetic */ C4426j(C4374a c4374a, int i, AbstractC4424h abstractC4424h, C4401b c4401b) {
        this(c4374a, i, abstractC4424h);
    }

    private C4426j(C4374a c4374a, int i, AbstractC4424h abstractC4424h) {
        this.f15983a = c4374a;
        this.f15984b = i;
        this.f15985c = abstractC4424h;
    }

    @Override // com.facebook.p031a.InterfaceC0427c
    /* renamed from: a */
    public void mo1540a(Bundle bundle) {
        C4374a.m16599d("Login Request:" + this.f15984b + " Done.");
        this.f15983a.m16603j();
    }

    @Override // com.facebook.p031a.InterfaceC0427c
    /* renamed from: a */
    public void mo1539a() {
        C4374a.m16599d("Login Request:" + this.f15984b + " Canceled.");
        this.f15983a.f15848d.mo16563a(this.f15984b, 0, null);
    }

    @Override // com.facebook.p031a.InterfaceC0427c
    /* renamed from: a */
    public void mo1542a(C0428d c0428d) {
        C4374a.m16600e("Login Request:" + this.f15984b + " Facebook Error. " + c0428d.getMessage());
        this.f15983a.f15848d.mo16563a(this.f15984b, -1001, c0428d.getMessage());
    }

    @Override // com.facebook.p031a.InterfaceC0427c
    /* renamed from: a */
    public void mo1541a(C0425a c0425a) {
        C4374a.m16600e("Login Request:" + this.f15984b + " Webview Error. " + c0425a.getMessage());
        this.f15983a.f15848d.mo16563a(this.f15984b, -1002, c0425a.getMessage());
    }
}
