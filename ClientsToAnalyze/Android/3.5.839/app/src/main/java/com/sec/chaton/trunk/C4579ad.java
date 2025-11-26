package com.sec.chaton.trunk;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ad */
/* loaded from: classes.dex */
class C4579ad implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16689a;

    C4579ad(TrunkCommentView trunkCommentView) {
        this.f16689a = trunkCommentView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (this.f16689a.f16445e.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f16689a.f16446f.setEnabled(false);
        } else {
            this.f16689a.f16446f.setEnabled(true);
        }
        ((TrunkDetailActivity) this.f16689a.getActivity()).m17299a(strValueOf.length());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
