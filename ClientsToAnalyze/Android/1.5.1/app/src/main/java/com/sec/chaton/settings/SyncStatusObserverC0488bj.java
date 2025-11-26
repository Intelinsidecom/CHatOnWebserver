package com.sec.chaton.settings;

import android.content.SyncStatusObserver;

/* renamed from: com.sec.chaton.settings.bj */
/* loaded from: classes.dex */
class SyncStatusObserverC0488bj implements SyncStatusObserver {

    /* renamed from: a */
    final /* synthetic */ SyncStatePreference f3179a;

    SyncStatusObserverC0488bj(SyncStatePreference syncStatePreference) {
        this.f3179a = syncStatePreference;
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int i) {
        this.f3179a.f3134c.post(new RunnableC0489bk(this));
    }
}
