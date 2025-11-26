package com.sec.chaton.multimedia.skin.p035a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.multimedia.skin.p035a.p036a.C0996a;
import com.sec.chaton.multimedia.skin.p035a.p036a.C0997b;
import com.sec.chaton.multimedia.skin.p039c.C1004a;
import com.sec.chaton.multimedia.skin.p039c.C1005b;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import com.sec.common.p056b.C1816b;
import java.net.URLEncoder;

/* compiled from: SkinMessageControl.java */
/* renamed from: com.sec.chaton.multimedia.skin.a.a */
/* loaded from: classes.dex */
public class C0995a {

    /* renamed from: a */
    private Context f3685a;

    /* renamed from: b */
    private Handler f3686b;

    public C0995a(Context context, Handler handler) {
        this.f3685a = context;
        this.f3686b = handler;
    }

    /* renamed from: a */
    public C0997b m3928a(int i, int i2) {
        C0997b c0997b = new C0997b(this.f3686b, new C0800j(EnumC1765bu.CONTACT, "/skin").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3409a("model", URLEncoder.encode(C1721ad.m5876c())).m3409a("lang", C1721ad.m5879f()).m3409a("pvwidth", String.valueOf(i)).m3409a("pvheight", String.valueOf(i2)).m3409a("bgtype", "ma_pa").m3405a(1100).m3410b(C1005b.class).m3407a(C0997b.class).m3404a());
        C0802l.m3412a().offer(c0997b);
        return c0997b;
    }

    /* renamed from: a */
    public C0996a m3927a(String str, int i, int i2, String str2) {
        int i3 = 0;
        if (str2.equals("pa")) {
            i3 = 1;
        } else if (str2.equals("ma")) {
            i3 = 2;
        }
        C0996a c0996a = new C0996a(this.f3686b, new C0800j(EnumC1765bu.CONTACT, "/skin/download").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("platform", "android").m3409a("skinid", str).m3409a("stwidth", String.valueOf(i)).m3409a("stheight", String.valueOf(i2)).m3409a("rwidth", String.valueOf(C1816b.m6161d())).m3409a("rheight", String.valueOf(C1816b.m6162e())).m3409a("bgtype", String.valueOf(i3)).m3405a(1101).m3410b(C1004a.class).m3407a(C0996a.class).m3404a());
        C0802l.m3412a().offer(c0996a);
        return c0996a;
    }
}
