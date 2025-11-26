package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p035io.entry.inner.Msg;
import java.util.Comparator;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.bh */
/* loaded from: classes.dex */
class C1180bh implements Comparator<Msg> {

    /* renamed from: a */
    final /* synthetic */ C1179bg f4675a;

    C1180bh(C1179bg c1179bg) {
        this.f4675a = c1179bg;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Msg msg, Msg msg2) {
        if (msg.time.longValue() < msg2.time.longValue()) {
            return -1;
        }
        if (msg.time == msg2.time) {
            return 0;
        }
        return 1;
    }
}
