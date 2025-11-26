package com.sec.chaton.chat.notification;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ag */
/* loaded from: classes.dex */
class C1800ag implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6810a;

    C1800ag(ScreenNotification2 screenNotification2) {
        this.f6810a = screenNotification2;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6810a.f6768ao != null) {
            this.f6810a.f6768ao.removeCallbacks(this.f6810a.f6758ae);
        }
        this.f6810a.m8878a(charSequence);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
