package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.s */
/* loaded from: classes.dex */
class C1631s implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f5751a;

    C1631s(EditTextWithClearButton editTextWithClearButton) {
        this.f5751a = editTextWithClearButton;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f5751a.f5657f > 0 && this.f5751a.isFocused() && this.f5751a.f5656e >= 0 && charSequence.length() == this.f5751a.f5656e) {
            C1619g.m5888a(this.f5751a.getContext(), this.f5751a.f5657f, 0).show();
        }
        this.f5751a.m5839a();
    }
}
