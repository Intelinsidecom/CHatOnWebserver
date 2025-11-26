package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;

/* compiled from: SnsHelperWeibo.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ap */
/* loaded from: classes.dex */
public class C2739ap extends AbstractC2724aa {

    /* renamed from: a */
    private static final String f10113a = C2739ap.class.getSimpleName();

    /* renamed from: b */
    private C2770bt f10114b;

    /* renamed from: c */
    private InterfaceC2730ag f10115c;

    /* renamed from: d */
    private InterfaceC2729af f10116d;

    /* renamed from: e */
    private InterfaceC2727ad f10117e;

    /* renamed from: f */
    private InterfaceC2731ah f10118f;

    /* renamed from: g */
    private InterfaceC2726ac f10119g;

    /* renamed from: h */
    private InterfaceC2728ae f10120h;

    /* renamed from: i */
    private InterfaceC2787c f10121i = new C2740aq(this);

    public C2739ap(Activity activity) {
        this.f10114b = new C2770bt(activity, this.f10121i);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9767a() {
        this.f10114b.mo10016e();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9770a(InterfaceC2727ad interfaceC2727ad) {
        this.f10117e = interfaceC2727ad;
        this.f10114b.m9910b(12001);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9769a(InterfaceC2726ac interfaceC2726ac) {
        this.f10119g = interfaceC2726ac;
        this.f10114b.m9912c(12006);
    }

    /* renamed from: a */
    public void m9822a(String str, InterfaceC2731ah interfaceC2731ah) {
        this.f10118f = interfaceC2731ah;
        this.f10114b.m9906a(12002, null, str);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9771a(InterfaceC2729af interfaceC2729af) {
        this.f10116d = interfaceC2729af;
        this.f10114b.m9905a(12004);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: d */
    public boolean mo9774d() {
        return this.f10114b.m9908a();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: b */
    public String mo9772b() {
        return this.f10114b.m9909b();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public String mo9766a(boolean z) {
        return this.f10114b.m9911c();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: c */
    public String mo9773c() {
        return this.f10114b.m9913d();
    }
}
