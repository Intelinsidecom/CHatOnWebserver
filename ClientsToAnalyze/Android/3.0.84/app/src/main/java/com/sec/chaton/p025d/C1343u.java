package com.sec.chaton.p025d;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1233dg;
import com.sec.chaton.p035io.entry.NotificationEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;

/* compiled from: NotificationControl.java */
/* renamed from: com.sec.chaton.d.u */
/* loaded from: classes.dex */
public class C1343u {

    /* renamed from: a */
    private Context f5068a;

    /* renamed from: b */
    private Handler f5069b;

    public C1343u(Context context, Handler handler) {
        this.f5068a = context;
        this.f5069b = handler;
    }

    /* renamed from: a */
    public C1233dg m5910a() {
        C1595w.m6742a().m6745b().m6723a(new C1233dg(this.f5069b, new C1582j(EnumC3219cg.CONTACT, "/notification").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6712a(NotificationEntry.class).m6717b(C1537b.class).m6708a()));
        return null;
    }
}
