package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;

/* compiled from: SNSIDSet.java */
/* renamed from: com.sec.chaton.settings.tellfriends.z */
/* loaded from: classes.dex */
class HandlerC2832z extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2831y f10375a;

    HandlerC2832z(C2831y c2831y) {
        this.f10375a = c2831y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 313:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f10375a.m10066a(this.f10375a.f10374m, false);
                    break;
                } else {
                    this.f10375a.m10066a(this.f10375a.f10374m, true);
                    break;
                }
                break;
        }
    }
}
