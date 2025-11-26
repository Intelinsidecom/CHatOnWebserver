package com.sec.chaton.settings;

import android.app.AlarmManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.InterfaceC3274d;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityNoti extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: b */
    CheckBoxPreference f8997b;

    /* renamed from: c */
    CheckBoxPreference f8998c;

    /* renamed from: d */
    CheckBoxPreference f8999d;

    /* renamed from: e */
    CheckBoxPreference f9000e;

    /* renamed from: f */
    AlarmManager f9001f;

    /* renamed from: k */
    private Context f9006k;

    /* renamed from: r */
    private int f9013r;

    /* renamed from: s */
    private int f9014s;

    /* renamed from: t */
    private String[] f9015t;

    /* renamed from: u */
    private Preference f9016u;

    /* renamed from: v */
    private Preference f9017v;

    /* renamed from: w */
    private Preference f9018w;

    /* renamed from: x */
    private Map<String, String> f9019x;

    /* renamed from: y */
    private String[] f9020y;

    /* renamed from: a */
    String f8996a = "Settings";

    /* renamed from: l */
    private C3160ab f9007l = null;

    /* renamed from: m */
    private boolean f9008m = true;

    /* renamed from: n */
    private boolean f9009n = true;

    /* renamed from: o */
    private boolean f9010o = true;

    /* renamed from: p */
    private boolean f9011p = true;

    /* renamed from: q */
    private int f9012q = 3;

    /* renamed from: g */
    InterfaceC3274d f9002g = null;

    /* renamed from: h */
    AlertDialogC2481co f9003h = null;

    /* renamed from: i */
    DialogInterface.OnClickListener f9004i = new DialogInterfaceOnClickListenerC2442bc(this);

    /* renamed from: j */
    DialogInterface.OnClickListener f9005j = new DialogInterfaceOnClickListenerC2443bd(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (bundle == null && getIntent().hasExtra("gotoAlert")) {
            getWindow().addFlags(4194304);
        }
        addPreferencesFromResource(R.xml.pref_setting_noti);
        this.f9006k = this;
        this.f9007l = C3159aa.m10962a();
        this.f9007l.m10983b("Lock Check", (Boolean) false);
        this.f9001f = (AlarmManager) this.f9006k.getSystemService("alarm");
        this.f9015t = this.f9006k.getResources().getStringArray(R.array.settings_type_options);
        this.f9019x = new HashMap();
        this.f9019x.put(getResources().getString(R.string.settings_simple_popup), getResources().getString(R.string.settings_popup_view_messages_only));
        this.f9019x.put(getResources().getString(R.string.settings_input_popup), getResources().getString(R.string.settings_popup_view_and_reply_to_messages));
        this.f9020y = new String[]{getResources().getString(R.string.settings_simple_popup), getResources().getString(R.string.settings_input_popup)};
        getListView().setScrollingCacheEnabled(false);
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    private void m8984a() throws Resources.NotFoundException {
        boolean zBooleanValue;
        this.f9000e = (CheckBoxPreference) findPreference("pref_item_push_notification");
        if (this.f9007l.m10977a("Setting Notification", (Boolean) true).booleanValue()) {
            this.f9011p = true;
            this.f9007l.m10983b("Setting Notification", (Boolean) true);
        } else {
            this.f9011p = false;
            this.f9007l.m10983b("Setting Notification", (Boolean) false);
        }
        this.f9000e.setChecked(this.f9011p);
        m8986a(getResources().getString(R.string.push_notification_text), this.f9000e, getResources().getColor(R.color.setting_explain_text));
        this.f9000e.setOnPreferenceChangeListener(new C2432at(this));
        this.f8998c = (CheckBoxPreference) findPreference("pref_item_blackscreen_popup");
        if (this.f9007l.m10977a("Setting show blackscreen popup", (Boolean) true).booleanValue()) {
            this.f9009n = true;
            this.f9007l.m10983b("Setting show blackscreen popup", (Boolean) true);
        } else {
            this.f9009n = false;
            this.f9007l.m10983b("Setting show blackscreen popup", (Boolean) false);
        }
        this.f8998c.setChecked(this.f9009n);
        m8986a(getResources().getString(R.string.settings_popup_information), this.f8998c, getResources().getColor(R.color.setting_explain_text));
        this.f8998c.setOnPreferenceChangeListener(new C2433au(this));
        this.f9018w = findPreference("pref_item_popup_type");
        if (this.f9007l.m10987b("Setting is simple popup")) {
            zBooleanValue = this.f9007l.m10977a("Setting is simple popup", (Boolean) true).booleanValue();
        } else {
            this.f9007l.m10983b("Setting is simple popup", (Boolean) true);
            zBooleanValue = true;
        }
        if (zBooleanValue) {
            m8986a(getResources().getString(R.string.settings_simple_popup), this.f9018w, getResources().getColor(R.color.buddy_list_item_status_changed));
            this.f9014s = 0;
        } else {
            m8986a(getResources().getString(R.string.settings_input_popup), this.f9018w, getResources().getColor(R.color.buddy_list_item_status_changed));
            this.f9014s = 1;
        }
        this.f9018w.setOnPreferenceClickListener(new C2434av(this));
        this.f8999d = (CheckBoxPreference) findPreference("pref_item_alert_group_chat");
        if (this.f9007l.m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue()) {
            this.f9010o = true;
            this.f9007l.m10983b("Setting alert_new_groupchat", (Boolean) true);
        } else {
            this.f9010o = false;
            this.f9007l.m10983b("Setting alert_new_groupchat", (Boolean) false);
        }
        this.f8999d.setChecked(this.f9010o);
        m8986a(getResources().getString(R.string.setting_alert_new_group_chat_description), this.f8999d, getResources().getColor(R.color.setting_explain_text));
        this.f8999d.setOnPreferenceChangeListener(new C2437ay(this));
        this.f8997b = (CheckBoxPreference) findPreference("pref_item_received_message");
        if (this.f9007l.m10977a("Setting show receive message", (Boolean) true).booleanValue()) {
            this.f9008m = true;
            this.f9007l.m10983b("Setting show receive message", (Boolean) true);
        } else {
            this.f9008m = false;
            this.f9007l.m10983b("Setting show receive message", (Boolean) false);
        }
        this.f8997b.setChecked(this.f9008m);
        m8986a(getResources().getString(R.string.settings_received_message_summary), this.f8997b, getResources().getColor(R.color.setting_explain_text));
        this.f8997b.setOnPreferenceChangeListener(new C2438az(this));
        this.f9016u = findPreference("pref_item_type");
        m8987a(this.f9011p);
        if (this.f9011p) {
            m8993b(this.f9009n);
        }
        this.f9016u.setOnPreferenceClickListener(new C2440ba(this));
        this.f9017v = findPreference("pref_item_mute");
        C1103a.m5432a(this.f9006k).m5472g();
        m8995c();
        this.f9017v.setOnPreferenceClickListener(new C2441bb(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8991b() {
        this.f9003h = new AlertDialogC2481co(this.f9006k);
        this.f9003h.setButton(-2, this.f9006k.getText(R.string.dialog_ok), this.f9005j);
        this.f9003h.setButton(-1, this.f9006k.getText(R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        this.f9003h.show();
    }

    /* renamed from: a */
    private String m8983a(Long l) {
        return new SimpleDateFormat("HH:mm").format(l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8995c() throws Resources.NotFoundException {
        this.f9012q = C3159aa.m10962a().m10978a("Setting mute type", (Integer) 3).intValue();
        String string = "";
        switch (this.f9012q) {
            case 0:
                string = m8983a(Long.valueOf(C3159aa.m10962a().m10976a("Setting mute hour start Long", 0L))) + " ~ " + m8983a(Long.valueOf(C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L)));
                break;
            case 1:
                string = getResources().getString(R.string.settings_mute_until_7);
                break;
            case 2:
                C2480cn c2480cn = new C2480cn(C3159aa.m10962a().m10976a("Setting mute hour start Long", 0L), C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L));
                string = String.format("%02d:%02d ~ %02d:%02d", Integer.valueOf(c2480cn.m9222f()), Integer.valueOf(c2480cn.m9223g()), Integer.valueOf(c2480cn.m9224h()), Integer.valueOf(c2480cn.m9225i()));
                break;
            case 3:
                string = getResources().getString(R.string.settings_mute_none);
                C3159aa.m10962a().m10984b("Setting mute type", (Integer) 3);
                C3159aa.m10962a().m10981a("Setting mute hour start Long");
                C3159aa.m10962a().m10981a("Setting mute hour end Long");
                C3159aa.m10962a().m10981a("Setting mute repeat");
                break;
        }
        m8986a(string, this.f9017v, getResources().getColor(R.color.buddy_list_item_status_changed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8987a(boolean z) {
        String str;
        String strM5474i = C1103a.m5432a(this.f9006k).m5474i();
        if (strM5474i.equals("ALL")) {
            str = this.f9015t[0];
        } else if (strM5474i.equals("MELODY")) {
            str = this.f9015t[1];
        } else if (strM5474i.equals("VIBRATION")) {
            str = this.f9015t[2];
        } else {
            str = this.f9015t[3];
        }
        m8986a(str, this.f9016u, getResources().getColor(R.color.buddy_list_item_status_changed));
        this.f8998c.setEnabled(z);
        this.f8997b.setEnabled(z);
        this.f8999d.setEnabled(z);
        if (this.f9009n) {
            m8993b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8993b(boolean z) {
        if (this.f9018w != null) {
            this.f9018w.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8986a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        getWindow().clearFlags(4194304);
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        try {
            m8984a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
        m8987a(this.f9011p);
        if (this.f9011p) {
            m8993b(this.f9009n);
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
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
