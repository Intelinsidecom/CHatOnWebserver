package com.sec.chaton.settings;

import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.Preference;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.ay */
/* loaded from: classes.dex */
class C0476ay implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3167a;

    C0476ay(ActivitySettings activitySettings) {
        this.f3167a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        Uri uri;
        if (obj == null) {
            uri = null;
        } else if (obj.toString().equals("")) {
            this.f3167a.f2995b.putString("Ringtone", "Silent").commit();
            uri = null;
        } else {
            this.f3167a.f2995b.putString("Ringtone", obj.toString()).commit();
            uri = Uri.parse(obj.toString());
        }
        String title = (uri == null || RingtoneManager.getRingtone(this.f3167a.f2999f, uri) == null) ? "Silent" : RingtoneManager.getRingtone(this.f3167a.f2999f, uri).getTitle(this.f3167a.f2999f);
        this.f3167a.f3010q.setSummary(title);
        this.f3167a.m3133a(title, this.f3167a.f3010q, this.f3167a.getResources().getColor(C0062R.color.blue_color_021));
        return true;
    }
}
