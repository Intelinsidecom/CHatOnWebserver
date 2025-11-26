package com.sec.chaton.util;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.bp */
/* loaded from: classes.dex */
public class C4851bp {

    /* renamed from: a */
    private ArrayList<C4853br> f17670a = new ArrayList<>();

    /* renamed from: a */
    public void m18339a(String str, InterfaceC4854bs interfaceC4854bs, long j, String str2) {
        m18340a(str, interfaceC4854bs, j, str2, false);
    }

    /* renamed from: a */
    public void m18340a(String str, InterfaceC4854bs interfaceC4854bs, long j, String str2, boolean z) {
        C4853br c4853br;
        Iterator<C4853br> it = this.f17670a.iterator();
        while (true) {
            if (!it.hasNext()) {
                c4853br = null;
                break;
            }
            c4853br = it.next();
            if (c4853br.f17671a.equals(str)) {
                c4853br.f17673c = j;
                C4904y.m18639b("Task " + str + " rescheduled at " + j, "PollingScheduler");
                break;
            }
        }
        if (c4853br == null) {
            C4904y.m18639b("Task " + str + " scheduled at " + j, "PollingScheduler");
            c4853br = new C4853br(str, interfaceC4854bs, j, str2);
            this.f17670a.add(c4853br);
        }
        if (!z) {
            return;
        }
        c4853br.m18348c();
    }

    /* renamed from: a */
    public boolean m18341a(String str) {
        C4853br next;
        Iterator<C4853br> it = this.f17670a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.f17671a.equals(str)) {
                break;
            }
        }
        if (next != null) {
            return next.m18350d();
        }
        return false;
    }

    /* renamed from: a */
    public void m18338a() {
        C4904y.m18639b("Run tasks start", "PollingScheduler");
        Iterator<C4853br> it = this.f17670a.iterator();
        while (it.hasNext()) {
            it.next().m18348c();
        }
        C4904y.m18639b("Run tasks end", "PollingScheduler");
    }

    /* renamed from: b */
    public void m18342b(String str) {
        synchronized (this.f17670a) {
            int i = 0;
            while (true) {
                if (i >= this.f17670a.size()) {
                    break;
                }
                if (!this.f17670a.get(i).f17671a.equals(str)) {
                    i++;
                } else {
                    this.f17670a.remove(i);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Task " + str + " removed from mTask ", "PollingScheduler");
                    }
                }
            }
        }
    }
}
