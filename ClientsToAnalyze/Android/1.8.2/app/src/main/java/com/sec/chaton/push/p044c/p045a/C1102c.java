package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p041b.p042a.C1087d;
import com.sec.chaton.push.p044c.AbstractC1099a;
import com.sec.chaton.push.p044c.C1114h;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0086o;
import com.sec.p004a.p005a.p006a.C0087p;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotiAcksMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.c */
/* loaded from: classes.dex */
public class C1102c extends AbstractC1099a {

    /* renamed from: a */
    private static final String f4052a = C1102c.class.getSimpleName();

    /* renamed from: b */
    private C1087d f4053b;

    /* renamed from: c */
    private List f4054c;

    public C1102c(Context context, List list) {
        super(context, 2L);
        this.f4053b = ((PushClientApplication) PushClientApplication.m4111g()).m4115j();
        this.f4054c = list;
    }

    @Override // com.sec.chaton.push.p044c.AbstractC1099a
    /* renamed from: c */
    public C1114h mo4150c() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4052a, "NotiAcksMessageTask.onRequest().");
        }
        if (!C1101b.m4155d()) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4052a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C1115i.m4196a().m4203a(new C1101b(m4148a()));
                C1115i.m4196a().m4203a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C1139g.f4145d) {
                    return null;
                }
                C1139g.m4309a(f4052a, e.getMessage(), e);
                return null;
            }
        }
        C0087p c0087pNewBuilder = C0086o.newBuilder();
        c0087pNewBuilder.m449a(C1126j.m4248b((String) null));
        Iterator it = this.f4054c.iterator();
        while (it.hasNext()) {
            c0087pNewBuilder.m451b((String) it.next());
        }
        return new C1114h().m4194a(this.f4053b).m4193a(c0087pNewBuilder.build());
    }
}
