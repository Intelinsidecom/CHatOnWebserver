package com.sec.chaton.p022h;

import android.os.SystemClock;
import com.sec.chaton.C0229at;
import com.sec.chaton.p007a.C0132ay;
import com.sec.chaton.p007a.EnumC0127at;
import com.sec.chaton.p022h.p023a.C0768d;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: NetFlowControl.java */
/* renamed from: com.sec.chaton.h.n */
/* loaded from: classes.dex */
public class C0804n {
    /* renamed from: a */
    public static void m3414a(C0816z c0816z, C0770ab c0770ab) {
        if (c0770ab != null) {
            switch (c0770ab.m3289b()) {
                case C0229at.HorizontalSrollView_android_paddingLeft /* 14 */:
                    try {
                        C0132ay c0132ay = (C0132ay) c0770ab.m3290c();
                        C1786r.m6063c("ch@t[" + c0132ay.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0132ay.m987d() + ", SessionID : " + c0132ay.m991h() + ", Cause : " + c0132ay.m989f(), C0768d.class.getSimpleName());
                        long jM3460i = c0816z.m3460i() - SystemClock.elapsedRealtime();
                        C1786r.m6063c("Calculated tcp alive delta time: " + jM3460i, C0804n.class.getSimpleName());
                        if (jM3460i > 0) {
                            C1786r.m6061b("Tcp is alive, hold on connection.", C0804n.class.getSimpleName());
                            C0768d.m3276a(c0816z, c0132ay, EnumC0127at.HOLD_ON);
                        } else {
                            C1786r.m6061b("Tcp alive time is over, disconnect connection", C0804n.class.getSimpleName());
                            C0768d.m3276a(c0816z, c0132ay, EnumC0127at.CLOSE);
                            C0816z.m3449c(c0816z);
                        }
                        break;
                    } catch (Exception e) {
                        C1786r.m6056a(e, C0804n.class.getSimpleName());
                        return;
                    }
            }
        }
    }
}
