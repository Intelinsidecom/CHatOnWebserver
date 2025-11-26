package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.t */
/* loaded from: classes.dex */
class C1341t implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f4917a;

    C1341t(ActivityGeneral activityGeneral) {
        this.f4917a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent();
        intent.putExtra(FragmentWebView.PARAM_MENU, "Help");
        FragmentWebView fragmentWebView = new FragmentWebView();
        fragmentWebView.setArguments(intent.getExtras());
        this.f4917a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentWebView, "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
