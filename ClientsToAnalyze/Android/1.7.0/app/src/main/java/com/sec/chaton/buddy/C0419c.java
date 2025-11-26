package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.c */
/* loaded from: classes.dex */
class C0419c implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1394a;

    C0419c(BuddyFragment buddyFragment) {
        this.f1394a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() <= 0 || strValueOf.replaceAll(" ", "").replaceAll("\n", "").replaceAll(",", "").length() <= 0) {
            this.f1394a.f1162t.setButtonEnabled(false);
        } else {
            this.f1394a.f1162t.setButtonEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
