package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: BuddyChatInfoActivity.java */
/* renamed from: com.sec.chaton.buddy.ad */
/* loaded from: classes.dex */
class C0262ad implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyChatInfoActivity f1357a;

    C0262ad(BuddyChatInfoActivity buddyChatInfoActivity) {
        this.f1357a = buddyChatInfoActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() <= 0 || strValueOf.replaceAll(" ", "").replaceAll("\n", "").replaceAll(",", "").length() <= 0) {
            this.f1357a.f895e.m2042b(false);
        } else {
            this.f1357a.f895e.m2042b(true);
        }
        this.f1357a.invalidateOptionsMenu();
        if (this.f1357a.f893c.length() >= 30) {
            C2153y.m7535a(this.f1357a, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
