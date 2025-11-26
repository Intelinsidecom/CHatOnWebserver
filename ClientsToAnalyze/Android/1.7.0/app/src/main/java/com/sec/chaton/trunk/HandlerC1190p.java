package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.p */
/* loaded from: classes.dex */
class HandlerC1190p extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1149bm f4059a;

    HandlerC1190p(C1149bm c1149bm) {
        this.f4059a = c1149bm;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 904:
                if (this.f4059a.m4179j()) {
                    if (C1341p.f4578b) {
                        C1341p.m4660c("[TRUNK] Received METHOD_ADD_COMMENT", C1149bm.f3982c);
                    }
                    if (this.f4059a.f3989j != null) {
                        this.f4059a.f3989j.handleMessage(Message.obtain(message));
                    }
                    if (c0259g.m928b() == EnumC0518y.ERROR && c0259g.m934f() == 89411) {
                        try {
                            C1173b.m4237a(this.f4059a.f3984e, C1173b.m4239b(this.f4059a.f3986g));
                            break;
                        } catch (Exception e) {
                            if (C1341p.f4581e) {
                                C1341p.m4653a(e, C1149bm.f3982c);
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
