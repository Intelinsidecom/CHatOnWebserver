package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: ActivityPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.af */
/* loaded from: classes.dex */
class C1227af implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockHint f4766a;

    C1227af(ActivityPasswordLockHint activityPasswordLockHint) {
        this.f4766a = activityPasswordLockHint;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4766a.f4514c.length() < 40) {
            if (this.f4766a.f4514c.length() <= 0 || this.f4766a.f4514c.getText().charAt(0) == ' ') {
                if (this.f4766a.f4517i != null) {
                    this.f4766a.f4517i.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                }
                if (this.f4766a.f4517i != null) {
                    this.f4766a.f4517i.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    return;
                }
                return;
            }
            if (this.f4766a.f4517i != null) {
                this.f4766a.f4517i.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            }
            if (this.f4766a.f4517i != null) {
                this.f4766a.f4517i.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(true);
                return;
            }
            return;
        }
        C2153y.m7535a(this.f4766a, R.string.toast_text_max_Length, 0).show();
    }
}
