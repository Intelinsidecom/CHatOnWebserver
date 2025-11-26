package com.sec.chaton.control.task;

import com.sec.chaton.common.SSMGPB;
import java.util.Comparator;

/* renamed from: com.sec.chaton.control.task.c */
/* loaded from: classes.dex */
class C0194c implements Comparator {

    /* renamed from: a */
    final /* synthetic */ DeliveryChatTask f1685a;

    C0194c(DeliveryChatTask deliveryChatTask) {
        this.f1685a = deliveryChatTask;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SSMGPB.InboxMessage inboxMessage, SSMGPB.InboxMessage inboxMessage2) {
        if (inboxMessage.m1556l() > inboxMessage2.m1556l()) {
            return 1;
        }
        return inboxMessage.m1556l() < inboxMessage2.m1556l() ? -1 : 0;
    }
}
