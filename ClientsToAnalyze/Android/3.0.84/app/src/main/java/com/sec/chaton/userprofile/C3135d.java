package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.util.C3159aa;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.d */
/* loaded from: classes.dex */
class C3135d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f11370a;

    C3135d(BirthdayFragment birthdayFragment) {
        this.f11370a = birthdayFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f11370a.f11042r.setClickable(true);
        if (z) {
            if (C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11370a.f11028d = "FULL";
            } else {
                this.f11370a.f11028d = "SHORT";
            }
        } else if (C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
            this.f11370a.f11028d = "FULL_HIDE";
        } else {
            this.f11370a.f11028d = "SHORT_HIDE";
        }
        this.f11370a.m10647a(this.f11370a.f11028d);
    }
}
