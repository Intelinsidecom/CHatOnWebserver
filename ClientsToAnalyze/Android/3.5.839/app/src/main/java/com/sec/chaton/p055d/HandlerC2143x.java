package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0791o;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.C2442i;
import com.sec.chaton.p067j.p070c.RunnableC2440g;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.x */
/* loaded from: classes.dex */
class HandlerC2143x extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2142w f7771a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2143x(C2142w c2142w, Looper looper) {
        super(looper);
        this.f7771a = c2142w;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0788l c0788l;
        C0788l c0788l2;
        if (message != null) {
            int i = message.what;
            switch (i) {
                case 1:
                    C2442i c2442i = (C2442i) message.obj;
                    if (c2442i != null) {
                        long jM10609b = c2442i.m10609b();
                        int i2 = message.arg1;
                        int i3 = message.arg2;
                        if (c2442i.m10608a()) {
                            if (C2438e.m10572a().m10581b(jM10609b)) {
                                RunnableC2440g runnableC2440gM10573a = C2438e.m10572a().m10573a(jM10609b);
                                if (runnableC2440gM10573a != null) {
                                    String strM10601f = runnableC2440gM10573a.m10601f();
                                    boolean z = false;
                                    if (TextUtils.isEmpty(strM10601f)) {
                                        z = true;
                                    }
                                    if (!this.f7771a.m9599a(jM10609b, runnableC2440gM10573a.m10599d(), runnableC2440gM10573a.m10598c(), runnableC2440gM10573a.m10597b(), strM10601f, runnableC2440gM10573a.m10600e(), z, runnableC2440gM10573a.m10602g(), runnableC2440gM10573a.m10606k(), runnableC2440gM10573a.m10603h(), runnableC2440gM10573a.m10605j(), runnableC2440gM10573a.m10604i())) {
                                        if (i3 != 0) {
                                            c0788l2 = new C0788l(false, i3);
                                        } else {
                                            c0788l2 = new C0788l(false, EnumC0791o.NETWORKFAIL);
                                        }
                                        this.f7771a.m9242a(0, 0, 101, c0788l2, jM10609b);
                                    }
                                }
                            } else {
                                C0788l c0788l3 = new C0788l(true, EnumC0791o.SUCCESS_UPLOAD_ONLY);
                                RunnableC2440g runnableC2440gM10573a2 = C2438e.m10572a().m10573a(jM10609b);
                                c0788l3.f2174c = runnableC2440gM10573a2 != null ? runnableC2440gM10573a2.m10606k() : "";
                                this.f7771a.m9242a(message.arg1, message.arg2, 101, c0788l3, jM10609b);
                            }
                        } else {
                            if (i3 != 0) {
                                c0788l = new C0788l(false, i3);
                            } else {
                                c0788l = new C0788l(false, EnumC0791o.NETWORKFAIL);
                            }
                            this.f7771a.m9242a(message.arg1, message.arg2, 101, c0788l, jM10609b);
                        }
                        C2716x.m11370a(i, i2, i3, c2442i);
                        C2438e.m10572a().m10582c(jM10609b);
                        break;
                    }
                    break;
            }
        }
    }
}
