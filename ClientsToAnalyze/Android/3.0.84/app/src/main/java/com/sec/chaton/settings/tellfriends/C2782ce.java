package com.sec.chaton.settings.tellfriends;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: WeiboTextInputLayout.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ce */
/* loaded from: classes.dex */
class C2782ce implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ WeiboTextInputLayout f10213a;

    C2782ce(WeiboTextInputLayout weiboTextInputLayout) {
        this.f10213a = weiboTextInputLayout;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f10213a.f10072c.setText(String.format("(%d/%d)", Integer.valueOf(this.f10213a.f10077h.m9925a(editable.toString())), Integer.valueOf(this.f10213a.f10075f)));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
