package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.am */
/* loaded from: classes.dex */
class C2425am implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f9285a;

    C2425am(ActivityGeneral activityGeneral) {
        this.f9285a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f9285a.f8970c, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "VOC");
        intent.putExtra(FragmentWebView.SHOW_BREADCRUMB, true);
        this.f9285a.startActivity(intent);
        return true;
    }
}
