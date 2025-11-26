package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: SyncStatePreference.java */
/* renamed from: com.sec.chaton.settings.gi */
/* loaded from: classes.dex */
class C3656gi implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f13230a;

    /* renamed from: b */
    final /* synthetic */ SyncStatePreference f13231b;

    C3656gi(SyncStatePreference syncStatePreference, Context context) {
        this.f13231b = syncStatePreference;
        this.f13230a = context;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C4904y.m18639b("pref_item_sync_now", "SyncStatePreference");
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f13230a, R.string.trunk_network_not_available, 0).show();
            return false;
        }
        C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
        C1002i.m6059a(true);
        return true;
    }
}
