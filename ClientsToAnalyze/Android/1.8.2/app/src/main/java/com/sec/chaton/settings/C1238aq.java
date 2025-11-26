package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.util.C1781m;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.aq */
/* loaded from: classes.dex */
class C1238aq implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f4779a;

    C1238aq(ActivityPrivacy activityPrivacy) {
        this.f4779a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f4779a.f4556o[this.f4779a.f4557p].equals(C1781m.m6025c())) {
            Intent intent = new Intent(this.f4779a.getActivity(), (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "PRIVACY");
            this.f4779a.startActivityForResult(intent, 3);
            return false;
        }
        this.f4779a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentPasswordLockView(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        return false;
    }
}
