package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.userprofile.ao */
/* loaded from: classes.dex */
class C0561ao implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f3540a;

    C0561ao(ProfileRegistPushName profileRegistPushName) {
        this.f3540a = profileRegistPushName;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3540a.f3346b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f3540a.f3347c.setEnabled(false);
        } else {
            this.f3540a.f3347c.setEnabled(true);
        }
        if (this.f3540a.f3346b.getText().toString().trim().indexOf(",") != -1) {
            this.f3540a.f3346b.setText(this.f3540a.f3346b.getText().toString().trim().replace(",", ""));
            this.f3540a.f3346b.setSelection(this.f3540a.f3346b.getText().length());
            Toast.makeText(this.f3540a.f3345a, C0062R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
        if (this.f3540a.f3346b.length() < 1) {
            this.f3540a.f3347c.setEnabled(false);
        }
        if (this.f3540a.f3346b.length() >= 30) {
            Toast.makeText(this.f3540a.f3345a, C0062R.string.setting_input_length_exceed, 1).show();
        }
    }
}
