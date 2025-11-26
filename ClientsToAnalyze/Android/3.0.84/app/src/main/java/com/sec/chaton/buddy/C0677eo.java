package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.eo */
/* loaded from: classes.dex */
class C0677eo implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f2899a;

    C0677eo(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f2899a = buddyProfileEditNameActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        this.f2899a.f2005g.setMaxLength(30);
        if (charSequence.length() >= 30) {
            C3641ai.m13210a(this.f2899a.f2004f, R.string.setting_input_length_exceed, 1).show();
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
