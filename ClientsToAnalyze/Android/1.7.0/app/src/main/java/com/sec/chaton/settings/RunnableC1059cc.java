package com.sec.chaton.settings;

import android.graphics.drawable.AnimationDrawable;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.cc */
/* loaded from: classes.dex */
class RunnableC1059cc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AnimationDrawable f3701a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f3702b;

    RunnableC1059cc(SyncStatePreference syncStatePreference, AnimationDrawable animationDrawable) {
        this.f3702b = syncStatePreference;
        this.f3701a = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3701a.start();
    }
}
