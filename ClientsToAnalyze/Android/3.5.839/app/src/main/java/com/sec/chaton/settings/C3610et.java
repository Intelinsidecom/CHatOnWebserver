package com.sec.chaton.settings;

import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import java.util.TimerTask;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.et */
/* loaded from: classes.dex */
class C3610et extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f13141a;

    /* renamed from: b */
    final /* synthetic */ InputMethodManager f13142b;

    /* renamed from: c */
    final /* synthetic */ FragmentPasswordLockHint f13143c;

    C3610et(FragmentPasswordLockHint fragmentPasswordLockHint, Handler handler, InputMethodManager inputMethodManager) {
        this.f13143c = fragmentPasswordLockHint;
        this.f13141a = handler;
        this.f13142b = inputMethodManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f13141a.post(new RunnableC3611eu(this));
    }
}
