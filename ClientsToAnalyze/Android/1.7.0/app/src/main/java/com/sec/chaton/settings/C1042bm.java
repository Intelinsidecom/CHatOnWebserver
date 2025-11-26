package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bm */
/* loaded from: classes.dex */
class C1042bm implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f3653a;

    C1042bm(ActivityPrivacy activityPrivacy) {
        this.f3653a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        int iM2878a = C0633m.m2878a(this.f3653a.getContentResolver());
        C1341p.m4662e("Buddy count: " + iM2878a, "Settings");
        if (iM2878a <= 0) {
            if (this.f3653a.f3464n != null) {
                this.f3653a.f3464n.setText(R.string.chat_title_no_buddies);
            } else {
                this.f3653a.f3464n = C1619g.m5889a(this.f3653a.f3454d, this.f3653a.getResources().getString(R.string.chat_title_no_buddies), 0);
            }
            this.f3653a.f3464n.show();
            return false;
        }
        this.f3653a.f3460j.m862a();
        this.f3653a.f3463m = ProgressDialogC1354a.m4724a(this.f3653a.f3454d, null, this.f3653a.getResources().getString(R.string.dialog_connecting_server), true);
        return true;
    }
}
