package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: BuddyGroupActivity.java */
/* renamed from: com.sec.chaton.buddy.br */
/* loaded from: classes.dex */
class C0306br implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f1417a;

    C0306br(BuddyGroupActivity buddyGroupActivity) {
        this.f1417a = buddyGroupActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() > 0) {
            this.f1417a.f1028d.setEnabled(true);
        } else {
            this.f1417a.f1028d.setEnabled(false);
        }
        if (strValueOf.trim().indexOf(",") != -1) {
            this.f1417a.f1027c.setText(strValueOf.trim().replace(",", ""));
            this.f1417a.f1027c.setSelection(this.f1417a.f1027c.getText().length());
            Toast.makeText(this.f1417a.f1030i, R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
