package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.w */
/* loaded from: classes.dex */
class HandlerC1617w extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1616v f5768a;

    HandlerC1617w(C1616v c1616v) {
        this.f5768a = c1616v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 904:
                if (this.f5768a.m5358e()) {
                    if (C1786r.f6452b) {
                        C1786r.m6063c("[TRUNK] Received METHOD_ADD_COMMENT", C1616v.f5759c);
                    }
                    if (this.f5768a.f5766j != null) {
                        this.f5768a.f5766j.handleMessage(Message.obtain(message));
                    }
                    if (c0101b.m665b() == EnumC0803m.ERROR && c0101b.m673f() == 89411) {
                        try {
                            C1584a.m5471a(this.f5768a.f5761e, C1584a.m5473b(this.f5768a.f5763g));
                            break;
                        } catch (Exception e) {
                            if (C1786r.f6455e) {
                                C1786r.m6056a(e, C1616v.f5759c);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
        }
    }
}
