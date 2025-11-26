package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.t */
/* loaded from: classes.dex */
class C1207t implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4423a;

    C1207t(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f4423a = nonSelfSMSFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String unused = ActivityNonSelfSMS.NonSelfSMSFragment.f4172p = this.f4423a.f4188h.getText().toString();
        if (GlobalApplication.m3265f()) {
            if (this.f4423a.f4201v != null) {
                if (this.f4423a.f4188h.length() == 4) {
                    this.f4423a.f4201v.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                    this.f4423a.f4201v.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                    return;
                } else {
                    this.f4423a.f4201v.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    this.f4423a.f4201v.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                    return;
                }
            }
            return;
        }
        if (this.f4423a.f4188h.length() == 4) {
            this.f4423a.f4190j.setEnabled(true);
        } else {
            this.f4423a.f4190j.setEnabled(false);
        }
    }
}
