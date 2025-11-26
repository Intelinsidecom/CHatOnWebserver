package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ch */
/* loaded from: classes.dex */
class C1685ch implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6182a;

    C1685ch(UserProfileDetail userProfileDetail) {
        this.f6182a = userProfileDetail;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6182a.f6029L = true;
        this.f6182a.invalidateOptionsMenu();
    }
}
