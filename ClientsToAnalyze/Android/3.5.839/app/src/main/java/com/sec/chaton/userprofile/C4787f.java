package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4809aa;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.f */
/* loaded from: classes.dex */
class C4787f implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f17507a;

    C4787f(BirthdayFragment birthdayFragment) {
        this.f17507a = birthdayFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (C4809aa.m18104a().m18119a("birthday_show", (Boolean) true).booleanValue()) {
                this.f17507a.f17079d = "FULL";
            } else {
                this.f17507a.f17079d = "FULL_HIDE";
            }
            this.f17507a.m17802b();
        } else {
            if (C4809aa.m18104a().m18119a("birthday_show", (Boolean) true).booleanValue()) {
                this.f17507a.f17079d = "SHORT";
            } else {
                this.f17507a.f17079d = "SHORT_HIDE";
            }
            this.f17507a.m17803c();
        }
        this.f17507a.m17801a(this.f17507a.f17079d);
    }
}
