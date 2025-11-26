package com.sec.chaton.settings;

import android.content.SyncStatusObserver;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.dv */
/* loaded from: classes.dex */
class SyncStatusObserverC1324dv implements SyncStatusObserver {

    /* renamed from: a */
    final /* synthetic */ SyncStatePreference f4900a;

    SyncStatusObserverC1324dv(SyncStatePreference syncStatePreference) {
        this.f4900a = syncStatePreference;
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int i) {
        this.f4900a.f4758c.post(new RunnableC1325dw(this));
    }
}
