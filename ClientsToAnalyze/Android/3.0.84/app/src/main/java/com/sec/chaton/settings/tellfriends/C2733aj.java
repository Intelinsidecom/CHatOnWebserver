package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.p031g.C1483a;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;

/* compiled from: SnsHelperFacebook.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aj */
/* loaded from: classes.dex */
public class C2733aj extends AbstractC2724aa {

    /* renamed from: a */
    private static final String f10088a = C2733aj.class.getSimpleName();

    /* renamed from: b */
    private C1483a f10089b;

    /* renamed from: c */
    private InterfaceC2787c f10090c = new C2734ak(this);

    /* renamed from: d */
    private InterfaceC2727ad f10091d;

    /* renamed from: e */
    private InterfaceC2731ah f10092e;

    /* renamed from: f */
    private InterfaceC2730ag f10093f;

    /* renamed from: g */
    private InterfaceC2729af f10094g;

    public C2733aj(Activity activity) {
        this.f10089b = new C1483a(activity, this.f10090c);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9767a() {
        this.f10089b.m6445g();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9770a(InterfaceC2727ad interfaceC2727ad) {
        this.f10091d = interfaceC2727ad;
        this.f10089b.m6444f();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9769a(InterfaceC2726ac interfaceC2726ac) {
    }

    /* renamed from: a */
    public void m9797a(String str, InterfaceC2731ah interfaceC2731ah, String str2) {
        this.f10092e = interfaceC2731ah;
        this.f10089b.m6438a(1, str, str2);
    }

    /* renamed from: a */
    public void m9796a(String str, InterfaceC2731ah interfaceC2731ah) {
        this.f10092e = interfaceC2731ah;
        this.f10089b.m6437a(1, str);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9771a(InterfaceC2729af interfaceC2729af) {
        this.f10094g = interfaceC2729af;
        this.f10089b.m6435a(3);
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: d */
    public boolean mo9774d() {
        return this.f10089b.m6443e();
    }

    /* renamed from: e */
    public String m9798e() {
        return this.f10089b.m6441c();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: b */
    public String mo9772b() {
        return this.f10089b.m6434a();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: c */
    public String mo9773c() {
        return this.f10089b.m6440b();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public String mo9766a(boolean z) {
        return z ? m9795a(600, 600) : this.f10089b.m6442d();
    }

    /* renamed from: a */
    public String m9795a(int i, int i2) {
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        Uri.Builder builderEncodedPath = new Uri.Builder().encodedPath(this.f10089b.m6442d());
        builderEncodedPath.appendQueryParameter("width", String.valueOf(iMax));
        builderEncodedPath.appendQueryParameter("height", String.valueOf(iMax2));
        builderEncodedPath.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return builderEncodedPath.toString();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC2724aa
    /* renamed from: a */
    public void mo9768a(int i, int i2, Intent intent) {
        this.f10089b.m6436a(i, i2, intent);
    }
}
