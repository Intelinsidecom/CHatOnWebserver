package com.sec.chaton.registration;

import android.content.Context;
import android.os.Handler;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.util.C3250y;

@Deprecated
/* loaded from: classes.dex */
public class BackGroudDeleteAccount implements InterfaceC0047c {

    /* renamed from: h */
    private static final String f8168h = BackGroudDeleteAccount.class.getSimpleName();

    /* renamed from: a */
    Handler f8169a = new HandlerC2158bi(this);

    /* renamed from: b */
    Handler f8170b = new HandlerC2159bj(this);

    /* renamed from: c */
    private AbstractC1144a<?> f8171c;

    /* renamed from: d */
    private C1303ap f8172d;

    /* renamed from: e */
    private C1156ak f8173e;

    /* renamed from: f */
    private Context f8174f;

    /* renamed from: g */
    private boolean f8175g;

    @Deprecated
    public BackGroudDeleteAccount(Context context, boolean z) {
        this.f8174f = context;
        this.f8175g = z;
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        C3250y.m11450b("onReceiveRemoveAccount" + z, getClass().getSimpleName());
        if (z) {
            if (this.f8171c != null) {
                this.f8171c.mo5481b(this.f8169a);
            }
        } else {
            this.f8173e = null;
            this.f8170b.sendEmptyMessage(202);
        }
    }
}
