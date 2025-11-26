package com.sec.chaton.poston;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.br */
/* loaded from: classes.dex */
class C2005br implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7720a;

    C2005br(PostONWriteFragment postONWriteFragment) {
        this.f7720a = postONWriteFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (this.f7720a.f7584J != null) {
            if (TextUtils.isEmpty(this.f7720a.f7630v.getText()) || strValueOf.trim().length() == 0) {
                this.f7720a.f7629u.setText(strValueOf.length() + "/140");
                if ((this.f7720a.f7591Q == null || this.f7720a.f7591Q.size() <= 0) && (this.f7720a.f7575A == null || this.f7720a.f7575A.isEmpty())) {
                    this.f7720a.f7584J.setEnabled(false);
                    this.f7720a.f7598Z = false;
                    return;
                } else {
                    this.f7720a.f7598Z = true;
                    this.f7720a.f7584J.setEnabled(true);
                    return;
                }
            }
            this.f7720a.f7598Z = true;
            this.f7720a.f7584J.setEnabled(true);
            this.f7720a.f7629u.setText(strValueOf.length() + "/140");
            return;
        }
        if (TextUtils.isEmpty(this.f7720a.f7630v.getText()) || strValueOf.trim().length() == 0) {
            if (this.f7720a.f7591Q == null || this.f7720a.f7591Q.size() <= 0) {
                this.f7720a.f7598Z = false;
                return;
            } else {
                this.f7720a.f7598Z = true;
                return;
            }
        }
        this.f7720a.f7598Z = true;
    }
}
