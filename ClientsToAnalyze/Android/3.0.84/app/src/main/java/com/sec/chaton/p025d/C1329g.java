package com.sec.chaton.p025d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p025d.p026a.C1287z;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.ChatONVApplicationInfoEntry;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: ChatONVMessageControl.java */
/* renamed from: com.sec.chaton.d.g */
/* loaded from: classes.dex */
public class C1329g {

    /* renamed from: a */
    private final String f5011a = "uxNHas4pyn";

    /* renamed from: b */
    private final String f5012b = "appId";

    /* renamed from: c */
    private final String f5013c = "model";

    /* renamed from: d */
    private final String f5014d = "osVersion";

    /* renamed from: e */
    private final String f5015e = "build";

    /* renamed from: f */
    private final String f5016f = "mcc";

    /* renamed from: g */
    private final String f5017g = "mnc";

    /* renamed from: h */
    private Handler f5018h;

    public C1329g(Handler handler) {
        this.f5018h = handler;
    }

    /* renamed from: a */
    public C1287z m5710a(EnumC1172b enumC1172b) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CHATONV, "/api/application").m6710a(EnumC1583k.GET).m6713a("application/json;charset=utf-8").m6718b("appId", "uxNHas4pyn").m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("osVersion", URLEncoder.encode(Build.VERSION.RELEASE)).m6714a("build", URLEncoder.encode(Build.DISPLAY)).m6717b(ChatONVApplicationInfoEntry.ChatONVApplicatoinInfoParser.class).m6709a(1101).m6712a(ChatONVApplicationInfoEntry.class);
        if (!TextUtils.isEmpty(C3171am.m11068h()) && !TextUtils.isEmpty(C3171am.m11070i())) {
            c1582jM6712a.m6714a("mcc", C3171am.m11068h()).m6714a("mnc", C3171am.m11070i());
        }
        C1287z c1287z = new C1287z(this.f5018h, c1582jM6712a.m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1287z);
        return c1287z;
    }
}
