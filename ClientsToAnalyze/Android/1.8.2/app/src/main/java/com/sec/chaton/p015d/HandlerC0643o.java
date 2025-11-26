package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p007a.p008a.EnumC0106g;
import com.sec.chaton.p022h.p025c.C0779c;
import com.sec.chaton.p022h.p025c.C0783g;
import com.sec.chaton.p022h.p025c.RunnableC0781e;

/* compiled from: MessageControl.java */
/* renamed from: com.sec.chaton.d.o */
/* loaded from: classes.dex */
class HandlerC0643o extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0639k f2507a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0643o(C0639k c0639k, Looper looper) {
        super(looper);
        this.f2507a = c0639k;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0103d c0103d;
        if (message != null) {
            switch (message.what) {
                case 1:
                    C0783g c0783g = (C0783g) message.obj;
                    if (c0783g != null) {
                        long jM3365b = c0783g.m3365b();
                        int i = message.arg1;
                        int i2 = message.arg2;
                        if (c0783g.m3364a()) {
                            if (C0779c.m3335a().m3341c(jM3365b)) {
                                RunnableC0781e runnableC0781eM3336a = C0779c.m3335a().m3336a(jM3365b);
                                String strM3358e = null;
                                if (runnableC0781eM3336a != null) {
                                    strM3358e = runnableC0781eM3336a.m3358e();
                                }
                                boolean z = TextUtils.isEmpty(strM3358e);
                                if (runnableC0781eM3336a != null) {
                                    this.f2507a.m2908a(jM3365b, runnableC0781eM3336a.m3356c(), runnableC0781eM3336a.m3355b(), runnableC0781eM3336a.m3352a(), strM3358e, runnableC0781eM3336a.m3357d(), z, runnableC0781eM3336a.m3359f(), runnableC0781eM3336a.m3361h(), runnableC0781eM3336a.m3360g());
                                }
                            } else {
                                C0103d c0103d2 = new C0103d(true, EnumC0106g.SUCCESS_UPLOAD_ONLY);
                                c0103d2.f335c = C0779c.m3335a().m3336a(jM3365b).m3361h();
                                this.f2507a.m2907a(0, 0, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END, c0103d2, jM3365b);
                            }
                        } else {
                            if (i2 != 0) {
                                c0103d = new C0103d(false, i2);
                            } else {
                                c0103d = new C0103d(false, EnumC0106g.NETWORKFAIL);
                            }
                            this.f2507a.m2907a(0, 0, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END, c0103d, jM3365b);
                        }
                        C0779c.m3335a().m3342d(jM3365b);
                        break;
                    }
                    break;
            }
        }
    }
}
