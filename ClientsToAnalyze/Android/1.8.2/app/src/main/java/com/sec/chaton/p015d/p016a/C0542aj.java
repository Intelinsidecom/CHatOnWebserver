package com.sec.chaton.p015d.p016a;

import com.sec.chaton.p028io.entry.inner.Msg;
import java.util.Comparator;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.aj */
/* loaded from: classes.dex */
class C0542aj implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C0541ai f2211a;

    C0542aj(C0541ai c0541ai) {
        this.f2211a = c0541ai;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Msg msg, Msg msg2) {
        if (msg.time.longValue() < msg2.time.longValue()) {
            return -1;
        }
        if (msg.time == msg2.time) {
            return 1;
        }
        return 0;
    }
}
