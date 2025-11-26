package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.a */
/* loaded from: classes.dex */
class C1622a implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f6109a;

    C1622a(BirthdayActivity birthdayActivity) {
        this.f6109a = birthdayActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6109a.f5776d = true;
        this.f6109a.invalidateOptionsMenu();
    }
}
