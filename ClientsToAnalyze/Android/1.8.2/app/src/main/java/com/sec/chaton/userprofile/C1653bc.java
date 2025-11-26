package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.bc */
/* loaded from: classes.dex */
class C1653bc implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f6144a;

    C1653bc(ProfileRegistPushName profileRegistPushName) {
        this.f6144a = profileRegistPushName;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6144a.f5956b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6144a.f5957c.setEnabled(false);
        } else {
            this.f6144a.f5957c.setEnabled(true);
        }
        if (this.f6144a.f5956b.getText().toString().trim().indexOf(",") != -1) {
            this.f6144a.f5956b.setText(this.f6144a.f5956b.getText().toString().trim().replace(",", ""));
            this.f6144a.f5956b.setSelection(this.f6144a.f5956b.getText().length());
            Toast.makeText(this.f6144a.f5955a, R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
        if (this.f6144a.f5956b.length() < 1) {
            this.f6144a.f5957c.setEnabled(false);
        }
        if (this.f6144a.f5956b.length() >= 30) {
            Toast.makeText(this.f6144a.f5955a, R.string.setting_input_length_exceed, 1).show();
        }
    }
}
