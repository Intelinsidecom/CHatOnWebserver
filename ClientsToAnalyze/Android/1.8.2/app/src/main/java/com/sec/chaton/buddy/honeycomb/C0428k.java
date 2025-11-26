package com.sec.chaton.buddy.honeycomb;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddySelectFragment.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.k */
/* loaded from: classes.dex */
class C0428k implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddySelectFragment f1644a;

    C0428k(BuddySelectFragment buddySelectFragment) {
        this.f1644a = buddySelectFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        this.f1644a.m2429f();
        String strTrim = this.f1644a.f1602n.getText().toString().trim();
        if (strTrim.indexOf(44) != -1) {
            this.f1644a.f1602n.setText(strTrim.replace(",", ""));
            this.f1644a.f1602n.setSelection(this.f1644a.f1602n.getText().toString().length());
        }
    }
}
