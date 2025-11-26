package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cq */
/* loaded from: classes.dex */
class C0332cq implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1474a;

    C0332cq(BuddyProfileFragment buddyProfileFragment) {
        this.f1474a = buddyProfileFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (GlobalApplication.m3265f()) {
            if (this.f1474a.f1124ah.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                this.f1474a.f1123ag.setEnabled(false);
            } else {
                this.f1474a.f1123ag.setVisibility(0);
                this.f1474a.f1123ag.setEnabled(true);
            }
            if (this.f1474a.f1124ah.length() < 1) {
                this.f1474a.f1123ag.setVisibility(0);
                this.f1474a.f1123ag.setEnabled(false);
            }
        }
        if (this.f1474a.f1124ah.length() >= 140) {
            Toast.makeText(this.f1474a.f1157s, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
