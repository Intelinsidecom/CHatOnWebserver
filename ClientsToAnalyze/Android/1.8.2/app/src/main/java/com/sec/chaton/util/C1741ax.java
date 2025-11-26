package com.sec.chaton.util;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.ax */
/* loaded from: classes.dex */
public class C1741ax {

    /* renamed from: a */
    private ArrayList f6353a = new ArrayList();

    /* renamed from: a */
    public void m5931a(String str, InterfaceC1745ba interfaceC1745ba, long j, String str2) {
        m5932a(str, interfaceC1745ba, j, str2, false);
    }

    /* renamed from: a */
    public void m5932a(String str, InterfaceC1745ba interfaceC1745ba, long j, String str2, boolean z) {
        C1743az c1743az;
        Iterator it = this.f6353a.iterator();
        while (true) {
            if (!it.hasNext()) {
                c1743az = null;
                break;
            }
            c1743az = (C1743az) it.next();
            if (c1743az.f6354a.equals(str)) {
                c1743az.f6356c = j;
                C1786r.m6061b("Task " + str + " rescheduled at " + j, "PollingScheduler");
                break;
            }
        }
        if (c1743az == null) {
            C1786r.m6061b("Task " + str + " scheduled at " + j, "PollingScheduler");
            c1743az = new C1743az(str, interfaceC1745ba, j, str2);
            this.f6353a.add(c1743az);
        }
        if (!z) {
            return;
        }
        c1743az.m5938c();
    }

    /* renamed from: a */
    public void m5929a() {
        C1786r.m6061b("Run tasks start", "PollingScheduler");
        Iterator it = this.f6353a.iterator();
        while (it.hasNext()) {
            ((C1743az) it.next()).m5938c();
        }
        C1786r.m6061b("Run tasks end", "PollingScheduler");
    }

    /* renamed from: a */
    public void m5930a(String str) {
        synchronized (this.f6353a) {
            int i = 0;
            while (true) {
                if (i >= this.f6353a.size()) {
                    break;
                }
                if (!((C1743az) this.f6353a.get(i)).f6354a.equals(str)) {
                    i++;
                } else {
                    this.f6353a.remove(i);
                    if (C1786r.f6452b) {
                        C1786r.m6061b("Task " + str + " removed from mTask ", "PollingScheduler");
                    }
                }
            }
        }
    }
}
