package com.sec.chaton.settings.p096a.p097a;

import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import com.sec.common.util.EnumC5030g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: InstallWorkerManager.java */
/* renamed from: com.sec.chaton.settings.a.a.l */
/* loaded from: classes.dex */
public final class C3445l {

    /* renamed from: a */
    private static final String f12879a = C3445l.class.getSimpleName();

    /* renamed from: b */
    private static C3445l f12880b;

    /* renamed from: c */
    private HashMap<String, C3441h> f12881c = new HashMap<>();

    /* renamed from: d */
    private List<InterfaceC3446m> f12882d = new ArrayList();

    /* renamed from: a */
    public static synchronized C3445l m13723a() {
        if (f12880b == null) {
            f12880b = new C3445l();
        }
        return f12880b;
    }

    private C3445l() {
    }

    /* renamed from: a */
    public void m13725a(C3441h c3441h) {
        if (c3441h != null && c3441h.m13718c() != null) {
            if (c3441h.m19062g() == EnumC5030g.FINISHED) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("InstallAsyncWorker status(", c3441h.m19062g(), ") is invalid."), f12879a);
                    return;
                }
                return;
            }
            String strM19199a = C5052r.m19199a(c3441h.m13718c().m10123a(), c3441h.m13720d());
            C3441h c3441h2 = this.f12881c.get(strM19199a);
            if (c3441h2 == null) {
                this.f12881c.put(strM19199a, c3441h);
            } else if (c3441h2.m13721e() == 5) {
                this.f12881c.remove(strM19199a);
                this.f12881c.put(strM19199a, c3441h);
            } else {
                c3441h = this.f12881c.get(strM19199a);
            }
            Iterator<InterfaceC3446m> it = this.f12882d.iterator();
            while (it.hasNext()) {
                it.next().m13728a(c3441h);
            }
        }
    }

    /* renamed from: b */
    public void m13726b(C3441h c3441h) {
        this.f12881c.remove(C5052r.m19199a(c3441h.m13718c().m10123a(), c3441h.m13720d()));
        Iterator<InterfaceC3446m> it = this.f12882d.iterator();
        while (it.hasNext()) {
            it.next().m13730c(c3441h);
        }
    }

    /* renamed from: c */
    public void m13727c(C3441h c3441h) {
        Iterator<InterfaceC3446m> it = this.f12882d.iterator();
        while (it.hasNext()) {
            it.next().m13729b(c3441h);
        }
    }

    /* renamed from: a */
    public C3441h m13724a(EnumC2258bd enumC2258bd, String str) {
        String str2 = null;
        if (enumC2258bd != null) {
            str2 = enumC2258bd.m10123a() + str;
        }
        return this.f12881c.get(str2);
    }
}
