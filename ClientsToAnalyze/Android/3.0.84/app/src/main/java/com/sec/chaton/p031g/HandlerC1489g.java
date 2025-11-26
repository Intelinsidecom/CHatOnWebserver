package com.sec.chaton.p031g;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.tellfriends.C2831y;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.g */
/* loaded from: classes.dex */
class HandlerC1489g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1483a f5503a;

    HandlerC1489g(C1483a c1483a) {
        this.f5503a = c1483a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 313:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    C2831y.m10064a(this.f5503a.f5492c).m10066a(C2831y.f10362a, false);
                    break;
                } else {
                    C2831y.m10064a(this.f5503a.f5492c).m10066a(C2831y.f10362a, true);
                    break;
                }
                break;
        }
    }
}
