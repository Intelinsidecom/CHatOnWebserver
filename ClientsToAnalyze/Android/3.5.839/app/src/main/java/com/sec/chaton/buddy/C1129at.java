package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.at */
/* loaded from: classes.dex */
class C1129at implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f4347a;

    C1129at(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f4347a = buddyEditNickNameFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f4347a.f3564g.setText(charSequence.length() + "/30");
        if (TextUtils.isEmpty(this.f4347a.f3562e.getText()) || String.valueOf(charSequence).trim().length() == 0) {
            if (this.f4347a.f3563f != null) {
                this.f4347a.f3563f.setEnabled(false);
            }
            this.f4347a.f3572o = false;
            return;
        }
        if (this.f4347a.f3562e.getText().toString().trim().compareTo(this.f4347a.f3566i) != 0) {
            if (this.f4347a.f3563f != null) {
                this.f4347a.f3563f.setEnabled(true);
            }
            this.f4347a.f3572o = true;
        } else {
            if (this.f4347a.f3563f != null) {
                this.f4347a.f3563f.setEnabled(false);
            }
            this.f4347a.f3572o = false;
        }
        if (charSequence.length() == 31) {
            C5179v.m19810a(this.f4347a.f3571n.getApplicationContext(), R.string.setting_input_length_exceed, 1).show();
        }
    }
}
