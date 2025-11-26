package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.C4443c;
import com.sec.chaton.sns.p113a.AsyncTaskC4371h;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import p010b.InterfaceC0319f;
import p010b.p012b.C0272a;
import p010b.p012b.C0280i;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.az */
/* loaded from: classes.dex */
public class C4400az implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ C4394at f15935a;

    /* renamed from: b */
    private int f15936b;

    public C4400az(C4394at c4394at, int i) {
        this.f15935a = c4394at;
        this.f15936b = i;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        this.f15935a.m16571a("Login Request:" + this.f15936b + " Done.");
        if (obj instanceof C0272a) {
            C0272a c0272a = (C0272a) obj;
            C4443c.m16821a(c0272a, this.f15935a.f15830a);
            new AsyncTaskC4371h(this.f15935a, this.f15936b).execute(new C4398ax(this.f15935a, c0272a, null));
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        this.f15935a.m16572b("Login Request:" + this.f15936b + " Webview Error. " + c4365b.getMessage());
        if (c4365b.m16562a() != -1002) {
            this.f15935a.f15831b.mo16563a(this.f15936b, c4365b.m16562a(), c4365b.getMessage());
        } else {
            this.f15935a.f15831b.mo16563a(this.f15936b, -1002, c4365b.getMessage());
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        this.f15935a.m16571a("Login Request:" + this.f15936b + " Canceled.");
        InterfaceC0319f unused = C4394at.f15922e = null;
        C0280i unused2 = C4394at.f15923f = null;
        this.f15935a.f15831b.mo16563a(this.f15936b, 0, null);
    }
}
