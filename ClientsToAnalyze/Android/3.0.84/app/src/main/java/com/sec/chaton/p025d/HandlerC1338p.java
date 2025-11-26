package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0275l;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.p037j.p040c.C1565k;
import com.sec.chaton.p037j.p040c.RunnableC1563i;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.p */
/* loaded from: classes.dex */
class HandlerC1338p extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1337o f5062a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1338p(C1337o c1337o, Looper looper) {
        super(looper);
        this.f5062a = c1337o;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0272i c0272i;
        C0272i c0272i2;
        if (message != null) {
            int i = message.what;
            switch (i) {
                case 1:
                    C1565k c1565k = (C1565k) message.obj;
                    if (c1565k != null) {
                        long jM6665b = c1565k.m6665b();
                        int i2 = message.arg1;
                        int i3 = message.arg2;
                        if (c1565k.m6664a()) {
                            if (C1561g.m6628a().m6637b(jM6665b)) {
                                RunnableC1563i runnableC1563iM6629a = C1561g.m6628a().m6629a(jM6665b);
                                if (runnableC1563iM6629a != null) {
                                    String strM6657f = runnableC1563iM6629a.m6657f();
                                    boolean z = false;
                                    if (TextUtils.isEmpty(strM6657f)) {
                                        z = true;
                                    }
                                    if (!this.f5062a.m5802a(jM6665b, runnableC1563iM6629a.m6655d(), runnableC1563iM6629a.m6654c(), runnableC1563iM6629a.m6653b(), strM6657f, runnableC1563iM6629a.m6656e(), z, runnableC1563iM6629a.m6658g(), runnableC1563iM6629a.m6662k(), runnableC1563iM6629a.m6659h(), runnableC1563iM6629a.m6661j(), runnableC1563iM6629a.m6660i())) {
                                        if (i3 != 0) {
                                            c0272i2 = new C0272i(false, i3);
                                        } else {
                                            c0272i2 = new C0272i(false, EnumC0275l.NETWORKFAIL);
                                        }
                                        this.f5062a.m5799a(0, 0, 101, c0272i2, jM6665b);
                                    }
                                }
                            } else {
                                C0272i c0272i3 = new C0272i(true, EnumC0275l.SUCCESS_UPLOAD_ONLY);
                                RunnableC1563i runnableC1563iM6629a2 = C1561g.m6628a().m6629a(jM6665b);
                                c0272i3.f860c = runnableC1563iM6629a2 != null ? runnableC1563iM6629a2.m6662k() : "";
                                this.f5062a.m5799a(message.arg1, message.arg2, 101, c0272i3, jM6665b);
                            }
                        } else {
                            if (i3 != 0) {
                                c0272i = new C0272i(false, i3);
                            } else {
                                c0272i = new C0272i(false, EnumC0275l.NETWORKFAIL);
                            }
                            this.f5062a.m5799a(message.arg1, message.arg2, 101, c0272i, jM6665b);
                        }
                        C1756p.m7226a(i, i2, i3, c1565k);
                        C1561g.m6628a().m6638c(jM6665b);
                        break;
                    }
                    break;
            }
        }
    }
}
