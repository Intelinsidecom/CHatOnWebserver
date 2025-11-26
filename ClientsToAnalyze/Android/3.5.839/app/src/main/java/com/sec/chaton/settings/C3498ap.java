package com.sec.chaton.settings;

import android.preference.Preference;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.ap */
/* loaded from: classes.dex */
class C3498ap implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12986a;

    C3498ap(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12986a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (C2349a.m10301a("sms_feature")) {
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f12986a.getActivity(), R.string.trunk_network_not_available, 0).show();
            } else {
                if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    C5179v.m19810a(this.f12986a.getActivity(), R.string.chaton_sms_buddy_sync_contact_list, 0).show();
                    C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
                    C1002i.m6059a(true);
                } else {
                    C5179v.m19810a(this.f12986a.getActivity(), R.string.chaton_sms_buddy_sync_contact_list, 0).show();
                    new C2128i(this.f12986a.f12508j).m9497a("localsms");
                }
                C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
                C1002i.m6059a(true);
            }
        } else if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f12986a.getActivity(), R.string.trunk_network_not_available, 0).show();
        } else {
            C5179v.m19810a(this.f12986a.getActivity(), R.string.chaton_sms_buddy_sync_contact_list, 0).show();
            C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
            C1002i.m6059a(true);
            C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
            C1002i.m6059a(true);
        }
        return false;
    }
}
