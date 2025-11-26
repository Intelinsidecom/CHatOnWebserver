package com.sec.chaton.registration;

import android.content.Intent;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.ChatONVService;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatONVListner.java */
/* renamed from: com.sec.chaton.registration.x */
/* loaded from: classes.dex */
public class C3317x implements InterfaceC0418c {

    /* renamed from: a */
    private C0416a f12100a;

    public C3317x() {
        if (C4904y.f17872b) {
            C4904y.m18639b("ChatONVReciever", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m13050a() {
        this.f12100a = new C0416a();
        this.f12100a.m1491a(GlobalApplication.m18732r(), this);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
        C4904y.m18639b("onReceiveCreateAccount" + z + " msg : " + str, getClass().getSimpleName());
        Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
        intent.putExtra("request_type", 1);
        GlobalApplication.m18732r().startService(intent);
        this.f12100a.m1491a(GlobalApplication.m18732r(), (InterfaceC0418c) null);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
        C4904y.m18639b("onReceiveRemoveAccount" + z, getClass().getSimpleName());
    }
}
