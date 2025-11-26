package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.util.C3159aa;

/* compiled from: BirthdayImpl.java */
/* renamed from: com.sec.chaton.userprofile.k */
/* loaded from: classes.dex */
class C3142k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C3137f f11398a;

    C3142k(C3137f c3137f) {
        this.f11398a = c3137f;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f11398a.f11385n.setClickable(true);
        if (z) {
            if (C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11398a.f11375d = "FULL";
            } else {
                this.f11398a.f11375d = "SHORT";
            }
        } else if (C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
            this.f11398a.f11375d = "FULL_HIDE";
        } else {
            this.f11398a.f11375d = "SHORT_HIDE";
        }
        this.f11398a.m10923a(this.f11398a.f11375d);
    }
}
