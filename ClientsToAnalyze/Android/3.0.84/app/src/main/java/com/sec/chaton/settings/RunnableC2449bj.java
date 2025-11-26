package com.sec.chaton.settings;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bj */
/* loaded from: classes.dex */
class RunnableC2449bj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9309a;

    RunnableC2449bj(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f9309a = activityPasswordLockSet;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < 4; i++) {
            this.f9309a.f9030e[i].setVisibility(4);
        }
    }
}
