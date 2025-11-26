package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.s */
/* loaded from: classes.dex */
class C1340s implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f4916a;

    C1340s(ActivityGeneral activityGeneral) {
        this.f4916a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent();
        intent.putExtra(FragmentWebView.PARAM_MENU, "Noti");
        FragmentWebView fragmentWebView = new FragmentWebView();
        fragmentWebView.setArguments(intent.getExtras());
        this.f4916a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentWebView, "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
