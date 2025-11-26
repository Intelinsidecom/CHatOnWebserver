package com.sec.chaton.control.task;

import com.sec.chaton.p000io.entry.inner.Msg;
import java.util.Comparator;

/* renamed from: com.sec.chaton.control.task.b */
/* loaded from: classes.dex */
class C0193b implements Comparator {

    /* renamed from: a */
    final /* synthetic */ GetAllUnReadMessageTask f1684a;

    C0193b(GetAllUnReadMessageTask getAllUnReadMessageTask) {
        this.f1684a = getAllUnReadMessageTask;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Msg msg, Msg msg2) {
        if (msg.time.longValue() < msg2.time.longValue()) {
            return -1;
        }
        return msg.time == msg2.time ? 1 : 0;
    }
}
