package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.fi */
/* loaded from: classes.dex */
class C2699fi implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f9995a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f9996b;

    C2699fi(SyncStatePreference syncStatePreference, Context context) {
        this.f9996b = syncStatePreference;
        this.f9995a = context;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C3250y.m11450b("pref_item_sync_now", "SyncStatePreference");
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f9995a, R.string.trunk_network_not_available, 0).show();
            return false;
        }
        C0423i.m3039a(true);
        return true;
    }
}
