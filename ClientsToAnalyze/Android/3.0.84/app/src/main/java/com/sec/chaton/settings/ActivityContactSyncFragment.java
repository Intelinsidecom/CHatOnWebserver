package com.sec.chaton.settings;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.PreferenceListFragment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityContactSyncFragment extends PreferenceListFragment {

    /* renamed from: a */
    boolean f8947a;

    /* renamed from: c */
    private SyncStatePreference f8949c;

    /* renamed from: d */
    private CheckBoxPreference f8950d;

    /* renamed from: f */
    private List<Preference> f8952f;

    /* renamed from: b */
    private String f8948b = getClass().getSimpleName();

    /* renamed from: e */
    private C3160ab f8951e = null;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3250y.m11453c("[LIFE] onCreate Memory Address:" + this, getClass().getSimpleName());
        this.f8951e = C3159aa.m10962a();
        if (this.f8951e.m10977a("contact_sim_sync", (Boolean) false).booleanValue()) {
            this.f8947a = true;
            this.f8951e.m10983b("contact_sim_sync", (Boolean) true);
        } else {
            this.f8947a = false;
            this.f8951e.m10983b("contact_sim_sync", (Boolean) false);
        }
        this.f8952f = m8953a();
        m13132a(this.f8952f);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C3225cm.m11337a(getActivity());
        BaseActivity.m3081a(this, true);
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume Memory Address:" + this, getClass().getSimpleName());
        this.f8949c.m9211a();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause Memory Address:" + this, getClass().getSimpleName());
        this.f8949c.m9212b();
    }

    /* renamed from: a */
    private List<Preference> m8953a() {
        ArrayList arrayList = new ArrayList();
        if (C1493a.m6463a("support_contact_auto_sync")) {
            CheckBoxPreference checkBoxPreference = new CheckBoxPreference(getActivity());
            checkBoxPreference.setTitle(getResources().getString(R.string.contact_auto_sync));
            if (this.f8951e.m10977a("auto_contact_sync", (Boolean) true).booleanValue()) {
                checkBoxPreference.setChecked(true);
            } else {
                checkBoxPreference.setChecked(false);
            }
            checkBoxPreference.setOnPreferenceChangeListener(new C2722t(this));
            checkBoxPreference.setOnPreferenceClickListener(new C2833u(this));
            arrayList.add(checkBoxPreference);
        }
        this.f8950d = new CheckBoxPreference(getActivity());
        this.f8950d.setTitle(getResources().getString(R.string.sync_sim_contact));
        this.f8950d.setChecked(this.f8947a);
        this.f8950d.setOnPreferenceChangeListener(new C2834v(this));
        this.f8950d.setOnPreferenceClickListener(new C2835w(this));
        if (!C1493a.m6463a("for_wifi_only_device")) {
            arrayList.add(this.f8950d);
        }
        this.f8949c = new SyncStatePreference(getActivity(), null);
        if (C1493a.m6463a("support_contact_auto_sync")) {
            this.f8949c.setTitle(R.string.contact_manual_sync);
            this.f8949c.setSummary(m8955b());
        } else {
            this.f8949c.setTitle(R.string.buddy_contact_sync);
            this.f8949c.setSummary(m8956c());
        }
        this.f8949c.setOnPreferenceChangeListener(new C2836x(this));
        this.f8949c.setOnPreferenceClickListener(new C2837y(this));
        arrayList.add(this.f8949c);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m8955b() {
        StringBuilder sb = new StringBuilder();
        long jLongValue = Long.valueOf(C3159aa.m10962a().m10979a("Setting Sync TimeInMillis", "0")).longValue();
        if (jLongValue == 0) {
            sb.append(getResources().getString(R.string.settings_sync_contacts_not_synced_yet));
        } else {
            sb.append(getResources().getString(R.string.setting_contact_latest_sync) + ": ").append(DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(jLongValue))).append(" ").append(DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(jLongValue)));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m8956c() {
        long jLongValue = Long.valueOf(C3159aa.m10962a().m10979a("Setting Sync TimeInMillis", "0")).longValue();
        if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
            return getResources().getString(R.string.setting_sync_now_text);
        }
        if (jLongValue == 0) {
            return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.settings_sync_contacts_not_synced_yet);
        }
        return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.setting_contact_latest_sync) + ": " + DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(jLongValue)) + " " + DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(jLongValue));
    }
}
