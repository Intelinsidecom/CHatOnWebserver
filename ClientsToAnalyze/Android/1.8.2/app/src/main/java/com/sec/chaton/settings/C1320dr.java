package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.dr */
/* loaded from: classes.dex */
class C1320dr implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f4895a;

    C1320dr(SuggestionsActivity suggestionsActivity) {
        this.f4895a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f4895a.f4747e = false;
            this.f4895a.f4743a.putBoolean("exclude_me", false);
            this.f4895a.f4749g.m2874c(false);
            this.f4895a.f4753k.show();
        } else {
            this.f4895a.f4747e = true;
            this.f4895a.f4743a.putBoolean("exclude_me", true);
            this.f4895a.f4749g.m2874c(true);
            this.f4895a.f4753k.show();
        }
        this.f4895a.f4743a.commit();
        return true;
    }
}
