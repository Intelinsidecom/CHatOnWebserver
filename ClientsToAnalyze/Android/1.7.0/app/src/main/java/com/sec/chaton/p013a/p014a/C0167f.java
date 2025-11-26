package com.sec.chaton.p013a.p014a;

import com.sec.chaton.p033io.entry.inner.Msg;
import java.util.Comparator;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.a.a.f */
/* loaded from: classes.dex */
class C0167f implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C0181t f396a;

    C0167f(C0181t c0181t) {
        this.f396a = c0181t;
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
