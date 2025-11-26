package com.sec.chaton.p055d;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p055d.p056a.C2004dw;
import com.sec.chaton.p065io.entry.NotificationEntry;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: NotificationControl.java */
/* renamed from: com.sec.chaton.d.ae */
/* loaded from: classes.dex */
public class C2072ae {

    /* renamed from: a */
    private Context f7557a;

    /* renamed from: b */
    private Handler f7558b;

    public C2072ae(Context context, Handler handler) {
        this.f7557a = context;
        this.f7558b = handler;
    }

    /* renamed from: a */
    public C2004dw m9283a() {
        C2472w.m10687a().m10690b().m10662a(new C2004dw(new C2456g(EnumC4868cf.CONTACT, "/notification").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10639a(NotificationEntry.class).m10643b(C2407b.class).m10635a()), 11101, this.f7558b);
        return null;
    }
}
