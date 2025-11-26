package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.at */
/* loaded from: classes.dex */
class C1223at implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f4300a;

    C1223at(ProfileRegistPushName profileRegistPushName) {
        this.f4300a = profileRegistPushName;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4300a.f4174b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4300a.f4175c.setEnabled(false);
        } else {
            this.f4300a.f4175c.setEnabled(true);
        }
        if (this.f4300a.f4174b.length() < 1) {
            this.f4300a.f4175c.setEnabled(false);
        }
        if (this.f4300a.f4174b.length() >= 30) {
            C1619g.m5888a(this.f4300a.f4173a, R.string.setting_input_length_exceed, 1).show();
        }
    }
}
