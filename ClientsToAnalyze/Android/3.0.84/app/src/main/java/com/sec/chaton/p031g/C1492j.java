package com.sec.chaton.p031g;

import android.os.Bundle;
import com.facebook.p007a.C0054a;
import com.facebook.p007a.C0057d;
import com.facebook.p007a.InterfaceC0056c;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.j */
/* loaded from: classes.dex */
class C1492j implements InterfaceC0056c {

    /* renamed from: a */
    final /* synthetic */ C1483a f5508a;

    /* renamed from: b */
    private int f5509b;

    /* renamed from: c */
    private AbstractC1490h f5510c;

    /* synthetic */ C1492j(C1483a c1483a, int i, AbstractC1490h abstractC1490h, C1484b c1484b) {
        this(c1483a, i, abstractC1490h);
    }

    private C1492j(C1483a c1483a, int i, AbstractC1490h abstractC1490h) {
        this.f5508a = c1483a;
        this.f5509b = i;
        this.f5510c = abstractC1490h;
    }

    @Override // com.facebook.p007a.InterfaceC0056c
    /* renamed from: a */
    public void mo97a(Bundle bundle) {
        C1483a.m6429d("Login Request:" + this.f5509b + " Done.");
        this.f5508a.m6433j();
    }

    @Override // com.facebook.p007a.InterfaceC0056c
    /* renamed from: a */
    public void mo96a() {
        C1483a.m6429d("Login Request:" + this.f5509b + " Canceled.");
        this.f5508a.f5493d.mo9799a(this.f5509b, 0, null);
    }

    @Override // com.facebook.p007a.InterfaceC0056c
    /* renamed from: a */
    public void mo99a(C0057d c0057d) {
        C1483a.m6430e("Login Request:" + this.f5509b + " Facebook Error. " + c0057d.getMessage());
        this.f5508a.f5493d.mo9799a(this.f5509b, -1001, c0057d.getMessage());
    }

    @Override // com.facebook.p007a.InterfaceC0056c
    /* renamed from: a */
    public void mo98a(C0054a c0054a) {
        C1483a.m6430e("Login Request:" + this.f5509b + " Webview Error. " + c0054a.getMessage());
        this.f5508a.f5493d.mo9799a(this.f5509b, -1002, c0054a.getMessage());
    }
}
