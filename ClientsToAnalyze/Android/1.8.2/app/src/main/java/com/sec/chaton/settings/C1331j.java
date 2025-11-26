package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.j */
/* loaded from: classes.dex */
class C1331j implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f4907a;

    C1331j(ActivityChat activityChat) {
        this.f4907a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        FragmentSkinChange2 fragmentSkinChange2 = new FragmentSkinChange2();
        Bundle bundle = new Bundle();
        bundle.putString("change_mode", "change_bubble");
        fragmentSkinChange2.setArguments(bundle);
        Intent intent = new Intent(this.f4907a.getActivity(), (Class<?>) ChatSettingsActivity.class);
        intent.putExtras(bundle);
        intent.setFlags(65536);
        this.f4907a.startActivity(intent);
        return true;
    }
}
