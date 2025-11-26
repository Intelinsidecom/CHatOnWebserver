package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.widget.C1805i;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.am */
/* loaded from: classes.dex */
class C1234am implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f4775a;

    C1234am(ActivityPrivacy activityPrivacy) {
        this.f4775a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        C0633e c0633e = new C0633e(this.f4775a.f4558q);
        this.f4775a.f4552k = (ProgressDialog) new C1805i(this.f4775a.getActivity()).m6139a(R.string.dialog_userprofile_updating);
        if (obj != null && "true".equals(str)) {
            c0633e.m2870b(true);
            this.f4775a.f4552k.show();
            this.f4775a.f4553l = true;
        } else {
            c0633e.m2870b(false);
            this.f4775a.f4552k.show();
            this.f4775a.f4553l = false;
        }
        return true;
    }
}
