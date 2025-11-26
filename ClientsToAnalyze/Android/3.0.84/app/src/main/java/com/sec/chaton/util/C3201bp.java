package com.sec.chaton.util;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.bp */
/* loaded from: classes.dex */
public class C3201bp {

    /* renamed from: a */
    private ArrayList<C3203br> f11555a = new ArrayList<>();

    /* renamed from: a */
    public void m11164a(String str, InterfaceC3204bs interfaceC3204bs, long j, String str2) {
        m11165a(str, interfaceC3204bs, j, str2, false);
    }

    /* renamed from: a */
    public void m11165a(String str, InterfaceC3204bs interfaceC3204bs, long j, String str2, boolean z) {
        C3203br c3203br;
        Iterator<C3203br> it = this.f11555a.iterator();
        while (true) {
            if (!it.hasNext()) {
                c3203br = null;
                break;
            }
            c3203br = it.next();
            if (c3203br.f11556a.equals(str)) {
                c3203br.f11558c = j;
                C3250y.m11450b("Task " + str + " rescheduled at " + j, "PollingScheduler");
                break;
            }
        }
        if (c3203br == null) {
            C3250y.m11450b("Task " + str + " scheduled at " + j, "PollingScheduler");
            c3203br = new C3203br(str, interfaceC3204bs, j, str2);
            this.f11555a.add(c3203br);
        }
        if (!z) {
            return;
        }
        c3203br.m11173c();
    }

    /* renamed from: a */
    public boolean m11166a(String str) {
        C3203br next;
        Iterator<C3203br> it = this.f11555a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.f11556a.equals(str)) {
                break;
            }
        }
        if (next != null) {
            return next.m11175d();
        }
        return false;
    }

    /* renamed from: a */
    public void m11163a() {
        C3250y.m11450b("Run tasks start", "PollingScheduler");
        Iterator<C3203br> it = this.f11555a.iterator();
        while (it.hasNext()) {
            it.next().m11173c();
        }
        C3250y.m11450b("Run tasks end", "PollingScheduler");
    }

    /* renamed from: b */
    public void m11167b(String str) {
        synchronized (this.f11555a) {
            int i = 0;
            while (true) {
                if (i >= this.f11555a.size()) {
                    break;
                }
                if (!this.f11555a.get(i).f11556a.equals(str)) {
                    i++;
                } else {
                    this.f11555a.remove(i);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Task " + str + " removed from mTask ", "PollingScheduler");
                    }
                }
            }
        }
    }
}
