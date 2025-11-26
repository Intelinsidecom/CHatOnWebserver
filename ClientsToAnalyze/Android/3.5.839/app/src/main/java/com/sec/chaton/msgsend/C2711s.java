package com.sec.chaton.msgsend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: MsgRequestBlockManager.java */
/* renamed from: com.sec.chaton.msgsend.s */
/* loaded from: classes.dex */
public class C2711s {

    /* renamed from: a */
    Map<EnumC2714v, C2713u> f9717a = new HashMap();

    public C2711s() {
        this.f9717a.put(EnumC2714v.RELEASE_ALLOWCHAT, new C2713u(this, EnumC2714v.RELEASE_ALLOWCHAT));
        this.f9717a.put(EnumC2714v.RELEASE_INITCHAT, new C2713u(this, EnumC2714v.RELEASE_INITCHAT));
        this.f9717a.put(EnumC2714v.RELEASE_SERIALCHAT, new C2713u(this, EnumC2714v.RELEASE_SERIALCHAT));
    }

    /* renamed from: a */
    void m11355a(EnumC2714v enumC2714v, long j) {
        C2713u c2713u = this.f9717a.get(enumC2714v);
        if (c2713u != null) {
            c2713u.m11359a(j);
        }
    }

    /* renamed from: a */
    void m11354a(EnumC2714v enumC2714v) {
        C2713u c2713u = this.f9717a.get(enumC2714v);
        if (c2713u != null) {
            c2713u.m11361c();
        }
    }

    /* renamed from: b */
    long m11356b(EnumC2714v enumC2714v) {
        C2713u c2713u = this.f9717a.get(enumC2714v);
        if (c2713u == null) {
            return -1L;
        }
        return c2713u.m11358a();
    }

    /* renamed from: a */
    List<Long> m11353a() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<EnumC2714v, C2713u>> it = this.f9717a.entrySet().iterator();
        while (it.hasNext()) {
            C2713u value = it.next().getValue();
            if (value.m11358a() > 0) {
                arrayList.add(Long.valueOf(value.m11358a()));
            }
            value.m11361c();
        }
        return arrayList;
    }

    /* renamed from: c */
    C2713u m11357c(EnumC2714v enumC2714v) {
        return this.f9717a.get(enumC2714v);
    }

    /* renamed from: a */
    EnumC2714v m11352a(long j) {
        EnumC2714v enumC2714vM11365a = EnumC2714v.RELEASE_NOTHING;
        long jM11356b = m11356b(EnumC2714v.RELEASE_ALLOWCHAT);
        long jM11356b2 = m11356b(EnumC2714v.RELEASE_INITCHAT);
        long jM11356b3 = m11356b(EnumC2714v.RELEASE_SERIALCHAT);
        if (jM11356b == j) {
            m11354a(EnumC2714v.RELEASE_ALLOWCHAT);
            enumC2714vM11365a = EnumC2714v.m11365a(enumC2714vM11365a, EnumC2714v.RELEASE_ALLOWCHAT);
        }
        if (jM11356b2 == j) {
            m11354a(EnumC2714v.RELEASE_INITCHAT);
            enumC2714vM11365a = EnumC2714v.m11365a(enumC2714vM11365a, EnumC2714v.RELEASE_INITCHAT);
        }
        if (jM11356b3 == j) {
            m11354a(EnumC2714v.RELEASE_SERIALCHAT);
            return EnumC2714v.m11365a(enumC2714vM11365a, EnumC2714v.RELEASE_SERIALCHAT);
        }
        return enumC2714vM11365a;
    }

    public String toString() {
        String str = new String();
        if (this.f9717a == null) {
            return "null";
        }
        Iterator<Map.Entry<EnumC2714v, C2713u>> it = this.f9717a.entrySet().iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + it.next().getValue() + "\n";
            } else {
                return str2;
            }
        }
    }
}
