package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditNameFragment.java */
/* renamed from: com.sec.chaton.userprofile.p */
/* loaded from: classes.dex */
class C4797p implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditNameFragment f17529a;

    C4797p(EditNameFragment editNameFragment) {
        this.f17529a = editNameFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (this.f17529a.f17124g != null) {
            this.f17529a.f17124g.setEnabled(true);
            this.f17529a.f17125h = true;
            if (this.f17529a.f17120c.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                this.f17529a.f17124g.setEnabled(false);
                this.f17529a.f17125h = false;
            }
            if (this.f17529a.f17120c.getText().toString().trim().compareTo(this.f17529a.f17123f) == 0) {
                this.f17529a.f17124g.setEnabled(false);
                this.f17529a.f17125h = false;
            }
        } else {
            this.f17529a.f17125h = true;
            if (this.f17529a.f17120c.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                this.f17529a.f17125h = false;
            }
        }
        this.f17529a.f17128k = strValueOf.length();
        this.f17529a.f17127j.setText(this.f17529a.f17128k + "/30");
    }
}
