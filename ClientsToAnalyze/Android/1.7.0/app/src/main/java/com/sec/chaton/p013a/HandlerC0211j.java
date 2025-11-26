package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p015b.p016a.EnumC0256d;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p018c.p019a.C0475l;
import com.sec.chaton.p018c.p019a.RunnableC0474k;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.a.j */
/* loaded from: classes.dex */
class HandlerC0211j extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0223v f513a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0211j(C0223v c0223v, Looper looper) {
        super(looper);
        this.f513a = c0223v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0257e c0257e;
        if (message != null) {
            switch (message.what) {
                case 1:
                    C0475l c0475l = (C0475l) message.obj;
                    if (c0475l != null) {
                        long jM2435b = c0475l.m2435b();
                        int i = message.arg1;
                        int i2 = message.arg2;
                        if (c0475l.m2434a()) {
                            RunnableC0474k runnableC0474kM2390a = C0468e.m2389a().m2390a(jM2435b);
                            String strM2429e = null;
                            if (runnableC0474kM2390a != null) {
                                strM2429e = runnableC0474kM2390a.m2429e();
                            }
                            boolean z = TextUtils.isEmpty(strM2429e);
                            if (runnableC0474kM2390a != null) {
                                this.f513a.m811a(jM2435b, runnableC0474kM2390a.m2427c(), runnableC0474kM2390a.m2426b(), runnableC0474kM2390a.m2423a(), strM2429e, runnableC0474kM2390a.m2428d(), z, runnableC0474kM2390a.m2430f(), runnableC0474kM2390a.m2431g());
                            }
                        } else {
                            if (i2 != 0) {
                                c0257e = new C0257e(false, i2);
                            } else {
                                c0257e = new C0257e(false, EnumC0256d.NETWORKFAIL);
                            }
                            this.f513a.m810a(0, 0, 1024, c0257e, jM2435b);
                        }
                        C0468e.m2389a().m2395c(jM2435b);
                        break;
                    }
                    break;
            }
        }
    }
}
