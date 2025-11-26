package com.sec.chaton.smsplugin.spam;

import android.view.inputmethod.InputMethodManager;

/* compiled from: SetupSpamNumberWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bn */
/* loaded from: classes.dex */
class RunnableC4010bn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberWriteForm f14463a;

    RunnableC4010bn(SetupSpamNumberWriteForm setupSpamNumberWriteForm) {
        this.f14463a = setupSpamNumberWriteForm;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.f14463a.getSystemService("input_method")).showSoftInput(this.f14463a.f14378a, 1);
    }
}
