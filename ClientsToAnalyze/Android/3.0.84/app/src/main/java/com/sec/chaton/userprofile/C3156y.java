package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditProfileFragment.java */
/* renamed from: com.sec.chaton.userprofile.y */
/* loaded from: classes.dex */
class C3156y implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditProfileFragment f11437a;

    C3156y(EditProfileFragment editProfileFragment) {
        this.f11437a = editProfileFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f11437a.f11072f != null) {
            this.f11437a.f11072f.setEnabled(true);
            this.f11437a.f11073g = true;
            if (this.f11437a.f11068b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                this.f11437a.f11072f.setEnabled(false);
                this.f11437a.f11073g = false;
                return;
            }
            return;
        }
        this.f11437a.f11073g = true;
        if (this.f11437a.f11068b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f11437a.f11073g = false;
        }
    }
}
