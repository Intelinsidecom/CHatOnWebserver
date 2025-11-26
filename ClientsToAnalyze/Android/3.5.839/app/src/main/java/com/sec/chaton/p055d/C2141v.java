package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p055d.p056a.C1951bx;
import com.sec.chaton.p065io.entry.GetLiveGroupFollowerList;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: LiveGroupControl.java */
/* renamed from: com.sec.chaton.d.v */
/* loaded from: classes.dex */
public class C2141v {

    /* renamed from: a */
    private Handler f7746a;

    /* renamed from: a */
    public static C2141v m9590a(Handler handler) {
        return new C2141v(handler);
    }

    private C2141v(Handler handler) {
        this.f7746a = handler;
    }

    /* renamed from: a */
    public void m9591a(String str) {
        C2472w.m10687a().m10690b().m10662a(new C1951bx(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/followers").m10637a(EnumC2457h.GET).m10643b(C2407b.class).m10639a(GetLiveGroupFollowerList.class).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("specialuserid", str).m10635a()), 2001, this.f7746a);
    }
}
