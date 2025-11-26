package com.sec.chaton.p057e.p059b;

import com.sec.chaton.chat.notification.C1830s;
import java.util.Comparator;

/* compiled from: MessageNotificationUpdateTask.java */
/* renamed from: com.sec.chaton.e.b.m */
/* loaded from: classes.dex */
class C2252m implements Comparator<C1830s> {

    /* renamed from: a */
    final /* synthetic */ C2251l f8021a;

    C2252m(C2251l c2251l) {
        this.f8021a = c2251l;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1830s c1830s, C1830s c1830s2) {
        if (c1830s.f6930d.longValue() > c1830s2.f6930d.longValue()) {
            return -1;
        }
        if (c1830s.f6930d.longValue() < c1830s2.f6930d.longValue()) {
            return 1;
        }
        return 0;
    }
}
