package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.dq */
/* loaded from: classes.dex */
class C1319dq implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f4894a;

    C1319dq(SuggestionsActivity suggestionsActivity) {
        this.f4894a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f4894a.f4746d = false;
            this.f4894a.f4743a.putBoolean("recomned_special", false);
        } else {
            this.f4894a.f4746d = true;
            this.f4894a.f4743a.putBoolean("recomned_special", true);
        }
        this.f4894a.f4743a.commit();
        return true;
    }
}
