package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.o */
/* loaded from: classes.dex */
class C0439o implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS f2952a;

    C0439o(ActivityNonSelfSMS activityNonSelfSMS) {
        this.f2952a = activityNonSelfSMS;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f2952a.f2829v.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 < this.f2952a.f2829v.length()) {
                    if (this.f2952a.f2829v.getText().charAt(i4) != ' ' && this.f2952a.f2816i.length() == 6 && this.f2952a.f2808a != null) {
                        this.f2952a.f2818k.setEnabled(true);
                        break;
                    } else {
                        this.f2952a.f2818k.setEnabled(false);
                        i4++;
                    }
                } else {
                    break;
                }
            }
        }
        if (this.f2952a.f2829v.getText().toString().trim().indexOf(",") != -1) {
            this.f2952a.f2829v.setText(this.f2952a.f2829v.getText().toString().trim().replace(",", ""));
            this.f2952a.f2829v.setSelection(this.f2952a.f2829v.getText().length());
            Toast.makeText(this.f2952a.f2810c, C0062R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
        if (this.f2952a.f2829v.getText().length() < 1) {
            this.f2952a.f2818k.setEnabled(false);
        }
    }
}
