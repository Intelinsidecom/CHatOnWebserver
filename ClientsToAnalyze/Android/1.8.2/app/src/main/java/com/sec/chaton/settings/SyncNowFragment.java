package com.sec.chaton.settings;

import android.os.Bundle;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.PreferenceListFragment;

/* loaded from: classes.dex */
public class SyncNowFragment extends PreferenceListFragment {

    /* renamed from: a */
    SyncStatePreference f4755a;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_sync);
        try {
            m4729a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    private void m4729a() {
        this.f4755a = (SyncStatePreference) m6121a("pref_item_sync_now_text");
        m4730a(getResources().getString(R.string.setting_sync_now_text), this.f4755a, getResources().getColor(R.color.ics_orange_font_color));
        this.f4755a.setOnPreferenceClickListener(new C1322dt(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f4755a.m4737b();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f4755a.m4736a();
    }

    /* renamed from: a */
    private void m4730a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }
}
