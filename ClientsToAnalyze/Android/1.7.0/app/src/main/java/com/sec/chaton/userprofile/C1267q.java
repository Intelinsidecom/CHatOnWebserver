package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.q */
/* loaded from: classes.dex */
class C1267q implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f4364a;

    C1267q(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f4364a = profileRegistStatusMessage;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4364a.f4183b.length() >= 40) {
            C1619g.m5888a(this.f4364a.f4182a, R.string.setting_input_length_exceed, 1).show();
        }
    }
}
