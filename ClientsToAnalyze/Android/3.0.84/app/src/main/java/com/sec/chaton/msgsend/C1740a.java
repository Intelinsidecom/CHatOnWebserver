package com.sec.chaton.msgsend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BulkChatMsg.java */
/* renamed from: com.sec.chaton.msgsend.a */
/* loaded from: classes.dex */
public class C1740a {

    /* renamed from: a */
    private List<C1742b> f6418a = new ArrayList();

    /* renamed from: a */
    public synchronized int m7152a(long j) {
        boolean z;
        Iterator<C1742b> it = this.f6418a.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().m7160c() == j) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.f6418a.remove(i);
        }
        return this.f6418a.size();
    }

    private C1740a() {
    }

    /* renamed from: a */
    public static C1740a m7151a() {
        return new C1740a();
    }

    /* renamed from: a */
    public synchronized C1740a m7153a(ChatONMsgEntity chatONMsgEntity) {
        this.f6418a.add(new C1742b(chatONMsgEntity.m7143e().longValue(), chatONMsgEntity.m7144f(), chatONMsgEntity.m7145g()));
        return this;
    }

    /* renamed from: b */
    public synchronized List<C1742b> m7154b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<C1742b> it = this.f6418a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m7161d());
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized String[] m7155c() {
        String[] strArr;
        strArr = new String[this.f6418a.size()];
        int i = 0;
        Iterator<C1742b> it = this.f6418a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                strArr[i2] = String.valueOf(it.next().m7160c());
                i = i2 + 1;
            }
        }
        return strArr;
    }
}
