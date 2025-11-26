package com.sec.chaton.chat;

import com.sec.chaton.p016a.C0333cc;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: DeliveryReplyHolder.java */
/* renamed from: com.sec.chaton.chat.es */
/* loaded from: classes.dex */
public class C1077es {

    /* renamed from: a */
    private static HashMap<String, C1077es> f4316a = new HashMap<>();

    /* renamed from: b */
    private ArrayList<C0333cc> f4317b = new ArrayList<>();

    /* renamed from: c */
    private ArrayList<C0333cc> f4318c = new ArrayList<>();

    private C1077es(String str) {
    }

    /* renamed from: a */
    public static void m5328a(String str) {
        if (f4316a.containsKey(str)) {
            f4316a.remove(str);
        }
    }

    /* renamed from: b */
    public static synchronized C1077es m5329b(String str) {
        C1077es c1077es;
        if (f4316a.containsKey(str)) {
            c1077es = f4316a.get(str);
        } else {
            f4316a.put(str, new C1077es(str));
            c1077es = f4316a.get(str);
        }
        return c1077es;
    }

    /* renamed from: a */
    public void m5330a() {
        this.f4317b.clear();
    }

    /* renamed from: b */
    public boolean m5333b() {
        return this.f4317b.isEmpty();
    }

    /* renamed from: a */
    public void m5331a(C0333cc c0333cc) {
        this.f4317b.add(c0333cc);
        C3250y.m11453c("Insert msg, sender: " + c0333cc.m2043d() + ", msg:" + c0333cc.m2049j(), getClass().getSimpleName());
    }

    /* renamed from: c */
    public ArrayList<C0333cc> m5334c() {
        return this.f4317b;
    }

    /* renamed from: a */
    public void m5332a(ArrayList<C0333cc> arrayList) {
        arrayList.addAll(this.f4318c);
        this.f4318c = arrayList;
        Iterator<C0333cc> it = arrayList.iterator();
        while (it.hasNext()) {
            for (String str : it.next().m2049j().split("\n")) {
                String[] strArrM5325b = C1075eq.m5325b(str, ",", 3);
                if (strArrM5325b.length > 2) {
                    C3250y.m11453c("Insert noti msg, status: " + strArrM5325b[0] + ", number: " + strArrM5325b[1] + ", name: " + strArrM5325b[2], getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: d */
    public ArrayList<C0333cc> m5335d() {
        return this.f4318c;
    }

    /* renamed from: e */
    public void m5336e() {
        this.f4318c.clear();
    }
}
