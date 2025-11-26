package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.gf */
/* loaded from: classes.dex */
class C3653gf implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f13227a;

    C3653gf(SuggestionsActivity suggestionsActivity) {
        this.f13227a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f13227a.f12828a, R.string.popup_no_network_connection, 0).show();
            return false;
        }
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f13227a.f12830c.m9532g(false);
            this.f13227a.f12834g.show();
            return true;
        }
        this.f13227a.f12830c.m9532g(true);
        this.f13227a.f12834g.show();
        return true;
    }
}
