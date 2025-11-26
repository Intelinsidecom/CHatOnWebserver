package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.account.C0239h;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.cb */
/* loaded from: classes.dex */
class C1058cb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3699a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f3700b;

    C1058cb(SyncStatePreference syncStatePreference, Context context) {
        this.f3700b = syncStatePreference;
        this.f3699a = context;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C1341p.m4658b("pref_item_sync_now", "SyncStatePreference");
        if (C1336k.m4637n()) {
            C0239h.m908a(true);
            return true;
        }
        C1619g.m5888a(this.f3699a, R.string.trunk_network_not_available, 0).show();
        return false;
    }
}
