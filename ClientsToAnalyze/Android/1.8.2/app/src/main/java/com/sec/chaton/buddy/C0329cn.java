package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.cn */
/* loaded from: classes.dex */
class C0329cn implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f1471a;

    C0329cn(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f1471a = buddyProfileEditNameActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1471a.f1086p = true;
        this.f1471a.f1080j.getText().toString().replaceAll(" ", "").replaceAll("\n", "");
        if (this.f1471a.f1080j.getText().toString().trim().indexOf(",") != -1) {
            this.f1471a.f1080j.setText(this.f1471a.f1080j.getText().toString().trim().replace(",", ""));
            this.f1471a.f1080j.setSelection(this.f1471a.f1080j.getText().length());
            C2153y.m7535a(this.f1471a.f1079i, R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
        if (this.f1471a.f1080j.getText().toString().replaceAll(" ", "").replaceAll("\n", "").trim().length() < 1) {
            this.f1471a.f1086p = false;
            this.f1471a.invalidateOptionsMenu();
            return;
        }
        if (!this.f1471a.f1080j.getText().toString().equals(this.f1471a.f1084n)) {
            if (this.f1471a.f1080j.getText().toString().replaceAll(" ", "").replaceAll("\n", "").trim().length() >= 1) {
                this.f1471a.f1086p = true;
            }
        } else {
            this.f1471a.f1086p = false;
        }
        this.f1471a.invalidateOptionsMenu();
        if (this.f1471a.f1080j.length() >= 30) {
            C2153y.m7535a(this.f1471a.f1079i, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
