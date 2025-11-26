package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetVersionNotice;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.t */
/* loaded from: classes.dex */
class HandlerC1095t extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f3747a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1095t(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f3747a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        C0259g c0259g = (C0259g) message.obj;
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR && (getVersionNotice = (GetVersionNotice) c0259g.m932d()) != null) {
            if (getVersionNotice.uptodate.booleanValue()) {
                this.f3747a.m653i();
                this.f3747a.m654j();
            } else {
                this.f3747a.m632a(getVersionNotice, false);
            }
        }
    }
}
