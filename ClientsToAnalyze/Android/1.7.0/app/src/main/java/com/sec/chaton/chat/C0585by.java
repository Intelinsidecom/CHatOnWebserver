package com.sec.chaton.chat;

import com.sec.chaton.p015b.C0329co;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: DeliveryReplyHolder.java */
/* renamed from: com.sec.chaton.chat.by */
/* loaded from: classes.dex */
public class C0585by {

    /* renamed from: a */
    private static HashMap f2010a = new HashMap();

    /* renamed from: b */
    private String f2011b;

    /* renamed from: c */
    private ArrayList f2012c = new ArrayList();

    private C0585by(String str) {
        this.f2011b = str;
    }

    /* renamed from: a */
    public static void m2769a(String str) {
        if (f2010a.containsKey(str)) {
            f2010a.remove(str);
        }
    }

    /* renamed from: b */
    public static synchronized C0585by m2770b(String str) {
        C0585by c0585by;
        if (f2010a.containsKey(str)) {
            c0585by = (C0585by) f2010a.get(str);
        } else {
            f2010a.put(str, new C0585by(str));
            c0585by = (C0585by) f2010a.get(str);
        }
        return c0585by;
    }

    /* renamed from: a */
    public void m2771a() {
        this.f2012c.clear();
    }

    /* renamed from: b */
    public boolean m2773b() {
        return this.f2012c.isEmpty();
    }

    /* renamed from: a */
    public void m2772a(C0329co c0329co) {
        this.f2012c.add(c0329co);
        C1341p.m4660c("Insert msg, sender: " + c0329co.m1818d() + ", msg:" + c0329co.m1824j(), getClass().getSimpleName());
    }

    /* renamed from: c */
    public ArrayList m2774c() {
        return this.f2012c;
    }
}
