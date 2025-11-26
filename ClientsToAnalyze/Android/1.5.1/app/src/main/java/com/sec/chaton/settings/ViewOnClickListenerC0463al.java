package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.settings.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC0463al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PreferenceBirthdayCheckbox f3155a;

    ViewOnClickListenerC0463al(PreferenceBirthdayCheckbox preferenceBirthdayCheckbox) {
        this.f3155a = preferenceBirthdayCheckbox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3155a.setChecked(!this.f3155a.isChecked());
        ChatONLogWriter.m3506b("onBindView...onClick. // isChecked() = " + this.f3155a.isChecked(), getClass().getSimpleName());
        if (this.f3155a.isChecked()) {
            this.f3155a.f3093d = true;
            this.f3155a.f3091b.putBoolean("Profile Birth Chk", true).commit();
        } else {
            this.f3155a.f3093d = false;
            this.f3155a.f3091b.putBoolean("Profile Birth Chk", false).commit();
        }
        this.f3155a.setChecked(this.f3155a.f3093d);
    }
}
