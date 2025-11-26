package com.sec.chaton.localbackup;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.localbackup.noti.C2555a;
import com.sec.chaton.settings.BasePreferenceActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ActivityLocalBackup extends BasePreferenceActivity {

    /* renamed from: a */
    private static final String f8983a = ActivityLocalBackup.class.getSimpleName();

    /* renamed from: b */
    private C4810ab f8984b = null;

    /* renamed from: c */
    private Context f8985c;

    /* renamed from: d */
    private CheckBoxPreference f8986d;

    /* renamed from: e */
    private Preference f8987e;

    /* renamed from: f */
    private Preference f8988f;

    /* renamed from: g */
    private Dialog f8989g;

    /* renamed from: h */
    private boolean f8990h;

    /* renamed from: i */
    private boolean f8991i;

    /* renamed from: j */
    private Dialog f8992j;

    /* renamed from: k */
    private Dialog f8993k;

    /* renamed from: l */
    private AsyncTaskC2550j f8994l;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        addPreferencesFromResource(R.xml.setting_localbackup);
        this.f8984b = C4809aa.m18104a();
        this.f8984b.m18125b("Lock Check", (Boolean) false);
        this.f8985c = this;
        this.f8990h = true;
        try {
            m10823c();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f8994l != null) {
            this.f8994l.cancel(true);
            C5179v.m19810a(this.f8985c, R.string.backup_failed, 1).show();
        }
        this.f8990h = false;
        super.onDestroy();
    }

    /* renamed from: a */
    private void m10818a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: c */
    private void m10823c() {
        this.f8986d = (CheckBoxPreference) findPreference("pref_auto_backup");
        this.f8986d.setOnPreferenceChangeListener(new C2517c(this));
        this.f8987e = findPreference("pref_backup_now");
        this.f8987e.setOnPreferenceClickListener(new C2542d(this));
        this.f8988f = findPreference("pref_setting_backup");
        this.f8988f.setOnPreferenceClickListener(new C2545e(this));
        findPreference("pref_view_backedup").setOnPreferenceClickListener(new C2546f(this));
        if (this.f8984b.m18119a("auto_backup_on", (Boolean) false).booleanValue()) {
            this.f8986d.setEnabled(true);
            this.f8986d.setChecked(true);
            this.f8987e.setEnabled(true);
            m10818a(getString(R.string.auto_backup), this.f8986d, getResources().getColor(R.color.color2));
            m10818a(getString(R.string.backup_now), this.f8987e, getResources().getColor(R.color.color2));
        }
        if (!this.f8984b.m18119a("setting_backup_enable", (Boolean) false).booleanValue()) {
            m10834a(false, true);
        } else {
            this.f8988f.setSummary(this.f8985c.getResources().getString(R.string.setup_change_description));
        }
        if (C4822an.m18218a() && C2349a.m10301a("sms_feature") && !C4809aa.m18104a().m18119a("backup_sms_popup", (Boolean) false).booleanValue()) {
            this.f8986d.setSummary(String.format(this.f8985c.getString(R.string.auto_backup_description_am_sms), 1));
        } else {
            this.f8986d.setSummary(String.format(this.f8985c.getString(R.string.auto_backup_description_am), 1));
        }
        m10833a();
    }

    /* renamed from: a */
    public void m10833a() {
        if (this.f8990h && this.f8987e != null) {
            if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("backup_last_modified", ""))) {
                this.f8987e.setSummary(this.f8985c.getResources().getString(R.string.last_backup) + " : ");
            } else if (C4822an.m18218a() && C2349a.m10301a("sms_feature") && !C4809aa.m18104a().m18119a("backup_sms_popup", (Boolean) false).booleanValue()) {
                this.f8987e.setSummary(this.f8985c.getResources().getString(R.string.last_backup) + " : " + C4809aa.m18104a().m18121a("backup_last_modified", "") + "\n" + this.f8985c.getResources().getString(R.string.backup_sms_guide));
            } else {
                this.f8987e.setSummary(this.f8985c.getResources().getString(R.string.last_backup) + " : " + C4809aa.m18104a().m18121a("backup_last_modified", ""));
            }
        }
    }

    /* renamed from: a */
    public void m10834a(boolean z, boolean z2) {
        if (z) {
            Intent intent = new Intent(this.f8985c, (Class<?>) ActivitySecretKey.class);
            intent.putExtra("password_mode", true);
            startActivityForResult(intent, 0);
            return;
        }
        this.f8984b.m18125b("setting_backup_enable", (Boolean) false);
        this.f8986d.setEnabled(false);
        this.f8986d.setChecked(false);
        m10818a(getString(R.string.auto_backup), this.f8986d, getResources().getColor(R.color.setting_explain_text));
        this.f8984b.m18125b("auto_backup_on", (Boolean) false);
        this.f8987e.setEnabled(false);
        m10818a(getString(R.string.backup_now), this.f8987e, getResources().getColor(R.color.setting_explain_text));
        if (!z2) {
            C2555a.m10956a(this.f8985c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10826d() {
        if (this.f8992j == null) {
            this.f8992j = AbstractC4932a.m18733a(this.f8985c).mo18734a(R.string.backup).mo18746b(R.string.unable_backup_sdcard).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2547g(this)).mo18745a().mo18758a();
            this.f8992j.setCancelable(false);
        }
        if (this.f8992j != null) {
            this.f8992j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10819a(boolean z) {
        View viewInflate = ((LayoutInflater) this.f8985c.getSystemService("layout_inflater")).inflate(R.layout.layout_share_noti, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox_never_show_again);
        ((TextView) viewInflate.findViewById(R.id.notice_contents)).setText(R.string.backup_sms_guide);
        this.f8993k = AbstractC4932a.m18733a(this.f8985c).mo18742a(true).mo18748b(viewInflate).mo18734a(R.string.backup).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2548h(this, z)).mo18745a().mo18758a();
        checkBox.setOnClickListener(new ViewOnClickListenerC2549i(this));
        if (this.f8993k != null) {
            this.f8993k.setCancelable(false);
            this.f8993k.show();
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    this.f8984b.m18125b("setting_backup_enable", (Boolean) true);
                    this.f8986d.setEnabled(true);
                    this.f8987e.setEnabled(true);
                    m10818a(getString(R.string.auto_backup), this.f8986d, getResources().getColor(R.color.color2));
                    m10818a(getString(R.string.backup_now), this.f8987e, getResources().getColor(R.color.color2));
                    this.f8988f.setSummary(this.f8985c.getResources().getString(R.string.setup_change_description));
                    C5179v.m19810a(this.f8985c, R.string.password_set_notice, 1).show();
                    break;
                } else if (i2 == 0) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10827e() {
        if (this.f8989g == null) {
            this.f8989g = new C4923p(this.f8985c).m18724a(R.string.setting_webview_please_wait);
            this.f8989g.setCancelable(false);
        }
        if (this.f8989g != null) {
            this.f8989g.show();
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public void m10829f() {
        this.f8994l = new AsyncTaskC2550j(this, null);
        C4904y.m18639b("[File encryption] start " + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT < 11) {
            this.f8994l.execute(new Void[0]);
        } else {
            this.f8994l.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
