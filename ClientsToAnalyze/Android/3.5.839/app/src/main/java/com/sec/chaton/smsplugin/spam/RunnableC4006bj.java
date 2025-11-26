package com.sec.chaton.smsplugin.spam;

import android.view.inputmethod.InputMethodManager;

/* compiled from: SetupSpamNumberWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bj */
/* loaded from: classes.dex */
class RunnableC4006bj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberWriteForm f14459a;

    RunnableC4006bj(SetupSpamNumberWriteForm setupSpamNumberWriteForm) {
        this.f14459a = setupSpamNumberWriteForm;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.f14459a.getSystemService("input_method")).showSoftInput(this.f14459a.f14378a, 0);
    }
}
