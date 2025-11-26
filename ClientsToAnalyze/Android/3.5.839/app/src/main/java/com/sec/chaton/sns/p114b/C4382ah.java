package com.sec.chaton.sns.p114b;

import android.content.Context;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import java.security.NoSuchAlgorithmException;

/* compiled from: SnsHelperOdnoklassiniki.java */
/* renamed from: com.sec.chaton.sns.b.ah */
/* loaded from: classes.dex */
public class C4382ah extends AbstractC4439w {

    /* renamed from: a */
    private static final String f15866a = C4382ah.class.getSimpleName();

    /* renamed from: b */
    private C4427k f15867b;

    /* renamed from: c */
    private InterfaceC4377ac f15868c;

    /* renamed from: d */
    private InterfaceC4376ab f15869d;

    /* renamed from: e */
    private InterfaceC4442z f15870e;

    /* renamed from: f */
    private InterfaceC4378ad f15871f;

    /* renamed from: g */
    private InterfaceC4441y f15872g;

    /* renamed from: h */
    private InterfaceC4375aa f15873h;

    /* renamed from: i */
    private boolean f15874i;

    /* renamed from: j */
    private InterfaceC4367d f15875j = new C4383ai(this);

    public C4382ah(Context context) {
        this.f15867b = new C4427k(context, this.f15875j);
    }

    public C4382ah(Context context, boolean z) {
        this.f15874i = z;
        this.f15867b = new C4427k(context, this.f15875j);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16639a() {
        this.f15867b.mo16569a();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16644a(InterfaceC4442z interfaceC4442z) throws NoSuchAlgorithmException {
        if (interfaceC4442z != null) {
            this.f15870e = interfaceC4442z;
        }
        this.f15867b.mo16570a(12001, this.f15874i);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16643a(InterfaceC4441y interfaceC4441y) {
        if (interfaceC4441y != null) {
            this.f15872g = interfaceC4441y;
        }
        this.f15867b.m16787c(12006);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16642a(InterfaceC4377ac interfaceC4377ac) {
        if (interfaceC4377ac != null) {
            this.f15868c = interfaceC4377ac;
        }
        this.f15867b.m16783a(this.f15867b.f15989d, 12003);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16641a(InterfaceC4376ab interfaceC4376ab) {
        if (interfaceC4376ab != null) {
            this.f15869d = interfaceC4376ab;
        }
        this.f15867b.m16782a(12004);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: b */
    public String mo16647b() {
        return this.f15867b.m16786c();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: c */
    public String mo16648c() {
        return this.f15867b.m16789e();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public String mo16638a(boolean z) {
        return this.f15867b.m16788d();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: d */
    public String mo16649d() {
        return this.f15867b.m16790f();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: e */
    public boolean mo16650e() {
        return this.f15867b.m16785b() && C4368e.m16564a(GlobalApplication.m18732r()).m16566a(C4368e.f15818d);
    }

    /* renamed from: a */
    public void m16659a(String str, InterfaceC4378ad interfaceC4378ad) {
    }
}
