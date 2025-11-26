package com.sec.chaton.chat;

import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: DeliveryReplyHolder.java */
/* renamed from: com.sec.chaton.chat.go */
/* loaded from: classes.dex */
public class C1742go {

    /* renamed from: a */
    private static HashMap<String, C1742go> f6547a = new HashMap<>();

    /* renamed from: b */
    private ArrayList<C0864cr> f6548b = new ArrayList<>();

    /* renamed from: c */
    private ArrayList<C0864cr> f6549c = new ArrayList<>();

    private C1742go(String str) {
    }

    /* renamed from: a */
    public static synchronized void m8666a(String str) {
        if (f6547a.containsKey(str)) {
            f6547a.remove(str);
        }
    }

    /* renamed from: b */
    public static synchronized C1742go m8667b(String str) {
        if (!f6547a.containsKey(str)) {
            f6547a.put(str, new C1742go(str));
        }
        return f6547a.get(str);
    }

    /* renamed from: a */
    public void m8668a() {
        this.f6548b.clear();
    }

    /* renamed from: b */
    public boolean m8671b() {
        return this.f6548b.isEmpty();
    }

    /* renamed from: a */
    public void m8669a(C0864cr c0864cr) {
        this.f6548b.add(c0864cr);
    }

    /* renamed from: c */
    public ArrayList<C0864cr> m8672c() {
        return this.f6548b;
    }

    /* renamed from: a */
    public void m8670a(ArrayList<C0864cr> arrayList) {
        arrayList.addAll(this.f6549c);
        this.f6549c = arrayList;
        Iterator<C0864cr> it = arrayList.iterator();
        while (it.hasNext()) {
            for (String str : it.next().m4156j().split("\n")) {
                String[] strArrM8650b = C1736gi.m8650b(str, ",", 3);
                if (strArrM8650b.length > 2) {
                    C4904y.m18641c("Insert noti msg, status: " + strArrM8650b[0] + ", number: " + strArrM8650b[1] + ", name: " + strArrM8650b[2], getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: d */
    public ArrayList<C0864cr> m8673d() {
        return this.f6549c;
    }

    /* renamed from: e */
    public void m8674e() {
        this.f6549c.clear();
    }
}
