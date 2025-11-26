package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.ax */
/* loaded from: classes.dex */
class C0539ax implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f2498a;

    C0539ax(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f2498a = buddyEditNickNameFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(this.f2498a.f1712e.getText()) || String.valueOf(charSequence).trim().length() == 0) {
            this.f2498a.f1713f.setEnabled(false);
            return;
        }
        if (this.f2498a.f1712e.getText().toString().trim().compareTo(this.f2498a.f1715h) != 0) {
            this.f2498a.f1713f.setEnabled(true);
        } else {
            this.f2498a.f1713f.setEnabled(false);
        }
        if (charSequence.length() == 31) {
            C3641ai.m13210a(this.f2498a.f1720m.getApplicationContext(), R.string.setting_input_length_exceed, 1).show();
        }
    }
}
