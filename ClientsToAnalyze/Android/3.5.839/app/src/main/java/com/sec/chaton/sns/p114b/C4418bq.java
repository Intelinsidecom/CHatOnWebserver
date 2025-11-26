package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.C4445e;
import com.sec.chaton.sns.p113a.AsyncTaskC4371h;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import p021c.p022a.C0326a;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bq */
/* loaded from: classes.dex */
public class C4418bq implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ C4410bi f15972a;

    /* renamed from: b */
    private int f15973b;

    public C4418bq(C4410bi c4410bi, int i) {
        this.f15972a = c4410bi;
        this.f15973b = i;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        this.f15972a.m16571a("Login Request:" + this.f15973b + " Done.");
        if (obj instanceof C0326a) {
            C0326a c0326a = (C0326a) obj;
            C4445e.m16840a(c0326a, this.f15972a.f15830a);
            new AsyncTaskC4371h(this.f15972a, this.f15973b).execute(new C4414bm(this.f15972a, c0326a, null));
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        this.f15972a.m16572b("Login Request:" + this.f15973b + " Webview Error. " + c4365b.getMessage());
        if (c4365b.m16562a() != -1002) {
            this.f15972a.f15831b.mo16563a(this.f15973b, c4365b.m16562a(), c4365b.getMessage());
        } else {
            this.f15972a.f15831b.mo16563a(this.f15973b, -1002, c4365b.getMessage());
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        this.f15972a.m16571a("Login Request:" + this.f15973b + " Canceled.");
        this.f15972a.f15831b.mo16563a(this.f15973b, 0, null);
    }
}
