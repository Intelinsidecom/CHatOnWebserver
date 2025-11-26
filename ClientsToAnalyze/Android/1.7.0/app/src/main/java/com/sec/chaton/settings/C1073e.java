package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.e */
/* loaded from: classes.dex */
class C1073e implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3717a;

    private C1073e(C1057ca c1057ca) {
        this.f3717a = c1057ca;
    }

    /* synthetic */ C1073e(C1057ca c1057ca, C1069cm c1069cm) {
        this(c1057ca);
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        Intent intent = new Intent(this.f3717a.getActivity(), (Class<?>) this.f3717a.f3686c.get(key));
        if ("pref_item_help".equals(key)) {
            intent.putExtra(FragmentWebView.PARAM_MENU, "Help");
        }
        ((BaseActivity) this.f3717a.getActivity()).mo2044a(intent);
        for (Preference preference2 : this.f3717a.f3687d.values()) {
            if (preference2.getKey().equals(key)) {
                this.f3717a.m3950a(((Preference) this.f3717a.f3687d.get(key)).getTitle().toString(), (Preference) this.f3717a.f3687d.get(key), this.f3717a.getResources().getColor(R.color.blue_color_021));
            } else {
                this.f3717a.m3950a(preference2.getTitle().toString(), preference2, this.f3717a.getResources().getColor(R.color.black));
            }
        }
        return true;
    }
}
