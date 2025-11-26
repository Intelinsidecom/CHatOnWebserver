package com.sec.chaton.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.preference.Preference;
import android.widget.Toast;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.util.C1786r;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.ba */
/* loaded from: classes.dex */
class C1249ba implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f4790a;

    C1249ba(ActivitySettings activitySettings) {
        this.f4790a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (AbstractC0521a.m2697a(this.f4790a.getActivity())) {
            try {
                this.f4790a.startActivity(new Intent("com.coolots.chaton.USER_SETTING"));
                return true;
            } catch (ActivityNotFoundException e) {
                C1786r.m6056a(e, getClass().getSimpleName());
                Toast.makeText(this.f4790a.getActivity(), "Install Coolots app first.", 0).show();
                return true;
            }
        }
        return true;
    }
}
