package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.spam.SetupSpamNumberList;

/* compiled from: SpamSettingActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.iw */
/* loaded from: classes.dex */
class C4330iw implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SpamSettingActivity f15741a;

    C4330iw(SpamSettingActivity spamSettingActivity) {
        this.f15741a = spamSettingActivity;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f15741a.startActivity(new Intent(GlobalApplication.m18732r(), (Class<?>) SetupSpamNumberList.class));
        return true;
    }
}
