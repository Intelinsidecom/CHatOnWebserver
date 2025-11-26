package com.sec.chaton.smsplugin.spam;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;

/* compiled from: SetupSpamKeywordWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.aj */
/* loaded from: classes.dex */
class C3979aj implements TextWatcher {

    /* renamed from: a */
    String f14419a = "";

    /* renamed from: b */
    final /* synthetic */ SetupSpamKeywordWriteForm f14420b;

    C3979aj(SetupSpamKeywordWriteForm setupSpamKeywordWriteForm) {
        this.f14420b = setupSpamKeywordWriteForm;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C3890m.m14999e("ssibong", "onTextChange:" + charSequence.toString());
        if (C4149cd.m16443l(charSequence.toString()) > 32) {
            try {
                this.f14420b.f14330e.setText(this.f14419a);
                this.f14420b.f14330e.setSelection(this.f14419a.length());
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f14420b.f14333h > 3000) {
                    this.f14420b.showDialog(5);
                    this.f14420b.f14333h = jCurrentTimeMillis;
                    return;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.f14419a = charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
