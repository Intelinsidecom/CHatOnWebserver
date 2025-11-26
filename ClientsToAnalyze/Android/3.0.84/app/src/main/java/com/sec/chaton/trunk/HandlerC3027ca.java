package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.ca */
/* loaded from: classes.dex */
class HandlerC3027ca extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3018bz f10908a;

    HandlerC3027ca(C3018bz c3018bz) {
        this.f10908a = c3018bz;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10908a.m10415e()) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 902:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", C3018bz.f10879c);
                    }
                    if (this.f10908a.f10889l != null) {
                        this.f10908a.f10889l.handleMessage(Message.obtain(message));
                    }
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS && this.f10908a.f10885h) {
                        this.f10908a.m10522l();
                    }
                    this.f10908a.f10885h = false;
                    if (!this.f10908a.f10892o) {
                        this.f10908a.m10520k();
                        break;
                    }
                    break;
                case 908:
                    if (this.f10908a.f10889l != null) {
                        this.f10908a.f10889l.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
