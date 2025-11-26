package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.ce */
/* loaded from: classes.dex */
class HandlerC4647ce extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4646cd f16858a;

    HandlerC4647ce(C4646cd c4646cd) {
        this.f16858a = c4646cd;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f16858a.m17512e()) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 902:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", C4646cd.f16842c);
                    }
                    if (this.f16858a.f16852l != null) {
                        this.f16858a.f16852l.handleMessage(Message.obtain(message));
                    }
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS && this.f16858a.f16848h) {
                        this.f16858a.m17637l();
                    }
                    this.f16858a.f16848h = false;
                    if (!this.f16858a.f16855o) {
                        this.f16858a.m17635k();
                        break;
                    }
                    break;
                case 908:
                    if (this.f16858a.f16852l != null) {
                        this.f16858a.f16852l.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
