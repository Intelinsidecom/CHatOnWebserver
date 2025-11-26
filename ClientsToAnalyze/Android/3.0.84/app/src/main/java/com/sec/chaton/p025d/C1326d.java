package com.sec.chaton.p025d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1271j;
import com.sec.chaton.p025d.p026a.C1273l;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.AmsItemDownloadEntry;
import com.sec.chaton.p035io.entry.AmsItemGetListEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: AmsItemMessageControl.java */
/* renamed from: com.sec.chaton.d.d */
/* loaded from: classes.dex */
public class C1326d {

    /* renamed from: a */
    private Handler f5004a;

    public C1326d(Context context, Handler handler) {
        this.f5004a = handler;
    }

    /* renamed from: a */
    public C1273l m5698a(EnumC1172b enumC1172b, long j, long j2) {
        return m5696a(enumC1172b, EnumC1327e.Background, j, j2);
    }

    /* renamed from: b */
    public C1273l m5699b(EnumC1172b enumC1172b, long j, long j2) {
        return m5696a(enumC1172b, EnumC1327e.Stamp, j, j2);
    }

    /* renamed from: c */
    public C1273l m5700c(EnumC1172b enumC1172b, long j, long j2) {
        return m5696a(enumC1172b, EnumC1327e.Template, j, j2);
    }

    /* renamed from: a */
    private C1273l m5696a(EnumC1172b enumC1172b, EnumC1327e enumC1327e, long j, long j2) {
        C1273l c1273l = new C1273l(this.f5004a, new C1582j(EnumC3219cg.CONTACT, "/ams").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a(PrefFragmentChats.TYPE, String.valueOf(enumC1327e.m5702a())).m6714a("thwidth", String.valueOf(j)).m6714a("thheight", String.valueOf(j2)).m6709a(1200).m6717b(C1537b.class).m6712a(AmsItemGetListEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1273l);
        return c1273l;
    }

    /* renamed from: a */
    public C1271j m5697a(EnumC1172b enumC1172b, EnumC1327e enumC1327e, String str) {
        C1271j c1271j = new C1271j(this.f5004a, new C1582j(EnumC3219cg.CONTACT, "/ams/download").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a(PrefFragmentChats.TYPE, String.valueOf(enumC1327e.m5702a())).m6714a("itemid", str).m6709a(1201).m6717b(C1537b.class).m6712a(AmsItemDownloadEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1271j);
        return c1271j;
    }
}
