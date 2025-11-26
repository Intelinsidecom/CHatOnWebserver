package com.sec.chaton.smsplugin.transaction;

import java.util.Comparator;

/* compiled from: MessagingNotification.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.p */
/* loaded from: classes.dex */
final class C4080p implements Comparator<C4079o> {
    private C4080p() {
    }

    /* synthetic */ C4080p(RunnableC4076l runnableC4076l) {
        this();
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C4079o c4079o, C4079o c4079o2) {
        return Long.signum(c4079o2.m15688a() - c4079o.m15688a());
    }
}
