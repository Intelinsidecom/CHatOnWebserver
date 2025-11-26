package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.ce */
/* loaded from: classes.dex */
class C0320ce implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1440a;

    C0320ce(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1440a = buddyGroupEditActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1440a.m2102b();
        if (String.valueOf(charSequence).length() > 0) {
            this.f1440a.m2074a(charSequence.toString());
            return;
        }
        this.f1440a.f1056i.m2403a(false);
        this.f1440a.f1072y.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f1440a.f1073z.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f1440a.m2075a(this.f1440a.f1052b, this.f1440a.f1053c);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
