package com.sec.chaton.settings;

import android.app.AlarmManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0224w;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ActivityPrivacy extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    AlarmManager f3453c;

    /* renamed from: d */
    private Context f3454d;

    /* renamed from: f */
    private C1056c f3456f;

    /* renamed from: g */
    private String[] f3457g;

    /* renamed from: h */
    private String[] f3458h;

    /* renamed from: i */
    private String f3459i;

    /* renamed from: j */
    private C0224w f3460j;

    /* renamed from: m */
    private ProgressDialog f3463m;

    /* renamed from: a */
    String f3451a = "Settings";

    /* renamed from: e */
    private SharedPreferences f3455e = null;

    /* renamed from: b */
    SharedPreferences.Editor f3452b = null;

    /* renamed from: k */
    private ArrayList f3461k = new ArrayList();

    /* renamed from: l */
    private ArrayList f3462l = new ArrayList();

    /* renamed from: n */
    private Toast f3464n = null;

    /* renamed from: o */
    private Handler f3465o = new HandlerC1041bl(this);

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.layout_setting_privacy);
        this.f3454d = this;
        this.f3455e = C1323bs.m4575a();
        this.f3456f = new C1056c(this.f3455e);
        this.f3452b = this.f3455e.edit();
        this.f3452b.putBoolean("Lock Check", false);
        this.f3453c = (AlarmManager) this.f3454d.getSystemService("alarm");
        this.f3457g = this.f3454d.getResources().getStringArray(R.array.settings_type_options_value);
        this.f3458h = this.f3454d.getResources().getStringArray(R.array.settings_type_options);
        this.f3460j = new C0224w(this.f3465o);
        getListView().setScrollingCacheEnabled(false);
        try {
            m3809b();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
        if (bundle != null && bundle.containsKey("old_blind_list")) {
            this.f3461k = bundle.getStringArrayList("old_blind_list");
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("old_blind_list", this.f3461k);
    }

    /* renamed from: b */
    private void m3809b() {
        this.f3459i = C1323bs.m4575a().getString("msisdn", "");
        findPreference("phone_number_privacy").setOnPreferenceClickListener(new C1040bk(this));
        findPreference("pref_item_hide").setOnPreferenceClickListener(new C1039bj(this));
        findPreference("pref_item_buddies_say").setOnPreferenceClickListener(new C1042bm(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                    if (uri != null) {
                        this.f3452b.putString("Ringtone", uri.toString()).commit();
                        break;
                    } else {
                        this.f3452b.putString("Ringtone", "Ringtone").commit();
                        break;
                    }
                case 10:
                    if (i == 10 && i2 == -1) {
                        C1341p.m4662e("Get blind list from user", getClass().getSimpleName());
                        String[] stringArrayExtra = intent.getStringArrayExtra("blindlist");
                        this.f3462l.clear();
                        for (String str : stringArrayExtra) {
                            this.f3462l.add(str);
                        }
                        m3814a();
                        if (this.f3461k.size() != 0 || this.f3462l.size() != 0) {
                            this.f3460j.m867a(this.f3461k, this.f3462l);
                            this.f3463m = ProgressDialogC1354a.m4724a(this.f3454d, null, getResources().getString(R.string.wait_sending), true);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m3814a() {
        String str = getClass().getSimpleName() + " - getBlindListToSet()";
        Iterator it = this.f3461k.iterator();
        while (it.hasNext()) {
            C1341p.m4662e("[mBlindOldList] " + ((String) it.next()), str);
        }
        Iterator it2 = this.f3462l.iterator();
        while (it2.hasNext()) {
            C1341p.m4662e("[mBlindNewList] " + ((String) it2.next()), str);
        }
        for (int i = 0; i < this.f3462l.size(); i++) {
            String str2 = (String) this.f3462l.get(i);
            if (this.f3461k.remove(str2)) {
                this.f3462l.remove(str2);
            }
        }
        Iterator it3 = this.f3461k.iterator();
        while (it3.hasNext()) {
            C1341p.m4662e("[1st mBlindOldList] " + ((String) it3.next()), str);
        }
        Iterator it4 = this.f3462l.iterator();
        while (it4.hasNext()) {
            C1341p.m4662e("[1st mBlindNewList] " + ((String) it4.next()), str);
        }
        for (int i2 = 0; i2 < this.f3461k.size(); i2++) {
            String str3 = (String) this.f3461k.get(i2);
            if (this.f3462l.remove(str3)) {
                this.f3461k.remove(str3);
            }
        }
        Iterator it5 = this.f3461k.iterator();
        while (it5.hasNext()) {
            C1341p.m4662e("[2nd mBlindOldList] " + ((String) it5.next()), str);
        }
        Iterator it6 = this.f3462l.iterator();
        while (it6.hasNext()) {
            C1341p.m4662e("[2nd mBlindNewList] " + ((String) it6.next()), str);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (this.f3463m != null) {
            this.f3463m.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
