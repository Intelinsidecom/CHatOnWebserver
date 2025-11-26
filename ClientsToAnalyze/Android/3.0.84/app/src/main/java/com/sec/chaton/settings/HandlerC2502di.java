package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.di */
/* loaded from: classes.dex */
class HandlerC2502di extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f9392a;

    HandlerC2502di(DeregisterFragment deregisterFragment) {
        this.f9392a = deregisterFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9392a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 202:
                    this.f9392a.m9089c();
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || this.f9392a.f9123h == null || !this.f9392a.f9123h.m5508i()) {
                        this.f9392a.m9091d();
                        C3250y.m11442a("ChatON deregistration is fail.", DeregisterFragment.f9115l);
                        break;
                    } else {
                        C3250y.m11450b("ChatON deregistration is success.", DeregisterFragment.f9115l);
                        Intent intent = new Intent();
                        intent.setAction("com.sec.chaton.action.USER_DEREGISTRATION");
                        CommonApplication.m11493l().sendBroadcast(intent);
                        C3641ai.m13211a(this.f9392a.getActivity(), this.f9392a.getResources().getString(R.string.toast_account_deleted2), 0).show();
                        GlobalApplication.m6449a(this.f9392a.getActivity());
                        break;
                    }
            }
        }
    }
}
