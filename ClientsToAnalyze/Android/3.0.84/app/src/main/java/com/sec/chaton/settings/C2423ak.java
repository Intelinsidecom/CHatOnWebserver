package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.ak */
/* loaded from: classes.dex */
class C2423ak implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f9283a;

    C2423ak(ActivityGeneral activityGeneral) {
        this.f9283a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f9283a.f8970c, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "Noti");
        intent.putExtra(FragmentWebView.SHOW_BREADCRUMB, true);
        this.f9283a.startActivity(intent);
        return true;
    }
}
