package com.sec.chaton.chat;

import com.sec.chaton.smsplugin.provider.C3960r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dj */
/* loaded from: classes.dex */
class RunnableC1656dj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6188a;

    RunnableC1656dj(ChatFragment chatFragment) {
        this.f6188a = chatFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6188a.f5732ek.m15247e(this.f6188a.f5534aa, 9703, Long.valueOf(this.f6188a.f5745ex), this.f6188a.f5745ex);
        this.f6188a.f5732ek.m15239a(this.f6188a.f5534aa, C3960r.f14254a, 9704, Long.valueOf(this.f6188a.f5745ex), "thread_id = " + this.f6188a.f5745ex);
    }
}
