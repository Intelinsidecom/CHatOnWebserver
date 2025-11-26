package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetVersionNotice;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.u */
/* loaded from: classes.dex */
class HandlerC1201u extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f4080a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1201u(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f4080a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        C0259g c0259g = (C0259g) message.obj;
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR && (getVersionNotice = (GetVersionNotice) c0259g.m932d()) != null) {
            if (getVersionNotice.uptodate.booleanValue()) {
                this.f4080a.m653i();
                this.f4080a.m654j();
            } else {
                this.f4080a.m632a(getVersionNotice, true);
            }
            C1341p.m4658b("mdisclaimer : " + this.f4080a.f253g, getClass().getSimpleName());
            if (C1323bs.m4575a().getString("first_disclaimer_status", "").equals("DONE")) {
                if (!this.f4080a.f253g.equals("RUN")) {
                    if (getVersionNotice.needPopup.booleanValue() && getVersionNotice.disclaimerUID != null) {
                        this.f4080a.m641c(getVersionNotice.disclaimerUID);
                    } else {
                        C1341p.m4658b("needPopup or disclaimerUID is null", getClass().getSimpleName());
                    }
                }
                if (!C1323bs.m4575a().contains("is_first_accept")) {
                    C1341p.m4658b("Accept time : " + C1323bs.m4575a().getString("accept_time", "") + " Server time: " + C1323bs.m4575a().getString("server_time", ""), getClass().getSimpleName());
                    C1323bs.m4579a("accept_time", C1323bs.m4575a().getString("server_time", ""));
                    C1323bs.m4576a("is_first_accept", (Boolean) true);
                }
            }
        }
    }
}
