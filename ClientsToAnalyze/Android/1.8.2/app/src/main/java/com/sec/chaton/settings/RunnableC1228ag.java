package com.sec.chaton.settings;

import com.sec.chaton.R;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ag */
/* loaded from: classes.dex */
class RunnableC1228ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f4767a;

    RunnableC1228ag(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f4767a = activityPasswordLockSet;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < 4; i++) {
            this.f4767a.f4520b[i].setBackgroundResource(R.drawable.password_normal);
            this.f4767a.f4520b[i].setText("");
        }
    }
}
