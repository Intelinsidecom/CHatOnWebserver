package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.t */
/* loaded from: classes.dex */
class C0805t implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3101a;

    C0805t(AddBuddyFragment addBuddyFragment) {
        this.f3101a = addBuddyFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3101a.f1676X != null) {
            if (this.f3101a.getResources().getConfiguration().orientation != 2 || charSequence.length() == 0) {
                this.f3101a.m3184d();
            } else {
                this.f3101a.m3181c();
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
