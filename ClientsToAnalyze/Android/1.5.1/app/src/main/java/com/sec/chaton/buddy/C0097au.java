package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.buddy.au */
/* loaded from: classes.dex */
class C0097au implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f639a;

    C0097au(BuddyGroupActivity buddyGroupActivity) {
        this.f639a = buddyGroupActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        this.f639a.m541b();
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() > 0) {
            this.f639a.f483d.setEnabled(true);
        } else {
            this.f639a.f483d.setEnabled(false);
        }
        if (strValueOf.trim().indexOf(",") != -1) {
            this.f639a.f482c.setText(strValueOf.trim().replace(",", ""));
            this.f639a.f482c.setSelection(this.f639a.f482c.getText().length());
            Toast.makeText(this.f639a.f485f, C0062R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
    }
}
