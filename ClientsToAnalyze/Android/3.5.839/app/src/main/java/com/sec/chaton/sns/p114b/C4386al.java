package com.sec.chaton.sns.p114b;

import android.content.Context;
import com.sec.chaton.sns.p113a.InterfaceC4367d;

/* compiled from: SnsHelperTwitter.java */
/* renamed from: com.sec.chaton.sns.b.al */
/* loaded from: classes.dex */
public class C4386al extends AbstractC4439w {

    /* renamed from: a */
    private static final String f15884a = C4386al.class.getSimpleName();

    /* renamed from: b */
    private C4394at f15885b;

    /* renamed from: c */
    private InterfaceC4376ab f15886c;

    /* renamed from: d */
    private InterfaceC4377ac f15887d;

    /* renamed from: e */
    private InterfaceC4442z f15888e;

    /* renamed from: f */
    private InterfaceC4378ad f15889f;

    /* renamed from: g */
    private InterfaceC4441y f15890g;

    /* renamed from: h */
    private InterfaceC4375aa f15891h;

    /* renamed from: i */
    private InterfaceC4367d f15892i = new C4387am(this);

    public C4386al(Context context) {
        this.f15885b = new C4394at(context, this.f15892i);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16639a() {
        this.f15885b.mo16569a();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16644a(InterfaceC4442z interfaceC4442z) {
        this.f15888e = interfaceC4442z;
        this.f15885b.m16704b(12001);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16643a(InterfaceC4441y interfaceC4441y) {
        this.f15890g = interfaceC4441y;
        this.f15885b.m16707c(12006);
    }

    /* renamed from: a */
    public void m16673a(String str, InterfaceC4378ad interfaceC4378ad) {
        this.f15889f = interfaceC4378ad;
        this.f15885b.m16703a(12002, null, str);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16642a(InterfaceC4377ac interfaceC4377ac) {
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16641a(InterfaceC4376ab interfaceC4376ab) {
        this.f15886c = interfaceC4376ab;
        this.f15885b.m16702a(12004);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: e */
    public boolean mo16650e() {
        return this.f15885b.m16705b();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: b */
    public String mo16647b() {
        return this.f15885b.m16706c();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public String mo16638a(boolean z) {
        String strM16709d = this.f15885b.m16709d();
        if (z && strM16709d.contains("_normal")) {
            return strM16709d.replace("_normal", "");
        }
        return strM16709d;
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: c */
    public String mo16648c() {
        return this.f15885b.m16710e();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: d */
    public String mo16649d() {
        return null;
    }

    /* renamed from: f */
    public boolean m16674f() {
        return this.f15885b.m16711f();
    }
}
