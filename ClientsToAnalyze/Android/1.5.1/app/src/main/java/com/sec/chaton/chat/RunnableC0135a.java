package com.sec.chaton.chat;

import android.widget.TextView;

/* renamed from: com.sec.chaton.chat.a */
/* loaded from: classes.dex */
class RunnableC0135a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0164z f932a;

    RunnableC0135a(C0164z c0164z) {
        this.f932a = c0164z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f932a.f987b.f803au.setText(this.f932a.f987b.f790ah, TextView.BufferType.NORMAL);
    }
}
