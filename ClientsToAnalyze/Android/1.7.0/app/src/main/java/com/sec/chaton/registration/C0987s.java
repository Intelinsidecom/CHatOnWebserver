package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.s */
/* loaded from: classes.dex */
class C0987s implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f3383a;

    C0987s(ActivityRegist.RegistFragment registFragment) {
        this.f3383a = registFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3383a.f3220o.length() > 0) {
            if (this.f3383a.f3192B != 0 || this.f3383a.f3217l == null) {
                if (this.f3383a.f3192B == 1 && this.f3383a.f3202L != null) {
                    this.f3383a.f3202L.setButtonEnabled(true);
                }
            } else {
                if (this.f3383a.f3224s != null) {
                    this.f3383a.f3224s.setEnabled(true);
                }
                if (this.f3383a.f3226u != null) {
                    this.f3383a.f3226u.setEnabled(true);
                }
                if (this.f3383a.f3225t != null) {
                    this.f3383a.f3225t.setEnabled(true);
                }
                if (this.f3383a.f3202L != null) {
                    this.f3383a.f3202L.setButtonEnabled(true);
                }
            }
            this.f3383a.f3220o.setShowClear(true);
            return;
        }
        if (this.f3383a.f3224s != null) {
            this.f3383a.f3224s.setEnabled(false);
        }
        if (this.f3383a.f3226u != null) {
            this.f3383a.f3226u.setEnabled(false);
        }
        if (this.f3383a.f3225t != null) {
            this.f3383a.f3225t.setEnabled(false);
        }
        if (this.f3383a.f3202L != null) {
            this.f3383a.f3202L.setButtonEnabled(false);
        }
        this.f3383a.f3220o.setShowClear(false);
    }
}
