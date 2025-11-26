package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.es */
/* loaded from: classes.dex */
class C3609es implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockHint f13140a;

    C3609es(FragmentPasswordLockHint fragmentPasswordLockHint) {
        this.f13140a = fragmentPasswordLockHint;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f13140a.f12725c.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f13140a.f12725c.length()) {
                    break;
                }
                if (this.f13140a.f12725c.getText().charAt(i4) != ' ') {
                    if (this.f13140a.f12729g != null) {
                        this.f13140a.f12729g.setEnabled(true);
                    }
                } else {
                    i4++;
                }
            }
        }
        if (this.f13140a.f12725c.length() < 1 && this.f13140a.f12729g != null) {
            this.f13140a.f12729g.setEnabled(false);
        }
        this.f13140a.f12731i = String.valueOf(charSequence).length();
        this.f13140a.f12726d.setText(this.f13140a.f12731i + "/40");
    }
}
