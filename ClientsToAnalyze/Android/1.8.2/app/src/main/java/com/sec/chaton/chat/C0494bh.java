package com.sec.chaton.chat;

import com.sec.chaton.p007a.C0144bj;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: DeliveryReplyHolder.java */
/* renamed from: com.sec.chaton.chat.bh */
/* loaded from: classes.dex */
public class C0494bh {

    /* renamed from: a */
    private static HashMap f2088a = new HashMap();

    /* renamed from: b */
    private String f2089b;

    /* renamed from: c */
    private ArrayList f2090c = new ArrayList();

    private C0494bh(String str) {
        this.f2089b = str;
    }

    /* renamed from: a */
    public static void m2691a(String str) {
        if (f2088a.containsKey(str)) {
            f2088a.remove(str);
        }
    }

    /* renamed from: b */
    public static synchronized C0494bh m2692b(String str) {
        C0494bh c0494bh;
        if (f2088a.containsKey(str)) {
            c0494bh = (C0494bh) f2088a.get(str);
        } else {
            f2088a.put(str, new C0494bh(str));
            c0494bh = (C0494bh) f2088a.get(str);
        }
        return c0494bh;
    }

    /* renamed from: a */
    public void m2693a() {
        this.f2090c.clear();
    }

    /* renamed from: b */
    public boolean m2695b() {
        return this.f2090c.isEmpty();
    }

    /* renamed from: a */
    public void m2694a(C0144bj c0144bj) {
        this.f2090c.add(c0144bj);
        C1786r.m6063c("Insert msg, sender: " + c0144bj.m1112d() + ", msg:" + c0144bj.m1118j(), getClass().getSimpleName());
    }

    /* renamed from: c */
    public ArrayList m2696c() {
        return this.f2090c;
    }
}
