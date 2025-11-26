package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p065io.entry.inner.Message;
import java.util.Comparator;

/* compiled from: GetAllMessagesTask.java */
/* renamed from: com.sec.chaton.d.a.bh */
/* loaded from: classes.dex */
class C1935bh implements Comparator<Message> {

    /* renamed from: a */
    final /* synthetic */ C1934bg f7211a;

    C1935bh(C1934bg c1934bg) {
        this.f7211a = c1934bg;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Message message, Message message2) {
        if (message.time.longValue() < message2.time.longValue()) {
            return -1;
        }
        if (message.time == message2.time) {
            return 0;
        }
        return 1;
    }
}
