package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;

/* renamed from: com.sec.chaton.buddy.n */
/* loaded from: classes.dex */
class C0121n implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f702a;

    C0121n(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f702a = buddyGroupEditActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        this.f702a.m563d();
        this.f702a.m584b();
        if (String.valueOf(charSequence).length() > 0) {
            this.f702a.m552a(charSequence.toString());
            return;
        }
        this.f702a.f508f.m595a(false);
        this.f702a.f524v.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f702a.f525w.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f702a.m553a(this.f702a.f504b, this.f702a.f505c);
    }
}
