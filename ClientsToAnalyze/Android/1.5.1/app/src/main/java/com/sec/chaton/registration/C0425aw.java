package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.aw */
/* loaded from: classes.dex */
class C0425aw implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2936a;

    C0425aw(ActivityRegist.RegisteFragment registeFragment) {
        this.f2936a = registeFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f2936a.f2867l.length() <= 0 || (this.f2936a.f2876u != 1 && this.f2936a.f2864i == null)) {
            this.f2936a.f2871p.setEnabled(false);
        } else {
            this.f2936a.f2871p.setEnabled(true);
        }
    }
}
