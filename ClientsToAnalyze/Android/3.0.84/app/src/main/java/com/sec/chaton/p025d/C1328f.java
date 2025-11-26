package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.block.C0475ac;
import com.sec.chaton.p025d.p026a.C1183bk;
import com.sec.chaton.p025d.p026a.C1254ea;
import com.sec.chaton.p025d.p026a.C1255eb;
import com.sec.chaton.p025d.p026a.C1284w;
import com.sec.chaton.p025d.p026a.C1285x;
import com.sec.chaton.p035io.entry.GetBlockBuddyList;
import com.sec.chaton.p035io.entry.UnBlock;
import com.sec.chaton.p035io.entry.inner.Address;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import java.util.ArrayList;

/* compiled from: BlockControl.java */
/* renamed from: com.sec.chaton.d.f */
/* loaded from: classes.dex */
public class C1328f {

    /* renamed from: a */
    private Handler f5010a;

    public C1328f(Handler handler) {
        this.f5010a = handler;
    }

    /* renamed from: a */
    public void m5704a() {
        String str = "/v5/blockbuddy";
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals("") && !C3159aa.m10962a().m10979a("chaton_id", "").equals(C3159aa.m10962a().m10979a("msisdn", ""))) {
            C3250y.m11453c("access server /v5/blockbuddy", getClass().getSimpleName());
        } else {
            str = "/blockbuddy";
            C3250y.m11453c("access server /blockbuddy", getClass().getSimpleName());
        }
        C1595w.m6742a().m6745b().m6723a(new C1183bk(this.f5010a, new C1582j(EnumC3219cg.CONTACT, str).m6710a(EnumC1583k.GET).m6712a(GetBlockBuddyList.class).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(601).m6708a()));
    }

    /* renamed from: a */
    public void m5706a(String str, int i) {
        String str2 = "/v5/block";
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals("") && !C3159aa.m10962a().m10979a("chaton_id", "").equals(C3159aa.m10962a().m10979a("msisdn", ""))) {
            C3250y.m11453c("access server /v5/block", getClass().getSimpleName());
        } else {
            str2 = "/block";
            C3250y.m11453c("access server /block", getClass().getSimpleName());
        }
        C1595w.m6742a().m6745b().m6723a(new C1285x(this.f5010a, new C1582j(EnumC3219cg.CONTACT, str2 + "/" + str).m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(602).m6708a(), str, i));
    }

    /* renamed from: a */
    public void m5708a(String[] strArr) {
        String str = "/v5/blockbuddy";
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals("") && !C3159aa.m10962a().m10979a("chaton_id", "").equals(C3159aa.m10962a().m10979a("msisdn", ""))) {
            C3250y.m11453c("access server /v5/blockbuddy", getClass().getSimpleName());
        } else {
            str = "/blockbuddy";
            C3250y.m11453c("access server /blockbuddy", getClass().getSimpleName());
        }
        C1595w.m6742a().m6745b().m6723a(new C1284w(this.f5010a, new C1582j(EnumC3219cg.CONTACT, str).m6712a(Address.class).m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(606).m6708a(), strArr));
    }

    /* renamed from: a */
    public void m5705a(String str) {
        String str2 = "/v5/unblock";
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals("") && !C3159aa.m10962a().m10979a("chaton_id", "").equals(C3159aa.m10962a().m10979a("msisdn", ""))) {
            C3250y.m11453c("access server /v5/unblock", getClass().getSimpleName());
        } else {
            str2 = "/unblock";
            C3250y.m11453c("access server /unblock", getClass().getSimpleName());
        }
        C1595w.m6742a().m6745b().m6723a(new C1255eb(this.f5010a, new C1582j(EnumC3219cg.CONTACT, str2 + "/" + str).m6712a(UnBlock.class).m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(603).m6708a(), str));
    }

    /* renamed from: a */
    public void m5707a(ArrayList<C0475ac> arrayList) {
        String str = "/v5/blockbuddy";
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals("") && !C3159aa.m10962a().m10979a("chaton_id", "").equals(C3159aa.m10962a().m10979a("msisdn", ""))) {
            C3250y.m11453c("access server /v5/blockbuddy", getClass().getSimpleName());
        } else {
            str = "/blockbuddy";
            C3250y.m11453c("access server /blockbuddy", getClass().getSimpleName());
        }
        C1595w.m6742a().m6745b().m6723a(new C1254ea(this.f5010a, new C1582j(EnumC3219cg.CONTACT, str).m6712a(Address.class).m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(604).m6708a(), arrayList));
    }

    /* renamed from: b */
    public void m5709b(String str, int i) {
        C3250y.m11453c("access server /spammer/report", getClass().getSimpleName());
        C1595w.m6742a().m6745b().m6723a(new C1285x(this.f5010a, new C1582j(EnumC3219cg.CONTACT, "/spammer/report/" + str).m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(605).m6708a(), str, i));
    }
}
