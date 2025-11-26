package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.aa */
/* loaded from: classes.dex */
class C3633aa implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f13463a;

    C3633aa(EditTextWithClearButton editTextWithClearButton) {
        this.f13463a = editTextWithClearButton;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f13463a.f13388i > 0 && this.f13463a.isFocused() && this.f13463a.f13387h >= 0 && charSequence.length() == this.f13463a.f13387h) {
            C3641ai.m13210a(this.f13463a.getContext(), this.f13463a.f13388i, 0).show();
        }
        this.f13463a.m13096a();
    }
}
