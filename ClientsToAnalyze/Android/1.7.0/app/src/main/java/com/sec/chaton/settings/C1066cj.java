package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0224w;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.cj */
/* loaded from: classes.dex */
class C1066cj implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3711a;

    C1066cj(C1057ca c1057ca) {
        this.f3711a = c1057ca;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3711a.f3693p = new C0224w(this.f3711a.f3698u);
        this.f3711a.f3693p.m862a();
        this.f3711a.f3694q = ProgressDialogC1354a.m4724a(C1057ca.f3685m, null, this.f3711a.getResources().getString(R.string.wait_sending), true);
        for (Preference preference2 : this.f3711a.f3687d.values()) {
            if (preference2.getKey().equals(preference.getKey())) {
                this.f3711a.m3950a(((Preference) this.f3711a.f3687d.get(preference.getKey())).getTitle().toString(), (Preference) this.f3711a.f3687d.get(preference.getKey()), this.f3711a.getResources().getColor(R.color.blue_color_021));
            } else {
                this.f3711a.m3950a(preference2.getTitle().toString(), preference2, this.f3711a.getResources().getColor(R.color.black));
            }
        }
        return true;
    }
}
