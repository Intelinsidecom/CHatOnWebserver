package com.sec.chaton.p015d;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.p016a.C0538af;
import com.sec.chaton.p015d.p016a.C0539ag;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.GetSSMServerAddress;
import com.sec.chaton.p028io.entry.GetSSMServerAddress3;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.net.URLEncoder;
import twitter4j.MediaEntity;

/* compiled from: GLDControl.java */
/* renamed from: com.sec.chaton.d.f */
/* loaded from: classes.dex */
public class C0634f {

    /* renamed from: a */
    private Handler f2474a;

    public C0634f(Handler handler) {
        this.f2474a = handler;
    }

    /* renamed from: a */
    public void m2884a() {
        C0802l.m3412a().offer(new C0539ag(this.f2474a, new C0800j(EnumC1765bu.GLD, "/prov").m3405a(MediaEntity.Size.CROP).m3409a("imei", C1721ad.m5873a()).m3409a("msisdn", C1789u.m6075a().getString("msisdn", C1721ad.m5877d())).m3409a("imsi", C1721ad.m5880g()).m3409a("model", URLEncoder.encode(C1721ad.m5876c())).m3409a("clientversion", C0452a.f1723b).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3407a(GetSSMServerAddress.class).m3406a(EnumC0801k.GET).m3404a()));
    }

    /* renamed from: a */
    public void m2885a(String str, String str2) {
        C0802l.m3412a().offer(new C0538af(this.f2474a, new C0800j(EnumC1765bu.GLD, "/prov3").m3405a(103).m3409a("imei", C1721ad.m5873a()).m3409a("countrycallingcode", str).m3409a("phonenumber", str2).m3409a("imsi", C1721ad.m5880g()).m3409a("model", URLEncoder.encode(C1721ad.m5876c())).m3409a("clientversion", C0452a.f1723b).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3409a("screensize", C1721ad.m5890q()).m3407a(GetSSMServerAddress3.class).m3406a(EnumC0801k.GET).m3404a()));
    }
}
