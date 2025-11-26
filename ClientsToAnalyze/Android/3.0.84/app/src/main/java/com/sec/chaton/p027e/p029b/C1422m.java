package com.sec.chaton.p027e.p029b;

import com.sec.chaton.chat.notification.C1111g;
import java.util.Comparator;

/* compiled from: MessageNotificationUpdateTask.java */
/* renamed from: com.sec.chaton.e.b.m */
/* loaded from: classes.dex */
class C1422m implements Comparator<C1111g> {

    /* renamed from: a */
    final /* synthetic */ C1421l f5274a;

    C1422m(C1421l c1421l) {
        this.f5274a = c1421l;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1111g c1111g, C1111g c1111g2) {
        if (c1111g.f4501d.longValue() > c1111g2.f4501d.longValue()) {
            return -1;
        }
        if (c1111g.f4501d.longValue() < c1111g2.f4501d.longValue()) {
            return 1;
        }
        return 0;
    }
}
