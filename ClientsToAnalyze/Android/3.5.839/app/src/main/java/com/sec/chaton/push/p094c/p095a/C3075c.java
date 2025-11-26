package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.AbstractC3072a;
import com.sec.chaton.push.p094c.C3087h;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.util.C3115g;
import com.sec.common.CommonApplication;
import com.sec.p043a.p044a.p045a.C0763o;
import com.sec.p043a.p044a.p045a.C0764p;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotiAcksMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.c */
/* loaded from: classes.dex */
public class C3075c extends AbstractC3072a {

    /* renamed from: a */
    private static final String f11364a = C3075c.class.getSimpleName();

    /* renamed from: b */
    private C3060d f11365b;

    /* renamed from: c */
    private List<String> f11366c;

    public C3075c(Context context, List<String> list) {
        super(context, 2L);
        this.f11365b = ((PushClientApplication) CommonApplication.m18732r()).m12502p();
        this.f11366c = list;
    }

    @Override // com.sec.chaton.push.p094c.AbstractC3072a
    /* renamed from: c */
    public C3087h mo12537c() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11364a, "NotiAcksMessageTask.onRequest().");
        }
        if (!C3074b.m12543d()) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11364a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C3088i.m12584a().m12591a(new C3074b(m12535a()));
                C3088i.m12584a().m12591a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C3115g.f11461d) {
                    return null;
                }
                C3115g.m12702a(f11364a, e.getMessage(), e);
                return null;
            }
        }
        C0764p c0764pNewBuilder = C0763o.newBuilder();
        c0764pNewBuilder.m2693a(C3099k.m12635b((String) null));
        Iterator<String> it = this.f11366c.iterator();
        while (it.hasNext()) {
            c0764pNewBuilder.m2695b(it.next());
        }
        return new C3087h().m12582a(this.f11365b).m12581a(c0764pNewBuilder.build());
    }
}
