package com.sec.chaton.push.message.processer;

import java.util.List;

/* renamed from: com.sec.chaton.push.message.processer.t */
/* loaded from: classes.dex */
class RunnableC0385t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f2722a;

    /* renamed from: b */
    final /* synthetic */ MessageController f2723b;

    RunnableC0385t(MessageController messageController, List list) {
        this.f2723b = messageController;
        this.f2722a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2723b.f2648q.m2944a(this.f2722a);
        } finally {
            this.f2723b.m2913r();
        }
    }
}
