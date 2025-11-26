package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.eq */
/* loaded from: classes.dex */
class C0386eq implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1544a;

    C0386eq(GroupProfileFragment groupProfileFragment) {
        this.f1544a = groupProfileFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
        }
        this.f1544a.getActivity().invalidateOptionsMenu();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
