package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: PreferenceBirthdayCheckbox.java */
/* renamed from: com.sec.chaton.settings.cv */
/* loaded from: classes.dex */
class ViewOnClickListenerC1297cv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PreferenceBirthdayCheckbox f4852a;

    ViewOnClickListenerC1297cv(PreferenceBirthdayCheckbox preferenceBirthdayCheckbox) {
        this.f4852a = preferenceBirthdayCheckbox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4852a.setChecked(!this.f4852a.isChecked());
        C1786r.m6061b("onBindView...onClick. // isChecked() = " + this.f4852a.isChecked(), getClass().getSimpleName());
        if (this.f4852a.isChecked()) {
            this.f4852a.f4700d = true;
            this.f4852a.f4698b.putBoolean("Profile Birth Chk", true).commit();
        } else {
            this.f4852a.f4700d = false;
            this.f4852a.f4698b.putBoolean("Profile Birth Chk", false).commit();
        }
        this.f4852a.setChecked(this.f4852a.f4700d);
    }
}
