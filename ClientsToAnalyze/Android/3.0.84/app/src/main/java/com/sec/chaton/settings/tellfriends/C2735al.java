package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;

/* compiled from: SnsHelperRenren.java */
/* renamed from: com.sec.chaton.settings.tellfriends.al */
/* loaded from: classes.dex */
public class C2735al extends AbstractC2724aa {

    /* renamed from: a */
    private static final String f10096a = C2735al.class.getSimpleName();

    /* renamed from: b */
    private C2819m f10097b;

    /* renamed from: c */
    private InterfaceC2729af f10098c;

    /* renamed from: d */
    private InterfaceC2727ad f10099d;

    /* renamed from: e */
    private InterfaceC2731ah f10100e;

    /* renamed from: f */
    private InterfaceC2787c f10101f = new C2736am(this);

    public C2735al(Activity activity) {
        this.f10097b = new C2819m(activity, this.f10101f);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9770a(InterfaceC2727ad interfaceC2727ad) {
        this.f10099d = interfaceC2727ad;
        this.f10097b.m10053b(12001);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9769a(InterfaceC2726ac interfaceC2726ac) {
    }

    /* renamed from: a */
    public void m9804a(String str, InterfaceC2731ah interfaceC2731ah) {
        this.f10100e = interfaceC2731ah;
        this.f10097b.m10050a(12002, null, str);
    }

    /* renamed from: a */
    public void m9805a(String str, InterfaceC2731ah interfaceC2731ah, String str2) {
        this.f10100e = interfaceC2731ah;
        this.f10097b.m10050a(12002, str, str2);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9771a(InterfaceC2729af interfaceC2729af) {
        this.f10098c = interfaceC2729af;
        this.f10097b.m10049a(12004);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: d */
    public boolean mo9774d() {
        return this.f10097b.m10051a();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: b */
    public String mo9772b() {
        return this.f10097b.m10052b();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public String mo9766a(boolean z) {
        return this.f10097b.m10054c();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: c */
    public String mo9773c() {
        return this.f10097b.m10055d();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9767a() {
        this.f10097b.mo10016e();
    }
}
