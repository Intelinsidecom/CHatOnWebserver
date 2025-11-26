package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.sec.chaton.sns.C4363a;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import p010b.p012b.C0280i;

/* compiled from: OdnoklassnikiManager.java */
/* renamed from: com.sec.chaton.sns.b.o */
/* loaded from: classes.dex */
public class C4431o implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ C4427k f15999a;

    public C4431o(C4427k c4427k, int i) {
        this.f15999a = c4427k;
        c4427k.f15992i = i;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        this.f15999a.m16571a("Login Request:" + this.f15999a.f15992i + " Done.");
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("access_token");
            C4363a.m16548a(this.f15999a.f15989d, string, bundle.getString("refresh_token"));
            this.f15999a.f15990g = string;
            this.f15999a.m16780h();
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        this.f15999a.m16572b("Login Request:" + this.f15999a.f15992i + " Webview Error. " + c4365b.getMessage());
        if (c4365b.m16562a() != -1002) {
            this.f15999a.f15831b.mo16563a(this.f15999a.f15992i, c4365b.m16562a(), c4365b.getMessage());
        } else {
            this.f15999a.f15831b.mo16563a(this.f15999a.f15992i, -1002, c4365b.getMessage());
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        this.f15999a.m16571a("Login Request:" + this.f15999a.f15992i + " Canceled.");
        C0280i unused = C4427k.f15988f = null;
        this.f15999a.f15831b.mo16563a(this.f15999a.f15992i, 0, null);
    }
}
