package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4809aa;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.e */
/* loaded from: classes.dex */
class C4786e implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f17506a;

    C4786e(BirthdayFragment birthdayFragment) {
        this.f17506a = birthdayFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (C4809aa.m18104a().m18119a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f17506a.f17079d = "FULL";
            } else {
                this.f17506a.f17079d = "SHORT";
            }
        } else if (C4809aa.m18104a().m18119a("birthday_year_show", (Boolean) false).booleanValue()) {
            this.f17506a.f17079d = "FULL_HIDE";
        } else {
            this.f17506a.f17079d = "SHORT_HIDE";
        }
        this.f17506a.m17801a(this.f17506a.f17079d);
    }
}
