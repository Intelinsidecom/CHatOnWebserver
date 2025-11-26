package com.sec.chaton.settings.downloads.p056a;

import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;
import com.sec.common.util.EnumC3345g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: InstallWorkerManager.java */
/* renamed from: com.sec.chaton.settings.downloads.a.p */
/* loaded from: classes.dex */
public final class C2525p {

    /* renamed from: a */
    private static final String f9647a = C2525p.class.getSimpleName();

    /* renamed from: b */
    private static C2525p f9648b;

    /* renamed from: c */
    private HashMap<String, C2521l> f9649c = new HashMap<>();

    /* renamed from: d */
    private List<InterfaceC2526q> f9650d = new ArrayList();

    /* renamed from: a */
    public static synchronized C2525p m9458a() {
        if (f9648b == null) {
            f9648b = new C2525p();
        }
        return f9648b;
    }

    private C2525p() {
    }

    /* renamed from: a */
    public void m9461a(InterfaceC2526q interfaceC2526q) {
        this.f9650d.add(interfaceC2526q);
    }

    /* renamed from: b */
    public void m9465b(InterfaceC2526q interfaceC2526q) {
        this.f9650d.remove(interfaceC2526q);
    }

    /* renamed from: a */
    public void m9460a(C2521l c2521l) {
        if (c2521l != null && c2521l.m9449b() != null) {
            if (c2521l.m11748h() == EnumC3345g.FINISHED) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("InstallAsyncWorker status(", c2521l.m11748h(), ") is invalid."), f9647a);
                    return;
                }
                return;
            }
            String strM11849a = C3364o.m11849a(c2521l.m9449b().m6252a(), c2521l.m9454c());
            C2521l c2521l2 = this.f9649c.get(strM11849a);
            if (c2521l2 == null) {
                this.f9649c.put(strM11849a, c2521l);
            } else if (c2521l2.m9455d() == 5) {
                this.f9649c.remove(strM11849a);
                this.f9649c.put(strM11849a, c2521l);
            } else {
                c2521l = this.f9649c.get(strM11849a);
            }
            Iterator<InterfaceC2526q> it = this.f9650d.iterator();
            while (it.hasNext()) {
                it.next().mo9422a(c2521l);
            }
        }
    }

    /* renamed from: b */
    public void m9464b(C2521l c2521l) {
        this.f9649c.remove(C3364o.m11849a(c2521l.m9449b().m6252a(), c2521l.m9454c()));
        Iterator<InterfaceC2526q> it = this.f9650d.iterator();
        while (it.hasNext()) {
            it.next().mo9430c(c2521l);
        }
    }

    /* renamed from: c */
    public void m9467c(C2521l c2521l) {
        Iterator<InterfaceC2526q> it = this.f9650d.iterator();
        while (it.hasNext()) {
            it.next().mo9428b(c2521l);
        }
    }

    /* renamed from: a */
    public C2521l m9459a(EnumC1399aq enumC1399aq, String str) {
        String str2 = null;
        if (enumC1399aq != null) {
            str2 = enumC1399aq.m6252a() + str;
        }
        return this.f9649c.get(str2);
    }

    /* renamed from: a */
    public boolean m9462a(EnumC1399aq enumC1399aq) {
        for (C2521l c2521l : this.f9649c.values()) {
            if (c2521l.m9449b().equals(enumC1399aq)) {
                switch (c2521l.m9455d()) {
                    case 0:
                    case 1:
                    case 2:
                    case 6:
                        return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m9463b(EnumC1399aq enumC1399aq) {
        ArrayList arrayList = new ArrayList();
        for (C2521l c2521l : this.f9649c.values()) {
            if (enumC1399aq != null && c2521l.m9449b().equals(enumC1399aq)) {
                arrayList.add(C3364o.m11849a(enumC1399aq.m6252a(), c2521l.m9454c()));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2521l c2521lRemove = this.f9649c.remove((String) it.next());
            if (c2521lRemove != null && c2521lRemove.m11748h() != EnumC3345g.FINISHED) {
                c2521lRemove.m11744a(true);
            }
        }
    }

    /* renamed from: c */
    public void m9466c(EnumC1399aq enumC1399aq) {
        ArrayList arrayList = new ArrayList();
        for (C2521l c2521l : this.f9649c.values()) {
            if (enumC1399aq != null && c2521l.m9449b().equals(enumC1399aq) && c2521l.m9455d() == 5) {
                arrayList.add(C3364o.m11849a(enumC1399aq.m6252a(), c2521l.m9454c()));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2521l c2521lRemove = this.f9649c.remove((String) it.next());
            if (c2521lRemove != null) {
                c2521lRemove.m9445a();
            }
        }
    }
}
