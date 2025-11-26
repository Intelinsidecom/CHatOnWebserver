package com.sec.chaton.poston;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.x */
/* loaded from: classes.dex */
class C3029x implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11219a;

    C3029x(PostONDetailFragment postONDetailFragment) {
        this.f11219a = postONDetailFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (this.f11219a.f10923ae.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f11219a.f10922ad.setEnabled(false);
            this.f11219a.f10937as.setVisibility(8);
            return;
        }
        this.f11219a.f10922ad.setEnabled(true);
        this.f11219a.f10937as.setVisibility(0);
        this.f11219a.f10939au = strValueOf.length();
        this.f11219a.f10938at.setText(this.f11219a.f10939au + "/140");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
