package com.sec.chaton.settings;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.dw */
/* loaded from: classes.dex */
class RunnableC1325dw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SyncStatusObserverC1324dv f4901a;

    RunnableC1325dw(SyncStatusObserverC1324dv syncStatusObserverC1324dv) {
        this.f4901a = syncStatusObserverC1324dv;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4901a.f4900a.m4735d();
    }
}
