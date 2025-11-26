package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p113a.InterfaceC4367d;

/* compiled from: SnsHelperVKontakte.java */
/* renamed from: com.sec.chaton.sns.b.an */
/* loaded from: classes.dex */
public class C4388an extends AbstractC4439w {

    /* renamed from: a */
    public static final String f15894a = C4388an.class.getSimpleName();

    /* renamed from: b */
    private C4403bb f15895b;

    /* renamed from: c */
    private InterfaceC4376ab f15896c;

    /* renamed from: d */
    private InterfaceC4442z f15897d;

    /* renamed from: e */
    private InterfaceC4441y f15898e;

    /* renamed from: f */
    private InterfaceC4378ad f15899f;

    /* renamed from: g */
    private InterfaceC4377ac f15900g;

    /* renamed from: h */
    private boolean f15901h;

    /* renamed from: i */
    private InterfaceC4367d f15902i = new C4391aq(this);

    public C4388an(Context context) {
        this.f15895b = new C4403bb(context, this.f15902i);
    }

    public C4388an(Context context, boolean z) {
        Looper looper;
        InterfaceC4367d interfaceC4367d = this.f15902i;
        this.f15901h = z;
        this.f15895b = new C4403bb(context, (this.f15901h || !(Thread.currentThread() instanceof HandlerThread) || (looper = ((HandlerThread) Thread.currentThread()).getLooper()) == null) ? interfaceC4367d : new C4389ao(this, new Handler(looper)));
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16644a(InterfaceC4442z interfaceC4442z) {
        if (interfaceC4442z != null) {
            this.f15897d = interfaceC4442z;
        }
        this.f15895b.m16730b(12001);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16643a(InterfaceC4441y interfaceC4441y) {
        if (interfaceC4441y != null) {
            this.f15898e = interfaceC4441y;
        }
        this.f15895b.m16732c(12006);
    }

    /* renamed from: a */
    public void m16681a(String str, InterfaceC4378ad interfaceC4378ad) {
        if (interfaceC4378ad != null) {
            this.f15899f = interfaceC4378ad;
        }
        this.f15895b.m16728a(12002, (String) null, str);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16642a(InterfaceC4377ac interfaceC4377ac) {
        if (interfaceC4377ac != null) {
            this.f15900g = interfaceC4377ac;
        }
        this.f15895b.m16729a(this.f15895b.f15942d, 12003);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16641a(InterfaceC4376ab interfaceC4376ab) {
        if (interfaceC4376ab != null) {
            this.f15896c = interfaceC4376ab;
        }
        this.f15895b.m16727a(12004);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16639a() {
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: b */
    public String mo16647b() {
        return this.f15895b.m16733d();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: c */
    public String mo16648c() {
        return this.f15895b.m16735f();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public String mo16638a(boolean z) {
        return this.f15895b.m16734e();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: d */
    public String mo16649d() {
        return this.f15895b.m16736g();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: e */
    public boolean mo16650e() {
        return this.f15895b.m16731b() && C4368e.m16564a(GlobalApplication.m18732r()).m16566a(C4368e.f15820f);
    }
}
