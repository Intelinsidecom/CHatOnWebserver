package com.sec.chaton.settings;

import android.content.SyncStatusObserver;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.gl */
/* loaded from: classes.dex */
class SyncStatusObserverC3659gl implements SyncStatusObserver {

    /* renamed from: a */
    final /* synthetic */ SyncStatePreference f13235a;

    SyncStatusObserverC3659gl(SyncStatePreference syncStatePreference) {
        this.f13235a = syncStatePreference;
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int i) {
        this.f13235a.f12840c.post(this.f13235a.f12841d);
    }
}
