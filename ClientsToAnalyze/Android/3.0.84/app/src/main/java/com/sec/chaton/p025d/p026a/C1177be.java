package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p035io.entry.inner.Message;
import java.util.Comparator;

/* compiled from: GetAllMessagesTask.java */
/* renamed from: com.sec.chaton.d.a.be */
/* loaded from: classes.dex */
class C1177be implements Comparator<Message> {

    /* renamed from: a */
    final /* synthetic */ C1176bd f4657a;

    C1177be(C1176bd c1176bd) {
        this.f4657a = c1176bd;
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
