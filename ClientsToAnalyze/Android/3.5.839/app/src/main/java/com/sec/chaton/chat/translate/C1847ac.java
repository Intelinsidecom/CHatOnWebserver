package com.sec.chaton.chat.translate;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.ac */
/* loaded from: classes.dex */
class C1847ac implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7028a;

    C1847ac(TranslatorFragment translatorFragment) {
        this.f7028a = translatorFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(this.f7028a.f6975h.getText().toString()) || String.valueOf(charSequence).trim().length() == 0) {
            this.f7028a.m8987a(false);
        } else if (!TextUtils.isEmpty(this.f7028a.f6974g.getText().toString())) {
            this.f7028a.m8987a(true);
        }
    }
}
