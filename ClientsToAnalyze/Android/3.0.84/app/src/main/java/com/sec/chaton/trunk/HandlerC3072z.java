package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.z */
/* loaded from: classes.dex */
class HandlerC3072z extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3071y f11017a;

    HandlerC3072z(C3071y c3071y) {
        this.f11017a = c3071y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 904:
                if (this.f11017a.m10415e()) {
                    if (C3250y.f11734b) {
                        C3250y.m11453c("[TRUNK] Received METHOD_ADD_COMMENT", C3071y.f11008c);
                    }
                    if (this.f11017a.f11015j != null) {
                        this.f11017a.f11015j.handleMessage(Message.obtain(message));
                    }
                    if (c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 89411) {
                        try {
                            C3044a.m10564a(this.f11017a.f11010e, C3044a.m10566b(this.f11017a.f11012g));
                            break;
                        } catch (Exception e) {
                            if (C3250y.f11737e) {
                                C3250y.m11443a(e, C3071y.f11008c);
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
