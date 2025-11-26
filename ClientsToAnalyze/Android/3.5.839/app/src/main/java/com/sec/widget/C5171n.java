package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.n */
/* loaded from: classes.dex */
class C5171n implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f18913a;

    C5171n(EditTextWithClearButton editTextWithClearButton) {
        this.f18913a = editTextWithClearButton;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f18913a.f18755i > 0 && this.f18913a.isFocused() && this.f18913a.f18754h >= 0 && charSequence.length() == this.f18913a.f18754h) {
            C5179v.m19810a(this.f18913a.getContext(), this.f18913a.f18755i, 0).show();
        }
        this.f18913a.m19628a();
    }
}
