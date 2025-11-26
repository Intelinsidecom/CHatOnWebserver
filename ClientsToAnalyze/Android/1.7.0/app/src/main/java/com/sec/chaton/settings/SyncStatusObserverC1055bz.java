package com.sec.chaton.settings;

import android.content.SyncStatusObserver;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.bz */
/* loaded from: classes.dex */
class SyncStatusObserverC1055bz implements SyncStatusObserver {

    /* renamed from: a */
    final /* synthetic */ SyncStatePreference f3666a;

    SyncStatusObserverC1055bz(SyncStatePreference syncStatePreference) {
        this.f3666a = syncStatePreference;
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int i) {
        this.f3666a.f3600c.post(this.f3666a.f3601d);
    }
}
