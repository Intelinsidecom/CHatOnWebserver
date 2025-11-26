package com.sec.chaton.p067j.p068a;

import com.sec.chaton.p046a.C0837br;
import com.sec.chaton.p046a.C0838bs;
import com.sec.chaton.p046a.C0840bu;
import com.sec.chaton.p046a.EnumC0835bp;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: Disconnect.java */
/* renamed from: com.sec.chaton.j.a.a */
/* loaded from: classes.dex */
public class C2411a {

    /* renamed from: a */
    @Deprecated
    private static C2466q f8587a = null;

    /* renamed from: a */
    public static void m10445a(C2422ak c2422ak, C0840bu c0840bu, EnumC0835bp enumC0835bp) {
        C0838bs c0838bsNewBuilder = C0837br.newBuilder();
        c0838bsNewBuilder.m3750a(c0840bu.m3775d()).m3752a(enumC0835bp);
        C4904y.m18641c("[DisconnectReply]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", MsgID : " + c0838bsNewBuilder.m3760f() + ", DisconnectActionType : " + c0838bsNewBuilder.m3761g(), C2411a.class.getSimpleName());
        C2417af.m10449a(c2422ak, new C2427ap().m10517a(15).m10519a(c0838bsNewBuilder.build()).m10522b());
    }
}
