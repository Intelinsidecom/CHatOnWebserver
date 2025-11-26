package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.dp */
/* loaded from: classes.dex */
class C1318dp implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f4893a;

    C1318dp(SuggestionsActivity suggestionsActivity) {
        this.f4893a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f4893a.f4745c = false;
            this.f4893a.f4743a.putBoolean("recomned_receive", false);
            this.f4893a.f4749g.m2878d(false);
            this.f4893a.f4753k.show();
        } else {
            this.f4893a.f4745c = true;
            this.f4893a.f4743a.putBoolean("recomned_receive", true);
            this.f4893a.f4749g.m2878d(true);
            this.f4893a.f4753k.show();
        }
        this.f4893a.f4743a.commit();
        return true;
    }
}
