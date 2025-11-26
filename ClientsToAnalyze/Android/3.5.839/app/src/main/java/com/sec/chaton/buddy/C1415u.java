package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.u */
/* loaded from: classes.dex */
class C1415u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5051a;

    C1415u(AddBuddyFragment addBuddyFragment) {
        this.f5051a = addBuddyFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f5051a.f3528V != null) {
            if (this.f5051a.getResources().getConfiguration().orientation != 2 || charSequence.length() == 0) {
                this.f5051a.m6252d();
            } else {
                this.f5051a.m6249c();
            }
            if (this.f5051a.f3514H != null && this.f5051a.f3514H.getChildCount() > 0) {
                this.f5051a.f3514H.removeAllViews();
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
