package com.sec.chaton.poston;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bs */
/* loaded from: classes.dex */
class C3001bs implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11116a;

    C3001bs(PostONWriteFragment postONWriteFragment) {
        this.f11116a = postONWriteFragment;
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
        if (this.f11116a.f10980L != null) {
            if (!TextUtils.isEmpty(this.f11116a.f11028w.getText()) && strValueOf.trim().length() != 0) {
                this.f11116a.f10995ab = true;
                this.f11116a.f10980L.setEnabled(true);
                this.f11116a.f11027v = strValueOf.length();
                this.f11116a.f11026u.setText(this.f11116a.f11027v + "/140");
                return;
            }
            this.f11116a.f11027v = strValueOf.length();
            this.f11116a.f11026u.setText(this.f11116a.f11027v + "/140");
            if ((this.f11116a.f10987S == null || this.f11116a.f10987S.size() <= 0) && TextUtils.isEmpty(this.f11116a.f10970B)) {
                this.f11116a.f10980L.setEnabled(false);
                this.f11116a.f10995ab = false;
                return;
            } else {
                this.f11116a.f10995ab = true;
                this.f11116a.f10980L.setEnabled(true);
                return;
            }
        }
        if (TextUtils.isEmpty(this.f11116a.f11028w.getText()) || strValueOf.trim().length() == 0) {
            if (this.f11116a.f10987S == null || this.f11116a.f10987S.size() <= 0) {
                this.f11116a.f10995ab = false;
                return;
            } else {
                this.f11116a.f10995ab = true;
                return;
            }
        }
        this.f11116a.f10995ab = true;
    }
}
