package com.sec.chaton.sns.p114b;

import android.content.Context;
import com.sec.chaton.sns.p113a.InterfaceC4367d;

/* compiled from: SnsHelperRenren.java */
/* renamed from: com.sec.chaton.sns.b.aj */
/* loaded from: classes.dex */
public class C4384aj extends AbstractC4439w {

    /* renamed from: a */
    private static final String f15877a = C4384aj.class.getSimpleName();

    /* renamed from: b */
    private C4432p f15878b;

    /* renamed from: c */
    private InterfaceC4376ab f15879c;

    /* renamed from: d */
    private InterfaceC4442z f15880d;

    /* renamed from: e */
    private InterfaceC4378ad f15881e;

    /* renamed from: f */
    private InterfaceC4367d f15882f = new C4385ak(this);

    public C4384aj(Context context) {
        this.f15878b = new C4432p(context, this.f15882f);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16644a(InterfaceC4442z interfaceC4442z) {
        this.f15880d = interfaceC4442z;
        this.f15878b.m16809b(12001);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16643a(InterfaceC4441y interfaceC4441y) {
    }

    /* renamed from: a */
    public void m16664a(String str, InterfaceC4378ad interfaceC4378ad) {
        this.f15881e = interfaceC4378ad;
        this.f15878b.m16808a(12002, null, str);
    }

    /* renamed from: a */
    public void m16665a(String str, InterfaceC4378ad interfaceC4378ad, String str2) {
        this.f15881e = interfaceC4378ad;
        this.f15878b.m16808a(12002, str, str2);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16642a(InterfaceC4377ac interfaceC4377ac) {
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16641a(InterfaceC4376ab interfaceC4376ab) {
        this.f15879c = interfaceC4376ab;
        this.f15878b.m16807a(12004);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: e */
    public boolean mo16650e() {
        return this.f15878b.m16810b();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: b */
    public String mo16647b() {
        return this.f15878b.m16811c();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public String mo16638a(boolean z) {
        return this.f15878b.m16812d();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: c */
    public String mo16648c() {
        return this.f15878b.m16813e();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: d */
    public String mo16649d() {
        return null;
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16639a() {
        this.f15878b.mo16569a();
    }
}
