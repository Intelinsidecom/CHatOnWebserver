package com.sec.chaton.p055d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p055d.p056a.C2063v;
import com.sec.chaton.p065io.entry.ChatONVApplicationInfoEntry;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.net.URLEncoder;
import java.util.concurrent.Future;

/* compiled from: ChatONVMessageControl.java */
/* renamed from: com.sec.chaton.d.h */
/* loaded from: classes.dex */
public class C2127h {

    /* renamed from: a */
    private final String f7708a = "uxNHas4pyn";

    /* renamed from: b */
    private final String f7709b = "appId";

    /* renamed from: c */
    private final String f7710c = "model";

    /* renamed from: d */
    private final String f7711d = "osVersion";

    /* renamed from: e */
    private final String f7712e = "build";

    /* renamed from: f */
    private final String f7713f = "mcc";

    /* renamed from: g */
    private final String f7714g = "mnc";

    /* renamed from: h */
    private Handler f7715h;

    public C2127h(Handler handler) {
        this.f7715h = handler;
    }

    /* renamed from: a */
    public Future<C0784h> m9483a(EnumC2463n enumC2463n) {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CHATONV, "/api/application").m10637a(EnumC2457h.GET).m10640a("application/json;charset=utf-8").m10644b("appId", "uxNHas4pyn").m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("osVersion", URLEncoder.encode(Build.VERSION.RELEASE)).m10641a("build", URLEncoder.encode(Build.DISPLAY)).m10643b(ChatONVApplicationInfoEntry.ChatONVApplicatoinInfoParser.class).m10639a(ChatONVApplicationInfoEntry.class);
        if (!TextUtils.isEmpty(C4822an.m18243k()) && !TextUtils.isEmpty(C4822an.m18244l())) {
            c2456gM10639a.m10641a("mcc", C4822an.m18243k()).m10641a("mnc", C4822an.m18244l());
        }
        return C2472w.m10687a().m10691c().m10664a(new C2063v(c2456gM10639a.m10635a()), enumC2463n, 1101, this.f7715h);
    }
}
