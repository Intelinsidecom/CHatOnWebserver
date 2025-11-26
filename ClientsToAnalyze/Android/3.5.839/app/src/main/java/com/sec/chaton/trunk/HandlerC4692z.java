package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.z */
/* loaded from: classes.dex */
class HandlerC4692z extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4691y f16966a;

    HandlerC4692z(C4691y c4691y) {
        this.f16966a = c4691y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 904:
                if (this.f16966a.m17512e()) {
                    if (C4904y.f17872b) {
                        C4904y.m18641c("[TRUNK] Received METHOD_ADD_COMMENT", C4691y.f16957c);
                    }
                    if (this.f16966a.f16964j != null) {
                        this.f16966a.f16964j.handleMessage(Message.obtain(message));
                    }
                    if (c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 89411) {
                        try {
                            C4664a.m17659a(this.f16966a.f16959e, C4664a.m17661b(this.f16966a.f16961g));
                            break;
                        } catch (Exception e) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, C4691y.f16957c);
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
