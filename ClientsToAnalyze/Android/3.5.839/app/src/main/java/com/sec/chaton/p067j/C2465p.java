package com.sec.chaton.p067j;

import android.os.SystemClock;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.C0840bu;
import com.sec.chaton.p046a.EnumC0835bp;
import com.sec.chaton.p067j.p068a.C2411a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: NetFlowControl.java */
/* renamed from: com.sec.chaton.j.p */
/* loaded from: classes.dex */
public class C2465p {
    /* renamed from: a */
    public static void m10669a(C2422ak c2422ak, C2426ao c2426ao) {
        if (c2426ao != null) {
            switch (c2426ao.m10512b()) {
                case 14:
                    try {
                        C0840bu c0840bu = (C0840bu) c2426ao.m10513c();
                        C4904y.m18641c("ch@t[" + c0840bu.getClass().getSimpleName() + "]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", MsgID : " + c0840bu.m3775d() + ", SessionID : " + c0840bu.m3779h() + ", Cause : " + c0840bu.m3777f(), C2411a.class.getSimpleName());
                        long jM10498i = c2422ak.m10498i() - SystemClock.elapsedRealtime();
                        C4904y.m18641c("Calculated tcp alive delta time: " + jM10498i, C2465p.class.getSimpleName());
                        if (C2349a.m10301a("active_connection_feature")) {
                            C4904y.m18639b("active connection ON, disconnect connection", C2465p.class.getSimpleName());
                            C2411a.m10445a(c2422ak, c0840bu, EnumC0835bp.CLOSE);
                            C2422ak.m10484c(c2422ak);
                        } else if (jM10498i > 0) {
                            C4904y.m18639b("Tcp is alive, hold on connection.", C2465p.class.getSimpleName());
                            C2411a.m10445a(c2422ak, c0840bu, EnumC0835bp.HOLD_ON);
                        } else {
                            C4904y.m18639b("Tcp alive time is over, disconnect connection", C2465p.class.getSimpleName());
                            C2411a.m10445a(c2422ak, c0840bu, EnumC0835bp.CLOSE);
                            C2422ak.m10484c(c2422ak);
                        }
                        break;
                    } catch (Exception e) {
                        C4904y.m18635a(e, C2465p.class.getSimpleName());
                        return;
                    }
            }
        }
    }
}
