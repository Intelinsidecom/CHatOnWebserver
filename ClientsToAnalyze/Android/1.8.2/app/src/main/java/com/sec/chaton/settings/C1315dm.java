package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dm */
/* loaded from: classes.dex */
class C1315dm implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4890a;

    C1315dm(SettingFragment settingFragment) {
        this.f4890a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4890a.f4737o = new C0638j(this.f4890a.f4742t);
        this.f4890a.f4737o.m2895a();
        this.f4890a.f4738p = ProgressDialogC1806j.m6141a(SettingFragment.f4730l, null, this.f4890a.getResources().getString(R.string.wait_sending), true);
        for (Preference preference2 : this.f4890a.f4732d.values()) {
            if (preference2.getKey().equals(preference.getKey())) {
                this.f4890a.m4714a(((Preference) this.f4890a.f4732d.get(preference.getKey())).getTitle().toString(), (Preference) this.f4890a.f4732d.get(preference.getKey()), this.f4890a.getResources().getColor(R.color.ics_orange_font_color));
            } else {
                this.f4890a.m4714a(preference2.getTitle().toString(), preference2, this.f4890a.getResources().getColor(R.color.black));
            }
        }
        return true;
    }
}
