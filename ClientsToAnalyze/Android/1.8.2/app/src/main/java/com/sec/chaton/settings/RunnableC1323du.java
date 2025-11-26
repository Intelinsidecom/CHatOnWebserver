package com.sec.chaton.settings;

import android.graphics.drawable.AnimationDrawable;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.du */
/* loaded from: classes.dex */
class RunnableC1323du implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AnimationDrawable f4898a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f4899b;

    RunnableC1323du(SyncStatePreference syncStatePreference, AnimationDrawable animationDrawable) {
        this.f4899b = syncStatePreference;
        this.f4898a = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4898a.start();
    }
}
