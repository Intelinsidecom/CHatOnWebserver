package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.registration.ActivityRegistPushName;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ak */
/* loaded from: classes.dex */
class C1157ak implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f4359a;

    C1157ak(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f4359a = registPushNameFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4359a.f4257a.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f4359a.f4257a.length()) {
                    break;
                }
                if (this.f4359a.f4257a.getText().charAt(i4) != ' ') {
                    if (GlobalApplication.m3265f()) {
                        if (this.f4359a.f4271o != null) {
                            this.f4359a.f4271o.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                            this.f4359a.f4271o.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                        }
                    } else {
                        this.f4359a.f4259c.setEnabled(true);
                    }
                } else {
                    if (GlobalApplication.m3265f()) {
                        if (this.f4359a.f4271o != null) {
                            this.f4359a.f4271o.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                            this.f4359a.f4271o.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                        }
                    } else {
                        this.f4359a.f4259c.setEnabled(false);
                    }
                    i4++;
                }
            }
        }
        if (this.f4359a.f4257a.getText().toString().trim().indexOf(",") != -1) {
            this.f4359a.f4257a.setText(this.f4359a.f4257a.getText().toString().trim().replace(",", ""));
            this.f4359a.f4257a.setSelection(this.f4359a.f4257a.getText().length());
        }
        if (this.f4359a.f4257a.length() < 1) {
            if (GlobalApplication.m3265f()) {
                if (this.f4359a.f4271o != null) {
                    this.f4359a.f4271o.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    this.f4359a.f4271o.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                    return;
                }
                return;
            }
            this.f4359a.f4259c.setEnabled(false);
        }
    }
}
