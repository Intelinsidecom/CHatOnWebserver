package com.sec.chaton.settings;

import android.graphics.drawable.AnimationDrawable;

/* renamed from: com.sec.chaton.settings.bm */
/* loaded from: classes.dex */
class RunnableC0491bm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AnimationDrawable f3182a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f3183b;

    RunnableC0491bm(SyncStatePreference syncStatePreference, AnimationDrawable animationDrawable) {
        this.f3183b = syncStatePreference;
        this.f3182a = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3182a.start();
    }
}
