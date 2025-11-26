package com.sec.chaton.util;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C2153y;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bk */
/* loaded from: classes.dex */
class C1755bk implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6393a;

    C1755bk(ScreenOnNotification screenOnNotification) {
        this.f6393a = screenOnNotification;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 2000 && this.f6393a.f6307q.isEnabled()) {
            C2153y.m7535a(GlobalApplication.f2779e, R.string.toast_text_max_Length, 0).show();
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f6393a.f6307q.isEnabled()) {
            this.f6393a.f6307q.setEnabled(true);
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6393a.f6307q.setEnabled(false);
        }
        if (!this.f6393a.f6291B) {
            this.f6393a.f6316z.removeCallbacks(this.f6393a.f6290A);
            this.f6393a.f6291B = true;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
