package com.sec.chaton.p018c;

import android.os.SystemClock;
import com.sec.chaton.p015b.C0270aj;
import com.sec.chaton.p015b.EnumC0341o;
import com.sec.chaton.p018c.p021c.C0493c;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: NetFlowControl.java */
/* renamed from: com.sec.chaton.c.h */
/* loaded from: classes.dex */
public class C0501h {
    /* renamed from: a */
    public static void m2525a(C0505l c0505l, C0510q c0510q) {
        if (c0510q != null) {
            switch (c0510q.m2573b()) {
                case 14:
                    try {
                        C0270aj c0270aj = (C0270aj) c0510q.m2574c();
                        C1341p.m4660c("ch@t[" + c0270aj.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0270aj.m1150d() + ", SessionID : " + c0270aj.m1154h() + ", Cause : " + c0270aj.m1152f(), C0493c.class.getSimpleName());
                        long jM2554i = c0505l.m2554i() - SystemClock.elapsedRealtime();
                        C1341p.m4660c("Calculated tcp alive delta time: " + jM2554i, C0501h.class.getSimpleName());
                        if (jM2554i > 0) {
                            C1341p.m4658b("Tcp is alive, hold on connection.", C0501h.class.getSimpleName());
                            C0493c.m2495a(c0505l, c0270aj, EnumC0341o.HOLD_ON);
                        } else {
                            C1341p.m4658b("Tcp alive time is over, disconnect connection", C0501h.class.getSimpleName());
                            C0493c.m2495a(c0505l, c0270aj, EnumC0341o.CLOSE);
                            C0505l.m2543c(c0505l);
                        }
                        break;
                    } catch (Exception e) {
                        C1341p.m4653a(e, C0501h.class.getSimpleName());
                        return;
                    }
            }
        }
    }
}
