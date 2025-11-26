package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.C1341p;

/* compiled from: PreferenceBirthdayCheckbox.java */
/* renamed from: com.sec.chaton.settings.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC1093y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PreferenceBirthdayCheckbox f3739a;

    ViewOnClickListenerC1093y(PreferenceBirthdayCheckbox preferenceBirthdayCheckbox) {
        this.f3739a = preferenceBirthdayCheckbox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3739a.setChecked(!this.f3739a.isChecked());
        C1341p.m4658b("onBindView...onClick. // isChecked() = " + this.f3739a.isChecked(), getClass().getSimpleName());
        if (this.f3739a.isChecked()) {
            this.f3739a.f3572d = true;
            this.f3739a.f3570b.putBoolean("Profile Birth Chk", true).commit();
        } else {
            this.f3739a.f3572d = false;
            this.f3739a.f3570b.putBoolean("Profile Birth Chk", false).commit();
        }
        this.f3739a.setChecked(this.f3739a.f3572d);
    }
}
