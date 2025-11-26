package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bg */
/* loaded from: classes.dex */
class HandlerC1143bg extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1105ac f3973a;

    HandlerC1143bg(C1105ac c1105ac) {
        this.f3973a = c1105ac;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f3973a.m4179j()) {
            C0259g c0259g = (C0259g) message.obj;
            switch (message.what) {
                case 902:
                    if (C1341p.f4578b) {
                        C1341p.m4658b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", C1105ac.f3884c);
                    }
                    if (this.f3973a.f3893k != null) {
                        this.f3973a.f3893k.handleMessage(Message.obtain(message));
                    }
                    if (c0259g.m928b() == EnumC0518y.SUCCESS && this.f3973a.f3890h) {
                        this.f3973a.m4139l();
                    }
                    this.f3973a.f3890h = false;
                    if (!this.f3973a.f3896n) {
                        this.f3973a.m4138k();
                        break;
                    }
                    break;
            }
        }
    }
}
