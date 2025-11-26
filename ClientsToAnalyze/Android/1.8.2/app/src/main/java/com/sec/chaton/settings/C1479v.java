package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.v */
/* loaded from: classes.dex */
class C1479v implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f5399a;

    C1479v(ActivityGeneral activityGeneral) {
        this.f5399a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent();
        intent.putExtra(FragmentWebView.PARAM_MENU, "VOC");
        FragmentWebView fragmentWebView = new FragmentWebView();
        fragmentWebView.setArguments(intent.getExtras());
        this.f5399a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentWebView, "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
