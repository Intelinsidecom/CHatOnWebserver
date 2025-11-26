package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p065io.entry.inner.Msg;
import java.util.Comparator;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.bk */
/* loaded from: classes.dex */
class C1938bk implements Comparator<Msg> {

    /* renamed from: a */
    final /* synthetic */ C1937bj f7228a;

    C1938bk(C1937bj c1937bj) {
        this.f7228a = c1937bj;
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
