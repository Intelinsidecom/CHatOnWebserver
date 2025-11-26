package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.C1994dm;
import com.sec.chaton.p055d.p056a.C1995dn;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p065io.entry.LiveChatDeliveryMessageEntry;
import com.sec.chaton.p065io.entry.LiveChatFeedbackResponseEntry;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.specialbuddy.p117a.C4526b;
import com.sec.chaton.specialbuddy.p117a.C4529e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: LiveChatMessageControl.java */
/* renamed from: com.sec.chaton.d.u */
/* loaded from: classes.dex */
public class C2140u {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m9589b(Handler handler, String str, EnumC2214ab enumC2214ab, String str2, String str3, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("imei=").append(C4809aa.m18104a().m18121a("imei", ""));
        C2472w.m10687a().m10692d().m10662a(new C1994dm(new C2456g(EnumC4868cf.CONTACT, "/mo/send").m10637a(EnumC2457h.POST).m10640a("application/json").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("param", C4529e.m17224a(sb.toString())).m10643b(C2477a.class).m10639a(LiveChatDeliveryMessageEntry.class).m10635a(), str, str2, j, str3, enumC2214ab.m10076a()), 901, handler);
        return j;
    }

    /* renamed from: a */
    public static Future<C0778b> m9588a(Handler handler, List<C4526b> list) {
        if (C4904y.f17872b) {
            C4904y.m18639b("livechat, feedback, send ack/read.", C2136q.class.getSimpleName());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("imei=").append(C4809aa.m18104a().m18121a("imei", ""));
        return C2472w.m10687a().m10691c().m10662a(new C1995dn(new C2456g(EnumC4868cf.CONTACT, "/mo/report_read").m10637a(EnumC2457h.POST).m10640a("application/json").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("param", C4529e.m17224a(sb.toString())).m10643b(C2477a.class).m10639a(LiveChatFeedbackResponseEntry.class).m10635a(), list), 904, handler);
    }
}
