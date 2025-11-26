package com.sec.chaton.msgsend;

import com.sec.chaton.p057e.EnumC2214ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BulkChatMsg.java */
/* renamed from: com.sec.chaton.msgsend.c */
/* loaded from: classes.dex */
public class C2695c {

    /* renamed from: a */
    private List<C2696d> f9676a = new ArrayList();

    /* renamed from: a */
    public synchronized int m11304a(long j) {
        boolean z;
        Iterator<C2696d> it = this.f9676a.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().m11311c() == j) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.f9676a.remove(i);
        }
        return this.f9676a.size();
    }

    private C2695c() {
    }

    /* renamed from: a */
    public static C2695c m11303a() {
        return new C2695c();
    }

    /* renamed from: a */
    public synchronized C2695c m11305a(long j, EnumC2214ab enumC2214ab, String str) {
        this.f9676a.add(new C2696d(j, enumC2214ab, str));
        return this;
    }

    /* renamed from: a */
    public synchronized C2695c m11306a(ChatONMsgEntity chatONMsgEntity) {
        this.f9676a.add(new C2696d(chatONMsgEntity.m11260e().longValue(), chatONMsgEntity.m11261f(), chatONMsgEntity.m11262g()));
        return this;
    }

    /* renamed from: b */
    public synchronized List<C2696d> m11307b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<C2696d> it = this.f9676a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m11312d());
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized String[] m11308c() {
        String[] strArr;
        strArr = new String[this.f9676a.size()];
        int i = 0;
        Iterator<C2696d> it = this.f9676a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                strArr[i2] = String.valueOf(it.next().m11311c());
                i = i2 + 1;
            }
        }
        return strArr;
    }
}
