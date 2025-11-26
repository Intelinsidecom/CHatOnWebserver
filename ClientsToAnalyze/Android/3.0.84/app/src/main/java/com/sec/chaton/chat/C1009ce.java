package com.sec.chaton.chat;

import com.sec.chaton.p035io.entry.inner.Message;
import java.util.Comparator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ce */
/* loaded from: classes.dex */
class C1009ce implements Comparator<Message> {

    /* renamed from: a */
    final /* synthetic */ HandlerC1008cd f4083a;

    C1009ce(HandlerC1008cd handlerC1008cd) {
        this.f4083a = handlerC1008cd;
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
