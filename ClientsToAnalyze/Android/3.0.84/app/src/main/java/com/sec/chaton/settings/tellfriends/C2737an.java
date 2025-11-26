package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;

/* compiled from: SnsHelperTwitter.java */
/* renamed from: com.sec.chaton.settings.tellfriends.an */
/* loaded from: classes.dex */
public class C2737an extends AbstractC2724aa {

    /* renamed from: a */
    private static final String f10103a = C2737an.class.getSimpleName();

    /* renamed from: b */
    private C2751ba f10104b;

    /* renamed from: c */
    private InterfaceC2729af f10105c;

    /* renamed from: d */
    private InterfaceC2730ag f10106d;

    /* renamed from: e */
    private InterfaceC2727ad f10107e;

    /* renamed from: f */
    private InterfaceC2731ah f10108f;

    /* renamed from: g */
    private InterfaceC2726ac f10109g;

    /* renamed from: h */
    private InterfaceC2728ae f10110h;

    /* renamed from: i */
    private InterfaceC2787c f10111i = new C2738ao(this);

    public C2737an(Activity activity) {
        this.f10104b = new C2751ba(activity, this.f10111i);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9767a() {
        this.f10104b.mo10016e();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9770a(InterfaceC2727ad interfaceC2727ad) {
        this.f10107e = interfaceC2727ad;
        this.f10104b.m9857b(12001);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9769a(InterfaceC2726ac interfaceC2726ac) {
        this.f10109g = interfaceC2726ac;
        this.f10104b.m9859c(12006);
    }

    /* renamed from: a */
    public void m9813a(String str, InterfaceC2731ah interfaceC2731ah) {
        this.f10108f = interfaceC2731ah;
        this.f10104b.m9853a(12002, null, str);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9771a(InterfaceC2729af interfaceC2729af) {
        this.f10105c = interfaceC2729af;
        this.f10104b.m9852a(12004);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: d */
    public boolean mo9774d() {
        return this.f10104b.m9855a();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: b */
    public String mo9772b() {
        return this.f10104b.m9856b();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public String mo9766a(boolean z) {
        String strM9858c = this.f10104b.m9858c();
        if (z && strM9858c.contains("_normal")) {
            return strM9858c.replace("_normal", "");
        }
        return strM9858c;
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: c */
    public String mo9773c() {
        return this.f10104b.m9860d();
    }

    /* renamed from: e */
    public boolean m9814e() {
        return this.f10104b.m9861f();
    }
}
