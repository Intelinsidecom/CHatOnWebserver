package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bu */
/* loaded from: classes.dex */
class HandlerC2771bu extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2770bt f10198a;

    HandlerC2771bu(C2770bt c2770bt) {
        this.f10198a = c2770bt;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 313:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    C2831y.m10064a(this.f10198a.f10300b).m10066a(C2831y.f10364c, true);
                    break;
                } else {
                    C2831y.m10064a(this.f10198a.f10300b).m10066a(C2831y.f10364c, false);
                    break;
                }
                break;
        }
    }
}
