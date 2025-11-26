package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bd */
/* loaded from: classes.dex */
class HandlerC1555bd extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1554bc f5632a;

    HandlerC1555bd(C1554bc c1554bc) {
        this.f5632a = c1554bc;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f5632a.m5358e()) {
            C0101b c0101b = (C0101b) message.obj;
            switch (message.what) {
                case 902:
                    if (C1786r.f6452b) {
                        C1786r.m6061b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", C1554bc.f5617c);
                    }
                    if (this.f5632a.f5626k != null) {
                        this.f5632a.f5626k.handleMessage(Message.obtain(message));
                    }
                    if (c0101b.m665b() == EnumC0803m.SUCCESS && this.f5632a.f5623h) {
                        this.f5632a.m5424l();
                    }
                    this.f5632a.f5623h = false;
                    if (!this.f5632a.f5629n) {
                        this.f5632a.m5423k();
                        break;
                    }
                    break;
            }
        }
    }
}
