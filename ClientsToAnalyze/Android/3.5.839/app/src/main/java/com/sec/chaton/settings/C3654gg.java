package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.gg */
/* loaded from: classes.dex */
class C3654gg implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f13228a;

    C3654gg(SuggestionsActivity suggestionsActivity) {
        this.f13228a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f13228a.f12828a, R.string.popup_no_network_connection, 0).show();
            return false;
        }
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f13228a.f12830c.m9529f(true);
            this.f13228a.f12834g.show();
            return true;
        }
        this.f13228a.f12830c.m9529f(false);
        this.f13228a.f12834g.show();
        return true;
    }
}
