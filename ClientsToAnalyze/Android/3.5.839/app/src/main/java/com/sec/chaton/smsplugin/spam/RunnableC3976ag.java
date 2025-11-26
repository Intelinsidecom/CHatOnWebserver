package com.sec.chaton.smsplugin.spam;

import android.view.inputmethod.InputMethodManager;

/* compiled from: SetupSpamKeywordWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ag */
/* loaded from: classes.dex */
class RunnableC3976ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordWriteForm f14416a;

    RunnableC3976ag(SetupSpamKeywordWriteForm setupSpamKeywordWriteForm) {
        this.f14416a = setupSpamKeywordWriteForm;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.f14416a.getSystemService("input_method")).showSoftInput(this.f14416a.f14330e, 0);
    }
}
