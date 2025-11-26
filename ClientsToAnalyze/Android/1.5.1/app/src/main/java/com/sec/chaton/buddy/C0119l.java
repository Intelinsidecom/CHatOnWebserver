package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.buddy.l */
/* loaded from: classes.dex */
class C0119l implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f699a;

    C0119l(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f699a = buddyGroupEditActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        this.f699a.m564e();
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() > 0) {
            this.f699a.f491D.setEnabled(true);
        } else {
            this.f699a.f491D.setEnabled(false);
        }
        if (strValueOf.trim().indexOf(",") != -1) {
            this.f699a.f515m.setText(strValueOf.trim().replace(",", ""));
            this.f699a.f515m.setSelection(this.f699a.f515m.getText().length());
            Toast.makeText(this.f699a.f514l, C0062R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
    }
}
