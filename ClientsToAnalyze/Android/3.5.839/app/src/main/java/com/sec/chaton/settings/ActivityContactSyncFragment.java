package com.sec.chaton.settings;

import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.PreferenceListFragment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityContactSyncFragment extends PreferenceListFragment {

    /* renamed from: i */
    boolean f12507i;

    /* renamed from: l */
    private SyncStatePreference f12510l;

    /* renamed from: m */
    private CheckBoxPreference f12511m;

    /* renamed from: o */
    private List<Preference> f12513o;

    /* renamed from: k */
    private String f12509k = getClass().getSimpleName();

    /* renamed from: n */
    private C4810ab f12512n = null;

    /* renamed from: j */
    Handler f12508j = new HandlerC3499aq(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4904y.m18641c("[LIFE] onCreate Memory Address:" + this, getClass().getSimpleName());
        this.f12512n = C4809aa.m18104a();
        if (this.f12512n.m18119a("contact_sim_sync", (Boolean) false).booleanValue()) {
            this.f12507i = true;
            this.f12512n.m18125b("contact_sim_sync", (Boolean) true);
        } else {
            this.f12507i = false;
            this.f12512n.m18125b("contact_sim_sync", (Boolean) false);
        }
        this.f12513o = m13385c();
        m19665a(this.f12513o);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C4875cm.m18511a(getActivity());
        BaseActivity.m6160a((Fragment) this, true);
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
        C4904y.m18641c("[LIFE] onResume Memory Address:" + this, getClass().getSimpleName());
        this.f12510l.m13697a();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause Memory Address:" + this, getClass().getSimpleName());
        this.f12510l.m13698b();
    }

    /* renamed from: c */
    private List<Preference> m13385c() {
        ArrayList arrayList = new ArrayList();
        if (C2349a.m10301a("support_contact_auto_sync")) {
            CheckBoxPreference checkBoxPreference = new CheckBoxPreference(getActivity());
            checkBoxPreference.setTitle(getResources().getString(R.string.contact_auto_sync));
            if (this.f12512n.m18119a("auto_contact_sync", (Boolean) true).booleanValue()) {
                checkBoxPreference.setChecked(true);
            } else {
                checkBoxPreference.setChecked(false);
            }
            checkBoxPreference.setOnPreferenceChangeListener(new C3493ak(this));
            checkBoxPreference.setOnPreferenceClickListener(new C3494al(this));
            arrayList.add(checkBoxPreference);
        }
        this.f12511m = new CheckBoxPreference(getActivity());
        this.f12511m.setTitle(getResources().getString(R.string.sync_sim_contact));
        this.f12511m.setChecked(this.f12507i);
        this.f12511m.setOnPreferenceChangeListener(new C3495am(this));
        this.f12511m.setOnPreferenceClickListener(new C3496an(this));
        if (!C2349a.m10301a("for_wifi_only_device")) {
            arrayList.add(this.f12511m);
        }
        this.f12510l = new SyncStatePreference(getActivity(), null);
        if (C2349a.m10301a("support_contact_auto_sync")) {
            this.f12510l.setTitle(R.string.contact_manual_sync);
            this.f12510l.setSummary(m13386d());
        } else {
            this.f12510l.setTitle(R.string.settings_sync_contact_list);
            this.f12510l.setSummary(m13389e());
        }
        this.f12510l.setOnPreferenceChangeListener(new C3497ao(this));
        this.f12510l.setOnPreferenceClickListener(new C3498ap(this));
        arrayList.add(this.f12510l);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m13386d() {
        StringBuilder sb = new StringBuilder();
        long jLongValue = Long.valueOf(C4809aa.m18104a().m18121a("Setting Sync TimeInMillis", Spam.ACTIVITY_CANCEL)).longValue();
        if (jLongValue == 0) {
            sb.append(getResources().getString(R.string.settings_sync_contacts_not_synced_yet));
        } else {
            sb.append(getResources().getString(R.string.setting_contact_latest_sync) + ": ").append(DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(jLongValue))).append(" ").append(DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(jLongValue)));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m13389e() {
        long jLongValue = Long.valueOf(C4809aa.m18104a().m18121a("Setting Sync TimeInMillis", Spam.ACTIVITY_CANCEL)).longValue();
        if (C2349a.m10301a("sms_feature")) {
            if (jLongValue == 0) {
                return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.settings_sync_contacts_not_synced_yet);
            }
            return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.setting_contact_latest_sync) + ": " + DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(jLongValue)) + " " + DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(jLongValue));
        }
        if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            return getResources().getString(R.string.setting_sync_now_text);
        }
        if (jLongValue == 0) {
            return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.settings_sync_contacts_not_synced_yet);
        }
        return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.setting_contact_latest_sync) + ": " + DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(jLongValue)) + " " + DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(jLongValue));
    }
}
