package com.sec.chaton;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.v */
/* loaded from: classes.dex */
class HandlerC1795v extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f6467a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1795v(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f6467a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        C0101b c0101b = (C0101b) message.obj;
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR && (getVersionNotice = (GetVersionNotice) c0101b.m671d()) != null) {
            if (getVersionNotice.uptodate.booleanValue()) {
                C1789u.m6075a().edit().remove("UpdateIsCritical").commit();
                C1789u.m6075a().edit().remove("UpdateTargetVersion").commit();
                C1789u.m6075a().edit().remove("UpdateUrl").commit();
                C1789u.m6075a().edit().remove("SamsungappsUrl").commit();
                this.f6467a.m606j();
            } else {
                Context applicationContext = this.f6467a.getApplicationContext();
                if (!this.f6467a.m609a(applicationContext).equals(ActivityPasswordLockSet.m4532c())) {
                    this.f6467a.m588a(getVersionNotice, true);
                } else {
                    C1786r.m6061b("getClassName : " + this.f6467a.m609a(applicationContext), getClass().getSimpleName());
                    return;
                }
            }
            String strM605i = this.f6467a.m605i();
            C1786r.m6061b("Disclaimer statue : " + strM605i, getClass().getSimpleName());
            if (!strM605i.equals("RUN")) {
                if (getVersionNotice.needPopup.booleanValue() && getVersionNotice.disclaimerUID != null) {
                    this.f6467a.m591b(getVersionNotice.disclaimerUID);
                } else {
                    C1786r.m6061b("needPopup or disclaimerUID is null", getClass().getSimpleName());
                }
            } else {
                C1786r.m6065d("Disclaimer State is running", getClass().getSimpleName());
            }
            if (!C1789u.m6075a().contains("is_first_accept")) {
                C1786r.m6061b("Accept time : " + C1789u.m6075a().getString("accept_time", "") + " Server time: " + C1789u.m6075a().getString("server_time", ""), getClass().getSimpleName());
                C1789u.m6079a("accept_time", C1789u.m6075a().getString("server_time", ""));
                C1789u.m6076a("is_first_accept", (Boolean) true);
            }
        }
    }
}
