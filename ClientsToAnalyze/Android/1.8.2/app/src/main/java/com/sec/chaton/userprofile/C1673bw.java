package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.bw */
/* loaded from: classes.dex */
class C1673bw implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6169a;

    C1673bw(UserProfileDetail userProfileDetail) {
        this.f6169a = userProfileDetail;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6169a.f6019B.getText().toString().replaceAll(" ", "").replaceAll("\n", "");
        if (this.f6169a.f6019B.getText().toString().trim().indexOf(",") != -1) {
            this.f6169a.f6019B.setText(this.f6169a.f6019B.getText().toString().trim().replace(",", ""));
            this.f6169a.f6019B.setSelection(this.f6169a.f6019B.getText().length());
            C2153y.m7535a(this.f6169a.f6028K, R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
        if (this.f6169a.f6019B.getText().toString().replaceAll(" ", "").replaceAll("\n", "").trim().length() < 1) {
            this.f6169a.f6029L = false;
            this.f6169a.invalidateOptionsMenu();
        } else if (this.f6169a.f6019B.length() >= 30) {
            C2153y.m7535a(this.f6169a.f6028K, R.string.setting_input_length_exceed, 1).show();
        } else {
            this.f6169a.m5753m();
        }
    }
}
