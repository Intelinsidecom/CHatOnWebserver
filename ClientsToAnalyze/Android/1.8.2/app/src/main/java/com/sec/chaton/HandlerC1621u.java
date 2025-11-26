package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.util.C1789u;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.u */
/* loaded from: classes.dex */
class HandlerC1621u extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f5772a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1621u(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f5772a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        C0101b c0101b = (C0101b) message.obj;
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR && (getVersionNotice = (GetVersionNotice) c0101b.m671d()) != null) {
            if (!getVersionNotice.uptodate.booleanValue()) {
                this.f5772a.m588a(getVersionNotice, false);
                return;
            }
            C1789u.m6075a().edit().remove("UpdateIsCritical").commit();
            C1789u.m6075a().edit().remove("UpdateTargetVersion").commit();
            C1789u.m6075a().edit().remove("UpdateUrl").commit();
            C1789u.m6075a().edit().remove("SamsungappsUrl").commit();
            this.f5772a.m606j();
        }
    }
}
