package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p055d.p056a.C1940bm;
import com.sec.chaton.p055d.p056a.C2033ey;
import com.sec.chaton.p055d.p056a.C2034ez;
import com.sec.chaton.p055d.p056a.C2059r;
import com.sec.chaton.p055d.p056a.C2060s;
import com.sec.chaton.p065io.entry.GetBlockBuddyList;
import com.sec.chaton.p065io.entry.UnBlock;
import com.sec.chaton.p065io.entry.inner.Address;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.ArrayList;

/* compiled from: BlockControl.java */
/* renamed from: com.sec.chaton.d.g */
/* loaded from: classes.dex */
public class C2126g {

    /* renamed from: a */
    private Handler f7707a;

    /* renamed from: a */
    public static C2126g m9476a(Handler handler) {
        return new C2126g(handler);
    }

    private C2126g(Handler handler) {
        this.f7707a = handler;
    }

    /* renamed from: a */
    public void m9477a() {
        String str = "/v5/blockbuddy";
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals("") && !C4809aa.m18104a().m18121a("chaton_id", "").equals(C4809aa.m18104a().m18121a("msisdn", ""))) {
            C4904y.m18641c("access server /v5/blockbuddy", getClass().getSimpleName());
        } else {
            str = "/blockbuddy";
            C4904y.m18641c("access server /blockbuddy", getClass().getSimpleName());
        }
        C2472w.m10687a().m10691c().m10662a(new C1940bm(new C2456g(EnumC4868cf.CONTACT, str).m10637a(EnumC2457h.GET).m10639a(GetBlockBuddyList.class).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a()), 601, this.f7707a);
    }

    /* renamed from: a */
    public void m9479a(String str, int i) {
        String str2 = "/v5/block";
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals("") && !C4809aa.m18104a().m18121a("chaton_id", "").equals(C4809aa.m18104a().m18121a("msisdn", ""))) {
            C4904y.m18641c("access server /v5/block", getClass().getSimpleName());
        } else {
            str2 = "/block";
            C4904y.m18641c("access server /block", getClass().getSimpleName());
        }
        C2472w.m10687a().m10691c().m10662a(new C2060s(new C2456g(EnumC4868cf.CONTACT, str2 + "/" + str).m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, i), 602, this.f7707a);
    }

    /* renamed from: a */
    public void m9481a(String[] strArr) {
        String str = "/v5/blockbuddy";
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals("") && !C4809aa.m18104a().m18121a("chaton_id", "").equals(C4809aa.m18104a().m18121a("msisdn", ""))) {
            C4904y.m18641c("access server /v5/blockbuddy", getClass().getSimpleName());
        } else {
            str = "/blockbuddy";
            C4904y.m18641c("access server /blockbuddy", getClass().getSimpleName());
        }
        C2472w.m10687a().m10691c().m10662a(new C2059r(new C2456g(EnumC4868cf.CONTACT, str).m10639a(Address.class).m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), strArr), 606, this.f7707a);
    }

    /* renamed from: a */
    public void m9478a(String str) {
        String str2 = "/v5/unblock";
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals("") && !C4809aa.m18104a().m18121a("chaton_id", "").equals(C4809aa.m18104a().m18121a("msisdn", ""))) {
            C4904y.m18641c("access server /v5/unblock", getClass().getSimpleName());
        } else {
            str2 = "/unblock";
            C4904y.m18641c("access server /unblock", getClass().getSimpleName());
        }
        C2472w.m10687a().m10691c().m10662a(new C2034ez(new C2456g(EnumC4868cf.CONTACT, str2 + "/" + str).m10639a(UnBlock.class).m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str), 603, this.f7707a);
    }

    /* renamed from: a */
    public void m9480a(ArrayList<C1093u> arrayList) {
        String str = "/v5/blockbuddy";
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals("") && !C4809aa.m18104a().m18121a("chaton_id", "").equals(C4809aa.m18104a().m18121a("msisdn", ""))) {
            C4904y.m18641c("access server /v5/blockbuddy", getClass().getSimpleName());
        } else {
            str = "/blockbuddy";
            C4904y.m18641c("access server /blockbuddy", getClass().getSimpleName());
        }
        C2472w.m10687a().m10691c().m10662a(new C2033ey(new C2456g(EnumC4868cf.CONTACT, str).m10639a(Address.class).m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), arrayList), 604, this.f7707a);
    }

    /* renamed from: b */
    public void m9482b(String str, int i) {
        C4904y.m18641c("access server /spammer/report", getClass().getSimpleName());
        C2472w.m10687a().m10691c().m10662a(new C2060s(new C2456g(EnumC4868cf.CONTACT, "/spammer/report/" + str).m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, i), 605, this.f7707a);
    }
}
