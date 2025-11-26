package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.util.C1786r;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.ap */
/* loaded from: classes.dex */
class C1237ap implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f4778a;

    C1237ap(ActivityPrivacy activityPrivacy) {
        this.f4778a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        int iM2971a = C0657a.m2971a(this.f4778a.f4546e.getContentResolver());
        C1786r.m6066e("Buddy count: " + iM2971a, "Settings");
        if (iM2971a <= 0) {
            Toast.makeText(this.f4778a.f4546e, this.f4778a.getResources().getString(R.string.buddy_list_search_noresult), 0).show();
            return false;
        }
        Intent intent = new Intent(this.f4778a.f4546e, (Class<?>) BuddiesSaySettings.class);
        intent.putExtra("BUDDY_SORT_STYLE", 11);
        intent.putExtra("ACTIVITY_PURPOSE", 9);
        this.f4778a.startActivity(intent);
        return true;
    }
}
