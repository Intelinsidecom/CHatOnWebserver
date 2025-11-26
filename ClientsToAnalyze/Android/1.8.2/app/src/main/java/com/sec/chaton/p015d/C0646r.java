package com.sec.chaton.p015d;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p015d.p016a.C0571bl;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.NotificationEntry;
import com.sec.chaton.p028io.p029a.C0832c;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;

/* compiled from: NotificationControl.java */
/* renamed from: com.sec.chaton.d.r */
/* loaded from: classes.dex */
public class C0646r {

    /* renamed from: a */
    private Context f2511a;

    /* renamed from: b */
    private Handler f2512b;

    public C0646r(Context context, Handler handler) {
        this.f2511a = context;
        this.f2512b = handler;
    }

    /* renamed from: a */
    public C0571bl m2960a() {
        C0802l.m3412a().offer(new C0571bl(this.f2512b, new C0800j(EnumC1765bu.CONTACT, "/notification").m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3407a(NotificationEntry.class).m3410b(C0832c.class).m3404a()));
        return null;
    }
}
