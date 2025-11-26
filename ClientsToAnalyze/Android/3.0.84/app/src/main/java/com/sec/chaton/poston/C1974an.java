package com.sec.chaton.poston;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.an */
/* loaded from: classes.dex */
class C1974an implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7671a;

    C1974an(PostONDetailFragment postONDetailFragment) {
        this.f7671a = postONDetailFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f7671a.f7531ac.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f7671a.f7530ab.setEnabled(false);
        } else {
            this.f7671a.f7530ab.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
