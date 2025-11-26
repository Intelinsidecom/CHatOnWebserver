package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.net.Uri;
import com.sec.chaton.sns.p113a.InterfaceC4367d;

/* compiled from: SnsHelperWeibo.java */
/* renamed from: com.sec.chaton.sns.b.ar */
/* loaded from: classes.dex */
public class C4392ar extends AbstractC4439w {

    /* renamed from: a */
    private static final String f15910a = C4392ar.class.getSimpleName();

    /* renamed from: b */
    private C4410bi f15911b;

    /* renamed from: c */
    private InterfaceC4377ac f15912c;

    /* renamed from: d */
    private InterfaceC4376ab f15913d;

    /* renamed from: e */
    private InterfaceC4442z f15914e;

    /* renamed from: f */
    private InterfaceC4378ad f15915f;

    /* renamed from: g */
    private InterfaceC4441y f15916g;

    /* renamed from: h */
    private InterfaceC4375aa f15917h;

    /* renamed from: i */
    private InterfaceC4367d f15918i = new C4393as(this);

    public C4392ar(Context context) {
        this.f15911b = new C4410bi(context, this.f15918i);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16639a() {
        this.f15911b.mo16569a();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16644a(InterfaceC4442z interfaceC4442z) {
        this.f15914e = interfaceC4442z;
        this.f15911b.m16754b(12001);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16643a(InterfaceC4441y interfaceC4441y) {
        this.f15916g = interfaceC4441y;
        this.f15911b.m16755c(12006);
    }

    /* renamed from: a */
    public void m16689a(String str, InterfaceC4378ad interfaceC4378ad) {
        this.f15915f = interfaceC4378ad;
        this.f15911b.m16751a(12002, null, str);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16642a(InterfaceC4377ac interfaceC4377ac) {
        this.f15912c = interfaceC4377ac;
        this.f15911b.m16753b();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16641a(InterfaceC4376ab interfaceC4376ab) {
        this.f15913d = interfaceC4376ab;
        this.f15911b.m16750a(12004);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: e */
    public boolean mo16650e() {
        return this.f15911b.m16756c();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: b */
    public String mo16647b() {
        return this.f15911b.m16757d();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public String mo16638a(boolean z) {
        String strM16758e = this.f15911b.m16758e();
        if (z) {
            Uri uri = Uri.parse(strM16758e);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(uri.getScheme());
            builder.authority(uri.getAuthority());
            for (String str : uri.getPathSegments()) {
                if (str.equals("50")) {
                    builder.appendPath("180");
                } else {
                    builder.appendPath(str);
                }
            }
            return builder.build().toString();
        }
        return strM16758e;
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: c */
    public String mo16648c() {
        return this.f15911b.m16759f();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: d */
    public String mo16649d() {
        return this.f15911b.m16760g();
    }
}
