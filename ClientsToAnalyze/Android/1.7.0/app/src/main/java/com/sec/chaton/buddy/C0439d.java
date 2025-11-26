package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.util.C1341p;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.d */
/* loaded from: classes.dex */
class C0439d implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1431a;

    C0439d(BuddyFragment buddyFragment) {
        this.f1431a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1341p.m4663f("beforeTextChanged() : " + this.f1431a.f1120ac, BuddyFragment.f1090a);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1341p.m4663f("onTextChanged() : " + this.f1431a.f1120ac, BuddyFragment.f1090a);
        if (this.f1431a.f1103M != 7 && this.f1431a.f1106P.size() != 0) {
            this.f1431a.m2174r();
            if (String.valueOf(charSequence).length() > 0) {
                this.f1431a.f1116Z = true;
                this.f1431a.f1156n.setFastScrollEnabled(false);
                this.f1431a.f1114X.m2352a(21);
                return;
            }
            this.f1431a.f1116Z = false;
            if (this.f1431a.f1101K == 11) {
                this.f1431a.f1156n.setFastScrollEnabled(true);
            }
            this.f1431a.f1156n.setVisibility(0);
            this.f1431a.f1160r.setVisibility(8);
            this.f1431a.m2125a(this.f1431a.f1106P, this.f1431a.f1107Q);
            this.f1431a.m2178t();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        C1341p.m4663f("afterTextChanged() : " + this.f1431a.f1120ac, BuddyFragment.f1090a);
    }
}
