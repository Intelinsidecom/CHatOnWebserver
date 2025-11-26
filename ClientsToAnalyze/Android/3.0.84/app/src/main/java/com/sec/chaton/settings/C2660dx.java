package com.sec.chaton.settings;

import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import java.util.TimerTask;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.dx */
/* loaded from: classes.dex */
class C2660dx extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f9925a;

    /* renamed from: b */
    final /* synthetic */ InputMethodManager f9926b;

    /* renamed from: c */
    final /* synthetic */ FragmentPasswordLockHint f9927c;

    C2660dx(FragmentPasswordLockHint fragmentPasswordLockHint, Handler handler, InputMethodManager inputMethodManager) {
        this.f9927c = fragmentPasswordLockHint;
        this.f9925a = handler;
        this.f9926b = inputMethodManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f9925a.post(new RunnableC2661dy(this));
    }
}
