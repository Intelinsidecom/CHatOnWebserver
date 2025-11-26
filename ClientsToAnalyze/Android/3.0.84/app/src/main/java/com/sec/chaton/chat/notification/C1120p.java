package com.sec.chaton.chat.notification;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.p */
/* loaded from: classes.dex */
class C1120p implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4530a;

    C1120p(ScreenNotification2 screenNotification2) {
        this.f4530a = screenNotification2;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4530a.f4394M != null) {
            this.f4530a.f4394M.removeCallbacks(this.f4530a.f4393L);
        }
        this.f4530a.m5422a(charSequence);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
