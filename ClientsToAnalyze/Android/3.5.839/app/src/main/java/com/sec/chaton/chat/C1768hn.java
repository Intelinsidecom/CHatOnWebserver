package com.sec.chaton.chat;

import com.sec.chaton.p065io.entry.inner.Message;
import java.util.Comparator;

/* compiled from: MessageLoader.java */
/* renamed from: com.sec.chaton.chat.hn */
/* loaded from: classes.dex */
class C1768hn implements Comparator<Message> {

    /* renamed from: a */
    final /* synthetic */ HandlerC1767hm f6642a;

    C1768hn(HandlerC1767hm handlerC1767hm) {
        this.f6642a = handlerC1767hm;
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
