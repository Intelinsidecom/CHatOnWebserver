package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityDownloads extends PreferenceListFragment {

    /* renamed from: c */
    AboutNewNotice f4483c;

    /* renamed from: d */
    private Context f4484d;

    /* renamed from: f */
    private Toast f4486f;

    /* renamed from: a */
    String f4481a = "Settings";

    /* renamed from: e */
    private SharedPreferences f4485e = null;

    /* renamed from: b */
    SharedPreferences.Editor f4482b = null;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_downloads);
        this.f4484d = getActivity();
        this.f4486f = new Toast(this.f4484d);
        this.f4485e = C1789u.m6075a();
        this.f4482b = this.f4485e.edit();
        this.f4482b.putBoolean("Lock Check", false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m4500a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m4500a() throws Resources.NotFoundException {
        this.f4483c = (AboutNewNotice) m6121a("pref_item_downloads_chaton_v");
        if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
            this.f4483c.setOnPreferenceClickListener(new C1338q(this));
        } else {
            String string = this.f4483c.getTitle().toString();
            int color = getResources().getColor(R.color.setting_explain_text);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(color), 0, string.length(), 0);
            this.f4483c.setTitle(spannableString);
        }
        m6121a("pref_item_downloads_ticcon").setOnPreferenceClickListener(new C1339r(this));
    }

    /* renamed from: b */
    private void m4501b() {
        if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
            this.f4483c.m4481a(true);
        } else {
            this.f4483c.m4481a(false);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4501b();
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
    }
}
