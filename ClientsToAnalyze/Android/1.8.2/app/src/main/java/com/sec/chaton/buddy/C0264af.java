package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.af */
/* loaded from: classes.dex */
class C0264af implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1359a;

    C0264af(BuddyFragment buddyFragment) {
        this.f1359a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1786r.m6067f("beforeTextChanged() : " + this.f1359a.f940aB, BuddyFragment.f908a);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1786r.m6067f("onTextChanged() : " + this.f1359a.f940aB, BuddyFragment.f908a);
        if (this.f1359a.f969af != 7 && this.f1359a.f972ai.size() != 0) {
            this.f1359a.m1921L();
            this.f1359a.m1911G();
            if (String.valueOf(charSequence).length() > 0) {
                this.f1359a.f988ay = true;
                this.f1359a.f1021w.setFastScrollEnabled(false);
                this.f1359a.f981ar.m2371a(21);
                return;
            }
            this.f1359a.m1903C();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        C1786r.m6067f("afterTextChanged() : " + this.f1359a.f940aB, BuddyFragment.f908a);
    }
}
