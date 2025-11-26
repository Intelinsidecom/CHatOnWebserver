package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.al */
/* loaded from: classes.dex */
class C2424al implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f9284a;

    C2424al(ActivityGeneral activityGeneral) {
        this.f9284a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f9284a.f8970c, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "Help");
        intent.putExtra(FragmentWebView.SHOW_BREADCRUMB, true);
        this.f9284a.startActivity(intent);
        return true;
    }
}
