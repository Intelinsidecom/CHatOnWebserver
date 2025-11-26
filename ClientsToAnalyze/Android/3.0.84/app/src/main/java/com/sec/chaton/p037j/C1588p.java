package com.sec.chaton.p037j;

import android.os.SystemClock;
import com.sec.chaton.p016a.C0321br;
import com.sec.chaton.p016a.EnumC0316bm;
import com.sec.chaton.p037j.p038a.C1541a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: NetFlowControl.java */
/* renamed from: com.sec.chaton.j.p */
/* loaded from: classes.dex */
public class C1588p {
    /* renamed from: a */
    public static void m6725a(C1544ac c1544ac, C1548ag c1548ag) {
        if (c1548ag != null) {
            switch (c1548ag.m6574b()) {
                case 14:
                    try {
                        C0321br c0321br = (C0321br) c1548ag.m6575c();
                        C3250y.m11453c("ch@t[" + c0321br.getClass().getSimpleName() + "]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", MsgID : " + c0321br.m1899d() + ", SessionID : " + c0321br.m1903h() + ", Cause : " + c0321br.m1901f(), C1541a.class.getSimpleName());
                        long jM6562i = c1544ac.m6562i() - SystemClock.elapsedRealtime();
                        C3250y.m11453c("Calculated tcp alive delta time: " + jM6562i, C1588p.class.getSimpleName());
                        if (jM6562i > 0) {
                            C3250y.m11450b("Tcp is alive, hold on connection.", C1588p.class.getSimpleName());
                            C1541a.m6541a(c1544ac, c0321br, EnumC0316bm.HOLD_ON);
                        } else {
                            C3250y.m11450b("Tcp alive time is over, disconnect connection", C1588p.class.getSimpleName());
                            C1541a.m6541a(c1544ac, c0321br, EnumC0316bm.CLOSE);
                            C1544ac.m6548c(c1544ac);
                        }
                        break;
                    } catch (Exception e) {
                        C3250y.m11443a(e, C1588p.class.getSimpleName());
                        return;
                    }
            }
        }
    }
}
