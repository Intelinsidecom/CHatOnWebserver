package com.sec.chaton.settings;

import android.graphics.drawable.AnimationDrawable;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.gj */
/* loaded from: classes.dex */
class RunnableC3657gj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AnimationDrawable f13232a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f13233b;

    RunnableC3657gj(SyncStatePreference syncStatePreference, AnimationDrawable animationDrawable) {
        this.f13233b = syncStatePreference;
        this.f13232a = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13232a.start();
    }
}
