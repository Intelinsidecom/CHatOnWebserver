package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.h */
/* loaded from: classes.dex */
class C0432h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName f2945a;

    C0432h(ActivityRegistPushName activityRegistPushName) {
        this.f2945a = activityRegistPushName;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f2945a.f2879a.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f2945a.f2879a.length()) {
                    break;
                }
                if (this.f2945a.f2879a.getText().charAt(i4) != ' ') {
                    this.f2945a.f2880b.setEnabled(true);
                    break;
                } else {
                    this.f2945a.f2880b.setEnabled(false);
                    i4++;
                }
            }
        }
        if (this.f2945a.f2879a.getText().toString().trim().indexOf(",") != -1) {
            this.f2945a.f2879a.setText(this.f2945a.f2879a.getText().toString().trim().replace(",", ""));
            this.f2945a.f2879a.setSelection(this.f2945a.f2879a.getText().length());
            Toast.makeText(this.f2945a.f2882d, C0062R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
        if (this.f2945a.f2879a.length() < 1) {
            this.f2945a.f2880b.setEnabled(false);
        }
    }
}
