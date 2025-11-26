package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bb */
/* loaded from: classes.dex */
class HandlerC2752bb extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2751ba f10154a;

    HandlerC2752bb(C2751ba c2751ba) {
        this.f10154a = c2751ba;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 313:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    C2831y.m10064a(this.f10154a.f10300b).m10066a(C2831y.f10363b, true);
                    break;
                } else {
                    C2831y.m10064a(this.f10154a.f10300b).m10066a(C2831y.f10363b, false);
                    break;
                }
                break;
            case 12005:
                this.f10154a.m9854a((String) message.obj);
                break;
        }
    }
}
