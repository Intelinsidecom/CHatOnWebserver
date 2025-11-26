package com.sec.chaton.settings;

import android.graphics.drawable.AnimationDrawable;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.fj */
/* loaded from: classes.dex */
class RunnableC2700fj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AnimationDrawable f9997a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f9998b;

    RunnableC2700fj(SyncStatePreference syncStatePreference, AnimationDrawable animationDrawable) {
        this.f9998b = syncStatePreference;
        this.f9997a = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9997a.start();
    }
}
