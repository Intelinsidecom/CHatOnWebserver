package com.sec.chaton.p037j.p038a;

import com.sec.chaton.p016a.C0318bo;
import com.sec.chaton.p016a.C0319bp;
import com.sec.chaton.p016a.C0321br;
import com.sec.chaton.p016a.EnumC0316bm;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: Disconnect.java */
/* renamed from: com.sec.chaton.j.a.a */
/* loaded from: classes.dex */
public class C1541a {

    /* renamed from: a */
    @Deprecated
    private static C1589q f5660a = null;

    /* renamed from: a */
    public static void m6541a(C1544ac c1544ac, C0321br c0321br, EnumC0316bm enumC0316bm) {
        C0319bp c0319bpNewBuilder = C0318bo.newBuilder();
        c0319bpNewBuilder.m1874a(c0321br.m1899d()).m1876a(enumC0316bm);
        C3250y.m11453c("[DisconnectReply]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", MsgID : " + c0319bpNewBuilder.m1884f() + ", DisconnectActionType : " + c0319bpNewBuilder.m1885g(), C1541a.class.getSimpleName());
        C1596x.m6751a(c1544ac, new C1549ah().m6579a(15).m6581a(c0319bpNewBuilder.build()).m6584b());
    }
}
