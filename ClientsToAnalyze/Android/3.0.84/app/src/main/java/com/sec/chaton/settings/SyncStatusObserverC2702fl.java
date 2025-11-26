package com.sec.chaton.settings;

import android.content.SyncStatusObserver;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.fl */
/* loaded from: classes.dex */
class SyncStatusObserverC2702fl implements SyncStatusObserver {

    /* renamed from: a */
    final /* synthetic */ SyncStatePreference f10000a;

    SyncStatusObserverC2702fl(SyncStatePreference syncStatePreference) {
        this.f10000a = syncStatePreference;
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int i) {
        this.f10000a.f9267c.post(this.f10000a.f9268d);
    }
}
