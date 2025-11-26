package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.cf */
/* loaded from: classes.dex */
class C0321cf implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1441a;

    C0321cf(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1441a = buddyGroupEditActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() > 0) {
            this.f1441a.f1039G.setEnabled(true);
        } else {
            this.f1441a.f1039G.setEnabled(false);
        }
        if (strValueOf.trim().indexOf(",") != -1) {
            this.f1441a.f1063p.setText(strValueOf.trim().replace(",", ""));
            this.f1441a.f1063p.setSelection(this.f1441a.f1063p.getText().length());
            Toast.makeText(this.f1441a.f1062o, R.string.buddy_group_profile_rename_not_allowed_character, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
