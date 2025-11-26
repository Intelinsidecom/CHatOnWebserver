package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.fo */
/* loaded from: classes.dex */
class C1308fo implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f4844a;

    C1308fo(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f4844a = buddyProfileEditNameActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        this.f4844a.f3899t.setMaxLength(30);
        if (charSequence.length() >= 30) {
            C5179v.m19810a(this.f4844a.f3898s, R.string.setting_input_length_exceed, 1).show();
        }
        if (strValueOf.trim().length() > 0) {
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
