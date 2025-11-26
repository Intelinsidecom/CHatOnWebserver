package com.sec.chaton.util;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C1619g;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bn */
/* loaded from: classes.dex */
class C1318bn implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4537a;

    C1318bn(ScreenOnNotification screenOnNotification) {
        this.f4537a = screenOnNotification;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 2000 && this.f4537a.f4446o.isEnabled()) {
            C1619g.m5888a(GlobalApplication.f2410d, R.string.toast_text_max_Length, 0).show();
            return;
        }
        if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f4537a.f4446o.isEnabled()) {
            this.f4537a.f4446o.setEnabled(true);
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4537a.f4446o.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
