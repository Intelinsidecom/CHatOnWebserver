package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p035a.p037b.C0866d;
import com.sec.chaton.push.p039c.AbstractC0894f;
import com.sec.chaton.push.p039c.C0881a;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0073ag;
import com.sec.p004a.p005a.p006a.C0076aj;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotiAcksMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.b */
/* loaded from: classes.dex */
public class C0883b extends AbstractC0894f {

    /* renamed from: a */
    private static final String f3025a = C0883b.class.getSimpleName();

    /* renamed from: b */
    private C0866d f3026b;

    /* renamed from: c */
    private List f3027c;

    public C0883b(Context context, List list) {
        super(context, 2L);
        this.f3026b = ((PushClientApplication) PushClientApplication.m3436a()).m3440d();
        this.f3027c = list;
    }

    @Override // com.sec.chaton.push.p039c.AbstractC0894f
    /* renamed from: d */
    public C0881a mo3488d() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3025a, "NotiAcksMessageTask.onRequest().");
        }
        if (!C0888g.m3496a()) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3025a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C0896h.m3520a().m3527a(new C0888g(m3518e()));
                C0896h.m3520a().m3527a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C0921g.f3119d) {
                    return null;
                }
                C0921g.m3638a(f3025a, e.getMessage(), e);
                return null;
            }
        }
        C0073ag c0073agNewBuilder = C0076aj.newBuilder();
        c0073agNewBuilder.m206a(C0904h.m3546b((String) null));
        Iterator it = this.f3027c.iterator();
        while (it.hasNext()) {
            c0073agNewBuilder.m208b((String) it.next());
        }
        return new C0881a().m3478a(this.f3026b).m3477a(c0073agNewBuilder.build());
    }
}
