package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.t */
/* loaded from: classes.dex */
class C0509t implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3201a;

    C0509t(ActivitySettings activitySettings) {
        this.f3201a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f3201a.f2999f, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "Help");
        this.f3201a.startActivity(intent);
        return true;
    }
}
