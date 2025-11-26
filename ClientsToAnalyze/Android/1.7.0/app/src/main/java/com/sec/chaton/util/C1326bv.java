package com.sec.chaton.util;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.bv */
/* loaded from: classes.dex */
public class C1326bv {

    /* renamed from: a */
    private ArrayList f4549a = new ArrayList();

    /* renamed from: a */
    public void m4593a(String str, InterfaceC1288ak interfaceC1288ak, long j, String str2) {
        m4594a(str, interfaceC1288ak, j, str2, false);
    }

    /* renamed from: a */
    public void m4594a(String str, InterfaceC1288ak interfaceC1288ak, long j, String str2, boolean z) {
        C1329d c1329d;
        Iterator it = this.f4549a.iterator();
        while (true) {
            if (!it.hasNext()) {
                c1329d = null;
                break;
            }
            c1329d = (C1329d) it.next();
            if (c1329d.f4551a.equals(str)) {
                c1329d.f4553c = j;
                C1341p.m4658b("Task " + str + " rescheduled at " + j, "PollingScheduler");
                break;
            }
        }
        if (c1329d == null) {
            C1341p.m4658b("Task " + str + " scheduled at " + j, "PollingScheduler");
            c1329d = new C1329d(str, interfaceC1288ak, j, str2);
            this.f4549a.add(c1329d);
        }
        if (!z) {
            return;
        }
        c1329d.m4604c();
    }

    /* renamed from: a */
    public void m4592a() {
        C1341p.m4658b("Run tasks start", "PollingScheduler");
        Iterator it = this.f4549a.iterator();
        while (it.hasNext()) {
            ((C1329d) it.next()).m4604c();
        }
        C1341p.m4658b("Run tasks end", "PollingScheduler");
    }
}
