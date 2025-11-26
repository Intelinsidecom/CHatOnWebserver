package com.sec.chaton.chat;

import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bc */
/* loaded from: classes.dex */
class RunnableC0980bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0979bb f4044a;

    RunnableC0980bc(C0979bb c0979bb) {
        this.f4044a = c0979bb;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f4044a.f4043a.f3592bO > this.f4044a.f4043a.f3550aZ + 4 ? (this.f4044a.f4043a.f3592bO - this.f4044a.f4043a.f3550aZ) - 4 : this.f4044a.f4043a.f3592bO;
        this.f4044a.f4043a.f3526aB.setSelectionFromTop(i, 0);
        this.f4044a.f4043a.f3503E = false;
        this.f4044a.f4043a.f3526aB.setTranscriptMode(0);
        this.f4044a.f4043a.f3604ba = true;
        this.f4044a.f4043a.f3605bb = false;
        C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE_FOR_MARK (total:" + this.f4044a.f4043a.f3526aB.getCount() + ",position:" + i + ")", getClass().getSimpleName());
    }
}
