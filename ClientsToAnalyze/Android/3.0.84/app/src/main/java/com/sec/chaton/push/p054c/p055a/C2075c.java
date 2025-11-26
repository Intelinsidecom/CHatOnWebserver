package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.AbstractC2072a;
import com.sec.chaton.push.p054c.C2087h;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.CommonApplication;
import com.sec.p013a.p014a.p015a.C0250o;
import com.sec.p013a.p014a.p015a.C0251p;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotiAcksMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.c */
/* loaded from: classes.dex */
public class C2075c extends AbstractC2072a {

    /* renamed from: a */
    private static final String f7954a = C2075c.class.getSimpleName();

    /* renamed from: b */
    private C2060d f7955b;

    /* renamed from: c */
    private List<String> f7956c;

    public C2075c(Context context, List<String> list) {
        super(context, 2L);
        this.f7955b = ((PushClientApplication) CommonApplication.m11493l()).m8159j();
        this.f7956c = list;
    }

    @Override // com.sec.chaton.push.p054c.AbstractC2072a
    /* renamed from: c */
    public C2087h mo8194c() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7954a, "NotiAcksMessageTask.onRequest().");
        }
        if (!C2074b.m8200d()) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7954a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C2088i.m8241a().m8248a(new C2074b(m8192a()));
                C2088i.m8241a().m8248a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C2115g.f8051d) {
                    return null;
                }
                C2115g.m8360a(f7954a, e.getMessage(), e);
                return null;
            }
        }
        C0251p c0251pNewBuilder = C0250o.newBuilder();
        c0251pNewBuilder.m961a(C2099k.m8292b((String) null));
        Iterator<String> it = this.f7956c.iterator();
        while (it.hasNext()) {
            c0251pNewBuilder.m963b(it.next());
        }
        return new C2087h().m8239a(this.f7955b).m8238a(c0251pNewBuilder.build());
    }
}
