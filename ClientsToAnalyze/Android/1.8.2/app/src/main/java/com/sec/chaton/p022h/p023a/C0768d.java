package com.sec.chaton.p022h.p023a;

import com.sec.chaton.p007a.C0129av;
import com.sec.chaton.p007a.C0130aw;
import com.sec.chaton.p007a.C0132ay;
import com.sec.chaton.p007a.EnumC0127at;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.p022h.C0805o;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: Disconnect.java */
/* renamed from: com.sec.chaton.h.a.d */
/* loaded from: classes.dex */
public class C0768d {

    /* renamed from: a */
    @Deprecated
    private static C0805o f2798a = null;

    /* renamed from: a */
    public static void m3277a(C0816z c0816z, C0805o c0805o) {
        c0816z.f3006l = c0805o;
        f2798a = c0805o;
    }

    /* renamed from: a */
    public static void m3276a(C0816z c0816z, C0132ay c0132ay, EnumC0127at enumC0127at) {
        C0130aw c0130awNewBuilder = C0129av.newBuilder();
        c0130awNewBuilder.m962a(c0132ay.m987d()).m964a(enumC0127at);
        C1786r.m6063c("ch@t[" + c0130awNewBuilder.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0130awNewBuilder.m972f() + ", DisconnectActionType : " + c0130awNewBuilder.m973g(), C0768d.class.getSimpleName());
        C0810t.m3425a(c0816z, new C0771ac().m3294a(15).m3296a(c0130awNewBuilder.build()).m3299b());
    }
}
