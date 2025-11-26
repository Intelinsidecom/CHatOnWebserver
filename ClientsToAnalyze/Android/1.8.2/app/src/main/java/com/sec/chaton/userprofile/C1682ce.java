package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ce */
/* loaded from: classes.dex */
class C1682ce implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6179a;

    C1682ce(UserProfileDetail userProfileDetail) {
        this.f6179a = userProfileDetail;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6179a.f6020C.length() >= 40) {
            C2153y.m7535a(this.f6179a.f6028K, R.string.setting_input_length_exceed, 1).show();
        }
        this.f6179a.m5753m();
    }
}
