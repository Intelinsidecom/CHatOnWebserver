package com.sec.chaton.control;

import com.sec.chaton.chat.ChatListAdapter;

/* renamed from: com.sec.chaton.control.x */
/* loaded from: classes.dex */
class RunnableC0209x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1703a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC0187p f1704b;

    RunnableC0209x(AsyncTaskC0187p asyncTaskC0187p, String str) {
        this.f1704b = asyncTaskC0187p;
        this.f1703a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatListAdapter.m777a(this.f1704b.f1438c.f1372j, this.f1704b.f1436a, this.f1703a, this.f1704b.f1437b);
    }
}
