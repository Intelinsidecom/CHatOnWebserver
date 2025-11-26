package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditStatusFragment.java */
/* renamed from: com.sec.chaton.userprofile.s */
/* loaded from: classes.dex */
class C4800s implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditStatusFragment f17532a;

    C4800s(EditStatusFragment editStatusFragment) {
        this.f17532a = editStatusFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (this.f17532a.f17137g != null) {
            this.f17532a.f17137g.setEnabled(true);
            this.f17532a.f17138h = true;
        } else {
            this.f17532a.f17138h = true;
        }
        this.f17532a.f17141k = strValueOf.length();
        this.f17532a.f17140j.setText(this.f17532a.f17141k + "/40");
    }
}
