package com.sec.chaton.facebook;

import android.os.Bundle;
import com.coolots.sso.model.ChatONCallStartInfo;
import com.p001a.p002a.C0037b;
import com.p001a.p002a.C0046k;
import com.p001a.p002a.C0047l;
import com.p001a.p002a.InterfaceC0041f;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.i */
/* loaded from: classes.dex */
class C0694i implements InterfaceC0041f {

    /* renamed from: a */
    final /* synthetic */ C0700o f2367a;

    /* renamed from: b */
    private int f2368b;

    /* renamed from: c */
    private AbstractC0701p f2369c;

    private C0694i(C0700o c0700o, int i, AbstractC0701p abstractC0701p) {
        this.f2367a = c0700o;
        this.f2368b = i;
        this.f2369c = abstractC0701p;
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo16a(Bundle bundle) {
        C0695j c0695j = null;
        C0700o.m3078c("Login Request:" + this.f2368b + " Done.");
        C0037b.m12a(C0700o.f2375a, this.f2367a.f2376b);
        AsyncTaskC0699n asyncTaskC0699n = new AsyncTaskC0699n(this.f2367a, this.f2368b);
        C0697l c0697l = new C0697l(this.f2367a);
        C0696k c0696k = new C0696k(this.f2367a);
        this.f2367a.f2377c.mo3067a(this.f2368b, true);
        if (this.f2369c == null) {
            asyncTaskC0699n.execute(c0697l, c0696k);
        } else {
            asyncTaskC0699n.execute(c0697l, c0696k, this.f2369c);
        }
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo15a() {
        C0700o.m3078c("Login Request:" + this.f2368b + " Canceled.");
        this.f2367a.f2377c.mo3066a(this.f2368b, 0, null);
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo18a(C0047l c0047l) {
        C0700o.m3079d("Login Request:" + this.f2368b + " Facebook Error. " + c0047l.getMessage());
        this.f2367a.f2377c.mo3066a(this.f2368b, ChatONCallStartInfo.ERROR_NOT_INITIALIZED_ENGINE, c0047l.getMessage());
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo17a(C0046k c0046k) {
        C0700o.m3079d("Login Request:" + this.f2368b + " Webview Error. " + c0046k.getMessage());
        this.f2367a.f2377c.mo3066a(this.f2368b, ChatONCallStartInfo.ERROR_UNKNOWN, c0046k.getMessage());
    }
}
