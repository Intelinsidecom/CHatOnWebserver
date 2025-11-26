package com.sec.chaton.settings.tellfriends;

import android.os.Bundle;
import com.renren.android.C0212f;
import com.renren.android.p012c.C0203a;
import com.renren.android.p012c.C0208f;
import com.renren.android.p012c.C0209g;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.q */
/* loaded from: classes.dex */
class C2823q extends C2825s {

    /* renamed from: a */
    final /* synthetic */ C2819m f10352a;

    /* renamed from: b */
    private String f10353b;

    /* synthetic */ C2823q(C2819m c2819m, C2820n c2820n) {
        this(c2819m);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2823q(C2819m c2819m) {
        super(c2819m, "GetMyInfoTask");
        this.f10352a = c2819m;
        this.f10353b = "uid,name,tinyurl,mainurl,headurl";
    }

    @Override // com.sec.chaton.settings.tellfriends.C2825s, com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        C0209g c0209g;
        C0208f c0208f = new C0208f(new String[]{String.valueOf(C2819m.f10344d.m530e())});
        c0208f.m555a(this.f10353b);
        Bundle bundleM554a = null;
        try {
            bundleM554a = c0208f.m554a();
        } catch (C0212f e) {
            e.printStackTrace();
        }
        int iA = m10056a(bundleM554a);
        if (iA == -1 && (c0209g = new C0209g(m10057b())) != null && c0209g.m556a().size() > 0) {
            C0203a c0203a = c0209g.m556a().get(0);
            long jM542a = c0203a.m542a();
            String strM544b = c0203a.m544b();
            String strM545c = c0203a.m545c();
            C2827u.m10061b(this.f10352a.f10345e, String.valueOf(jM542a));
            C2827u.m10059a(this.f10352a.f10345e, strM544b);
            C2827u.m10063c(this.f10352a.f10345e, strM545c);
        }
        return iA;
    }
}
