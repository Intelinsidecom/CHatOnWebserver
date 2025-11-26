package com.sec.chaton.util;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C2153y;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.d */
/* loaded from: classes.dex */
class C1772d implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6431a;

    C1772d(BlackScreenNotification blackScreenNotification) {
        this.f6431a = blackScreenNotification;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 2000 && this.f6431a.f6253s.isEnabled()) {
            C2153y.m7535a(GlobalApplication.f2778d, R.string.toast_text_max_Length, 0).show();
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f6431a.f6253s.isEnabled()) {
            this.f6431a.f6253s.setEnabled(true);
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6431a.f6253s.setEnabled(false);
        }
        this.f6431a.f6238D = true;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
