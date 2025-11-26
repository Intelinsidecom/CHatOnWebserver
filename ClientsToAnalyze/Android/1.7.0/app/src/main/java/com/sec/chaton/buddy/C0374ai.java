package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.ai */
/* loaded from: classes.dex */
class C0374ai implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1342a;

    C0374ai(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1342a = buddyGroupProfileActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            this.f1342a.f1180e.setButtonEnabled(true);
        } else {
            this.f1342a.f1180e.setButtonEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
