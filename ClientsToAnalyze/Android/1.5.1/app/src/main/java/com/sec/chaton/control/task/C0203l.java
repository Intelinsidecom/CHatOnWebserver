package com.sec.chaton.control.task;

import com.sec.chaton.p000io.entry.inner.Msg;
import java.util.Comparator;

/* renamed from: com.sec.chaton.control.task.l */
/* loaded from: classes.dex */
class C0203l implements Comparator {

    /* renamed from: a */
    final /* synthetic */ BroadcastGetAllUnReadMessage f1696a;

    C0203l(BroadcastGetAllUnReadMessage broadcastGetAllUnReadMessage) {
        this.f1696a = broadcastGetAllUnReadMessage;
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
