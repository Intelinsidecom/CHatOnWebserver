package com.sec.chaton.localbackup;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.noti.C1653a;
import com.sec.chaton.settings.BasePreferenceActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ActivityLocalBackup extends BasePreferenceActivity {

    /* renamed from: a */
    private static final String f5943a = ActivityLocalBackup.class.getSimpleName();

    /* renamed from: b */
    private C3160ab f5944b = null;

    /* renamed from: c */
    private Context f5945c;

    /* renamed from: d */
    private CheckBoxPreference f5946d;

    /* renamed from: e */
    private Preference f5947e;

    /* renamed from: f */
    private Preference f5948f;

    /* renamed from: g */
    private Dialog f5949g;

    /* renamed from: h */
    private boolean f5950h;

    /* renamed from: i */
    private boolean f5951i;

    /* renamed from: j */
    private Dialog f5952j;

    /* renamed from: k */
    private AsyncTaskC1646h f5953k;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        addPreferencesFromResource(R.xml.setting_localbackup);
        this.f5944b = C3159aa.m10962a();
        this.f5944b.m10983b("Lock Check", (Boolean) false);
        this.f5945c = this;
        this.f5950h = true;
        try {
            m6795c();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f5953k != null) {
            this.f5953k.cancel(true);
            C3641ai.m13210a(this.f5945c, R.string.backup_failed, 1).show();
        }
        this.f5950h = false;
        super.onDestroy();
    }

    /* renamed from: a */
    private void m6791a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: c */
    private void m6795c() {
        this.f5946d = (CheckBoxPreference) findPreference("pref_auto_backup");
        this.f5946d.setOnPreferenceChangeListener(new C1615c(this));
        this.f5947e = findPreference("pref_backup_now");
        this.f5947e.setOnPreferenceClickListener(new C1640d(this));
        this.f5948f = findPreference("pref_setting_backup");
        this.f5948f.setOnPreferenceClickListener(new C1643e(this));
        findPreference("pref_view_backedup").setOnPreferenceClickListener(new C1644f(this));
        if (this.f5944b.m10977a("auto_backup_on", (Boolean) false).booleanValue()) {
            this.f5946d.setEnabled(true);
            this.f5946d.setChecked(true);
            this.f5947e.setEnabled(true);
            m6791a(getString(R.string.auto_backup), this.f5946d, getResources().getColor(R.color.color2));
            m6791a(getString(R.string.backup_now), this.f5947e, getResources().getColor(R.color.color2));
        }
        if (!this.f5944b.m10977a("setting_backup_enable", (Boolean) false).booleanValue()) {
            m6806a(false, true);
        } else {
            this.f5948f.setSummary(this.f5945c.getResources().getString(R.string.setup_change_description));
        }
        this.f5946d.setSummary(String.format(this.f5945c.getString(R.string.auto_backup_description_am), 1));
        m6805a();
    }

    /* renamed from: a */
    public void m6805a() {
        if (this.f5950h && this.f5947e != null) {
            this.f5947e.setSummary(this.f5945c.getResources().getString(R.string.last_backup) + " : " + C3159aa.m10962a().m10979a("backup_last_modified", ""));
        }
    }

    /* renamed from: a */
    public void m6806a(boolean z, boolean z2) {
        if (z) {
            Intent intent = new Intent(this.f5945c, (Class<?>) ActivitySecretKey.class);
            intent.putExtra("password_mode", true);
            startActivityForResult(intent, 0);
            return;
        }
        this.f5944b.m10983b("setting_backup_enable", (Boolean) false);
        this.f5946d.setEnabled(false);
        this.f5946d.setChecked(false);
        m6791a(getString(R.string.auto_backup), this.f5946d, getResources().getColor(R.color.setting_explain_text));
        this.f5944b.m10983b("auto_backup_on", (Boolean) false);
        this.f5947e.setEnabled(false);
        m6791a(getString(R.string.backup_now), this.f5947e, getResources().getColor(R.color.setting_explain_text));
        if (!z2) {
            C1653a.m6925a(this.f5945c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6798d() {
        if (this.f5952j == null) {
            this.f5952j = AbstractC3271a.m11494a(this.f5945c).mo11495a(R.string.backup).mo11506b(R.string.unable_backup_sdcard).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1645g(this)).mo11505a().mo11517a();
            this.f5952j.setCancelable(false);
        }
        if (this.f5952j != null) {
            this.f5952j.show();
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    this.f5944b.m10983b("setting_backup_enable", (Boolean) true);
                    this.f5946d.setEnabled(true);
                    this.f5947e.setEnabled(true);
                    m6791a(getString(R.string.auto_backup), this.f5946d, getResources().getColor(R.color.color2));
                    m6791a(getString(R.string.backup_now), this.f5947e, getResources().getColor(R.color.color2));
                    this.f5948f.setSummary(this.f5945c.getResources().getString(R.string.setup_change_description));
                    C3641ai.m13210a(this.f5945c, R.string.password_set_notice, 1).show();
                    break;
                } else if (i2 == 0) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6799e() {
        if (this.f5949g == null) {
            this.f5949g = new C3263j(this.f5945c).m11487a(R.string.setting_webview_please_wait);
            this.f5949g.setCancelable(false);
        }
        if (this.f5949g != null) {
            this.f5949g.show();
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6801f() {
        this.f5953k = new AsyncTaskC1646h(this, null);
        C3250y.m11450b("[File encryption] start " + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT < 11) {
            this.f5953k.execute(new Void[0]);
        } else {
            this.f5953k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
