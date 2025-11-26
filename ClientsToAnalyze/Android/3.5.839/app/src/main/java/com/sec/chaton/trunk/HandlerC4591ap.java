package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkFullPresenter.java */
/* renamed from: com.sec.chaton.trunk.ap */
/* loaded from: classes.dex */
class HandlerC4591ap extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4590ao f16721a;

    HandlerC4591ap(C4590ao c4590ao) {
        this.f16721a = c4590ao;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f16721a.m17512e()) {
            switch (message.what) {
                case 2:
                    if (this.f16721a.f16716p != null) {
                        this.f16721a.f16716p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 3:
                    if (this.f16721a.f16716p != null) {
                        this.f16721a.f16716p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 4:
                    if (this.f16721a.f16716p != null) {
                        this.f16721a.f16716p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 901:
                    C0778b c0778b = (C0778b) message.obj;
                    if (this.f16721a.f16716p != null) {
                        this.f16721a.f16716p.handleMessage(Message.obtain(message));
                    }
                    if (c0778b.m3107b() != EnumC2464o.ERROR || c0778b.m3111f() != 86411) {
                        this.f16721a.m17547n();
                        break;
                    } else {
                        try {
                            C4664a.m17659a(this.f16721a.f16705e, C4664a.m17661b(this.f16721a.f16708h));
                            break;
                        } catch (Exception e) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, C4590ao.f16703c);
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 905:
                    if (this.f16721a.f16716p != null) {
                        this.f16721a.f16716p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
