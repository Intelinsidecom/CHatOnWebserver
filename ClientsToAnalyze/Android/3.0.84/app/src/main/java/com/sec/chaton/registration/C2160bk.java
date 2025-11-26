package com.sec.chaton.registration;

import android.content.Intent;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.ChatONVService;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatONVListner.java */
/* renamed from: com.sec.chaton.registration.bk */
/* loaded from: classes.dex */
public class C2160bk implements InterfaceC0047c {

    /* renamed from: a */
    private C0045a f8441a;

    public C2160bk() {
        if (C3250y.f11734b) {
            C3250y.m11450b("ChatONVReciever", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m8674a() {
        this.f8441a = new C0045a();
        this.f8441a.m51a(GlobalApplication.m11493l(), this);
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
        C3250y.m11450b("onReceiveCreateAccount" + z, getClass().getSimpleName());
        Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
        intent.putExtra("request_type", 1);
        GlobalApplication.m11493l().startService(intent);
        this.f8441a.m51a(GlobalApplication.m11493l(), (InterfaceC0047c) null);
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        C3250y.m11450b("onReceiveRemoveAccount" + z, getClass().getSimpleName());
    }
}
