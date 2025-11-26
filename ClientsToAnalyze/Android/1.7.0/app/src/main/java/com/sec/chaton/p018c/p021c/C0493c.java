package com.sec.chaton.p018c.p021c;

import com.sec.chaton.p015b.C0266af;
import com.sec.chaton.p015b.C0270aj;
import com.sec.chaton.p015b.C0321cg;
import com.sec.chaton.p015b.EnumC0341o;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0490c;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: Disconnect.java */
/* renamed from: com.sec.chaton.c.c.c */
/* loaded from: classes.dex */
public class C0493c {

    /* renamed from: a */
    @Deprecated
    private static C0490c f1582a = null;

    /* renamed from: a */
    public static void m2496a(C0505l c0505l, C0490c c0490c) {
        c0505l.f1639l = c0490c;
        f1582a = c0490c;
    }

    /* renamed from: a */
    public static void m2495a(C0505l c0505l, C0270aj c0270aj, EnumC0341o enumC0341o) {
        C0321cg c0321cgNewBuilder = C0266af.newBuilder();
        c0321cgNewBuilder.m1724a(c0270aj.m1150d()).m1728a(enumC0341o);
        C1341p.m4660c("ch@t[" + c0321cgNewBuilder.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0321cgNewBuilder.m1734f() + ", DisconnectActionType : " + c0321cgNewBuilder.m1735g(), C0493c.class.getSimpleName());
        C0477ab.m2445a(c0505l, new C0507n().m2556a(15).m2558a(c0321cgNewBuilder.build()).m2561b());
    }
}
