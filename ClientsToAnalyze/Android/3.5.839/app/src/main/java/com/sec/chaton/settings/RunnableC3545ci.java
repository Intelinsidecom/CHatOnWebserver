package com.sec.chaton.settings;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ci */
/* loaded from: classes.dex */
class RunnableC3545ci implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13033a;

    RunnableC3545ci(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f13033a = activityPasswordLockSet;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < 4; i++) {
            this.f13033a.f12595h[i].setVisibility(4);
        }
    }
}
