package com.sec.chaton.settings;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.settings.p096a.C3470n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.InterfaceC4936e;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityNoti2 extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: A */
    private boolean f12541A;

    /* renamed from: B */
    private boolean f12542B;

    /* renamed from: C */
    private boolean f12543C;

    /* renamed from: D */
    private int f12544D;

    /* renamed from: E */
    private boolean f12545E;

    /* renamed from: F */
    private String f12546F;

    /* renamed from: H */
    private boolean f12548H;

    /* renamed from: I */
    private boolean f12549I;

    /* renamed from: J */
    private boolean f12550J;

    /* renamed from: h */
    private AlarmManager f12558h;

    /* renamed from: j */
    private CheckBoxPreference f12560j;

    /* renamed from: k */
    private CheckBoxPreference f12561k;

    /* renamed from: l */
    private CheckBoxPreference f12562l;

    /* renamed from: m */
    private CheckBoxPreference f12563m;

    /* renamed from: n */
    private CheckBoxPreference f12564n;

    /* renamed from: o */
    private Preference f12565o;

    /* renamed from: p */
    private CheckBoxPreference f12566p;

    /* renamed from: q */
    private Preference f12567q;

    /* renamed from: r */
    private Preference f12568r;

    /* renamed from: s */
    private Preference f12569s;

    /* renamed from: t */
    private CheckBoxPreference f12570t;

    /* renamed from: u */
    private CheckBoxPreference f12571u;

    /* renamed from: w */
    private String[] f12573w;

    /* renamed from: x */
    private Map<String, String> f12574x;

    /* renamed from: y */
    private String[] f12575y;

    /* renamed from: z */
    private String[] f12576z;

    /* renamed from: g */
    private C4810ab f12557g = null;

    /* renamed from: i */
    private boolean f12559i = true;

    /* renamed from: v */
    private CheckBoxPreference f12572v = null;

    /* renamed from: G */
    private int f12547G = 3;

    /* renamed from: a */
    InterfaceC4936e f12551a = null;

    /* renamed from: b */
    AlertDialogC3576dm f12552b = null;

    /* renamed from: c */
    DialogInterface.OnClickListener f12553c = new DialogInterfaceOnClickListenerC3526bq(this);

    /* renamed from: d */
    DialogInterface.OnClickListener f12554d = new DialogInterfaceOnClickListenerC3527br(this);

    /* renamed from: e */
    DialogInterface.OnClickListener f12555e = new DialogInterfaceOnClickListenerC3528bs(this);

    /* renamed from: f */
    DialogInterface.OnClickListener f12556f = new DialogInterfaceOnClickListenerC3529bt(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        addPreferencesFromResource(R.xml.pref_setting_noti);
        this.f12557g = C4809aa.m18104a();
        this.f12557g.m18125b("Lock Check", (Boolean) false);
        this.f12558h = (AlarmManager) getSystemService("alarm");
        this.f12573w = getResources().getStringArray(R.array.settings_type_options);
        this.f12576z = getResources().getStringArray(R.array.setting_mode_item);
        this.f12574x = new HashMap();
        this.f12574x.put(getResources().getString(R.string.settings_simple_popup), getResources().getString(R.string.settings_popup_view_messages_only));
        this.f12574x.put(getResources().getString(R.string.settings_input_popup), getResources().getString(R.string.settings_popup_view_and_reply_to_messages));
        this.f12575y = new String[]{getResources().getString(R.string.settings_simple_popup), getResources().getString(R.string.settings_input_popup)};
        getListView().setScrollingCacheEnabled(false);
        if (Build.VERSION.SDK_INT > 10) {
            Vibrator vibrator = (Vibrator) CommonApplication.m18732r().getSystemService("vibrator");
            if (vibrator == null || !vibrator.hasVibrator()) {
                this.f12559i = false;
            } else {
                this.f12559i = true;
            }
        }
        getWindow().addFlags(4194304);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        try {
            m13433b();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
        m13426a();
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        super.onPause();
        if (this.f12568r != null) {
            ((RingtonePreference2) this.f12568r).m13673a();
        }
        getWindow().clearFlags(4194304);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        super.onDestroy();
        if (this.f12568r != null) {
            ((RingtonePreference2) this.f12568r).m13674b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13426a() throws Resources.NotFoundException {
        int iM13431b = m13431b(C1813b.m8906b().m8946k());
        boolean z = iM13431b == 1;
        boolean z2 = iM13431b == 3;
        this.f12561k.setEnabled(this.f12541A);
        if (this.f12562l != null) {
            this.f12562l.setEnabled(this.f12541A);
        }
        this.f12563m.setEnabled(this.f12541A);
        this.f12564n.setEnabled(this.f12541A && this.f12542B);
        this.f12565o.setEnabled(this.f12541A && this.f12542B);
        m13428a(this.f12565o.getSummary().toString(), this.f12565o, this.f12541A && this.f12542B);
        this.f12566p.setEnabled(this.f12541A && this.f12542B);
        this.f12567q.setEnabled(this.f12541A);
        m13428a(this.f12567q.getSummary().toString(), this.f12567q, this.f12541A);
        this.f12568r.setEnabled((!this.f12541A || z || z2) ? false : true);
        m13428a(this.f12568r.getSummary().toString(), this.f12568r, (!this.f12541A || z || z2) ? false : true);
        this.f12569s.setEnabled(this.f12541A && !z2);
        m13428a(this.f12569s.getSummary().toString(), this.f12569s, this.f12541A && !z2);
        this.f12571u.setEnabled(this.f12541A);
        if (this.f12572v != null) {
            this.f12572v.setEnabled(this.f12541A);
        }
        if (this.f12570t != null) {
            this.f12570t.setEnabled(this.f12541A);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("pref_category_advanced");
        if (C2349a.m10301a("sms_feature") && !C4822an.m18218a() && preferenceCategory != null && this.f12570t != null) {
            preferenceCategory.removePreference(this.f12570t);
        }
        PreferenceCategory preferenceCategory2 = (PreferenceCategory) findPreference("pref_category_notification_types");
        if (C2349a.m10301a("sms_feature") && !C4822an.m18218a() && preferenceCategory2 != null && this.f12562l != null) {
            preferenceCategory2.removePreference(this.f12562l);
        }
    }

    /* renamed from: b */
    private void m13433b() throws Resources.NotFoundException {
        this.f12560j = (CheckBoxPreference) findPreference("pref_item_push_notification");
        if (!this.f12557g.m18129b("Setting Notification")) {
            this.f12557g.m18125b("Setting Notification", (Boolean) true);
        }
        this.f12541A = this.f12557g.m18119a("Setting Notification", (Boolean) true).booleanValue();
        this.f12560j.setChecked(this.f12541A);
        this.f12560j.setOnPreferenceChangeListener(new C3521bl(this));
        this.f12561k = (CheckBoxPreference) findPreference("pref_item_message");
        if (!this.f12557g.m18129b("pref_setting_message_notification_on")) {
            this.f12557g.m18125b("pref_setting_message_notification_on", (Boolean) true);
        }
        this.f12561k.setOnPreferenceChangeListener(new C3530bu(this));
        this.f12561k.setChecked(this.f12557g.m18119a("pref_setting_message_notification_on", (Boolean) true).booleanValue());
        this.f12562l = (CheckBoxPreference) findPreference("pref_item_updates");
        if (!this.f12557g.m18129b("pref_setting_update_notification_on")) {
            this.f12557g.m18125b("pref_setting_update_notification_on", (Boolean) true);
        }
        this.f12562l.setOnPreferenceChangeListener(new C3531bv(this));
        this.f12562l.setChecked(this.f12557g.m18119a("pref_setting_update_notification_on", (Boolean) true).booleanValue());
        this.f12563m = (CheckBoxPreference) findPreference("pref_item_use_popup");
        if (!this.f12557g.m18129b("Setting show blackscreen popup")) {
            this.f12557g.m18125b("Setting show blackscreen popup", (Boolean) true);
        }
        this.f12542B = this.f12557g.m18119a("Setting show blackscreen popup", (Boolean) true).booleanValue();
        this.f12563m.setChecked(this.f12542B);
        this.f12563m.setOnPreferenceChangeListener(new C3532bw(this));
        this.f12564n = (CheckBoxPreference) findPreference("pref_item_preview");
        if (!this.f12557g.m18129b("Setting show receive message")) {
            this.f12557g.m18125b("Setting show receive message", (Boolean) true);
        }
        this.f12543C = this.f12557g.m18119a("Setting show receive message", (Boolean) true).booleanValue();
        this.f12564n.setChecked(this.f12543C);
        this.f12564n.setOnPreferenceChangeListener(new C3533bx(this));
        this.f12565o = findPreference("pref_item_popup_type");
        if (!this.f12557g.m18129b("Setting is simple popup")) {
            this.f12557g.m18125b("Setting is simple popup", (Boolean) true);
        }
        if (this.f12557g.m18119a("Setting is simple popup", (Boolean) true).booleanValue()) {
            this.f12544D = 0;
            m13428a(getResources().getString(R.string.settings_simple_popup), this.f12565o, true);
        } else {
            this.f12544D = 1;
            m13428a(getResources().getString(R.string.settings_input_popup), this.f12565o, true);
        }
        this.f12565o.setOnPreferenceClickListener(new C3534by(this));
        this.f12566p = (CheckBoxPreference) findPreference("pref_item_use_popup_while_screen_off");
        if (!this.f12557g.m18129b("Setting is use popup while screen off")) {
            this.f12557g.m18125b("Setting is use popup while screen off", (Boolean) true);
        }
        this.f12545E = this.f12557g.m18119a("Setting is use popup while screen off", (Boolean) true).booleanValue();
        this.f12566p.setChecked(this.f12545E);
        this.f12566p.setOnPreferenceChangeListener(new C3535bz(this));
        this.f12567q = findPreference("pref_item_mode");
        this.f12546F = C1813b.m8906b().m8946k();
        this.f12567q.setSummary(m13425a(this.f12546F));
        this.f12567q.setWidgetLayoutResource(R.layout.preference_widget_arrow);
        this.f12567q.setOnPreferenceClickListener(new C3537ca(this));
        this.f12568r = findPreference("pref_item_sound_type");
        m13428a(m13446f(), this.f12568r, true);
        this.f12568r.setOnPreferenceChangeListener(new C3538cb(this));
        this.f12569s = findPreference("pref_item_mute");
        C1813b.m8906b().m8944i();
        m13440d();
        this.f12569s.setOnPreferenceClickListener(new C3522bm(this));
        this.f12570t = (CheckBoxPreference) findPreference("pref_item_alert_group_chat");
        if (this.f12570t != null) {
            if (!this.f12557g.m18129b("Setting alert_new_groupchat")) {
                this.f12557g.m18125b("Setting alert_new_groupchat", (Boolean) true);
            }
            this.f12548H = this.f12557g.m18119a("Setting alert_new_groupchat", (Boolean) true).booleanValue();
            this.f12570t.setChecked(this.f12548H);
            this.f12570t.setOnPreferenceChangeListener(new C3523bn(this));
        }
        this.f12571u = (CheckBoxPreference) findPreference("pref_item_led");
        if (!this.f12557g.m18129b("LED Indicator")) {
            this.f12557g.m18125b("LED Indicator", (Boolean) true);
        }
        this.f12549I = this.f12557g.m18119a("LED Indicator", (Boolean) true).booleanValue();
        this.f12571u.setChecked(this.f12549I);
        this.f12571u.setOnPreferenceChangeListener(new C3524bo(this));
        if (C4859bx.m18415j()) {
            this.f12572v = (CheckBoxPreference) findPreference("pref_item_service_notification");
            this.f12550J = this.f12557g.m18119a("marketing_disclaimer", (Boolean) false).booleanValue();
            if (C4904y.f17872b) {
                C4904y.m18639b("serviceNotiEnable : " + this.f12550J, getClass().getSimpleName());
            }
            this.f12572v.setChecked(this.f12550J);
            this.f12572v.setOnPreferenceChangeListener(new C3525bp(this));
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("pref_category_notification_types");
        this.f12572v = (CheckBoxPreference) findPreference("pref_item_service_notification");
        if (preferenceCategory != null && this.f12572v != null) {
            preferenceCategory.removePreference(this.f12572v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13438c() {
        this.f12552b = new AlertDialogC3576dm(this);
        this.f12552b.setInverseBackgroundForced(true);
        this.f12552b.setButton(-2, CommonApplication.m18732r().getText(R.string.dialog_ok), this.f12556f);
        this.f12552b.setButton(-1, CommonApplication.m18732r().getText(R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        this.f12552b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13440d() throws Resources.NotFoundException {
        this.f12547G = C4809aa.m18104a().m18120a("Setting mute type", (Integer) 3).intValue();
        String string = "";
        switch (this.f12547G) {
            case 0:
                string = m13424a(Long.valueOf(C4809aa.m18104a().m18118a("Setting mute hour start Long", 0L))) + " ~ " + m13424a(Long.valueOf(C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L)));
                break;
            case 1:
                string = getResources().getString(R.string.settings_mute_until_7);
                break;
            case 2:
                C3575dl c3575dlM13853a = C3575dl.m13853a(C4809aa.m18104a().m18118a("Setting mute hour start Long", 0L), C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L));
                string = String.format("%02d:%02d ~ %02d:%02d", Integer.valueOf(c3575dlM13853a.m13861f()), Integer.valueOf(c3575dlM13853a.m13862g()), Integer.valueOf(c3575dlM13853a.m13863h()), Integer.valueOf(c3575dlM13853a.m13864i()));
                break;
            case 3:
                string = getResources().getString(R.string.settings_mute_none);
                C4809aa.m18104a().m18126b("Setting mute type", (Integer) 3);
                C4809aa.m18104a().m18123a("Setting mute hour start Long");
                C4809aa.m18104a().m18123a("Setting mute hour end Long");
                C4809aa.m18104a().m18123a("Setting mute repeat");
                break;
        }
        m13428a(string, this.f12569s, true);
    }

    /* renamed from: a */
    private String m13424a(Long l) {
        return new SimpleDateFormat("HH:mm").format(l);
    }

    /* renamed from: e */
    private String m13443e() {
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this, 2);
        if (actualDefaultRingtoneUri != null) {
            this.f12557g.m18128b("Ringtone", actualDefaultRingtoneUri.toString());
            Ringtone ringtone = RingtoneManager.getRingtone(this, actualDefaultRingtoneUri);
            if (ringtone == null) {
                return null;
            }
            String title = ringtone.getTitle(this);
            this.f12557g.m18128b("Ringtone title", title);
            return title;
        }
        return CommonApplication.m18732r().getString(R.string.ringtone_silent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m13446f() {
        boolean z;
        String str;
        String strM18121a = this.f12557g.m18121a("Ringtone title", getString(R.string.ringtone_silent));
        String strM18121a2 = this.f12557g.m18121a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM18121a2)) {
            if (strM18121a2.startsWith("content://")) {
                Ringtone ringtone = RingtoneManager.getRingtone(this, Uri.parse(strM18121a2));
                if (ringtone != null) {
                    return ringtone.getTitle(this);
                }
            } else {
                if (strM18121a2.startsWith("android.resource://")) {
                    Iterator<Map.Entry<String, C3470n>> it = C3470n.m13796a().entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            str = strM18121a;
                            break;
                        }
                        Map.Entry<String, C3470n> next = it.next();
                        if (strM18121a2.equals(next.getValue().f12954s)) {
                            z = true;
                            str = next.getValue().f12950o;
                            break;
                        }
                    }
                    if (!z) {
                        return m13443e();
                    }
                    return str;
                }
                if (strM18121a2.startsWith("file://")) {
                    if (!new File(strM18121a2.substring(7)).exists()) {
                        strM18121a = m13443e();
                    }
                    return strM18121a;
                }
            }
            return strM18121a;
        }
        return m13443e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m13425a(String str) {
        if (str.equals("ALL")) {
            return this.f12576z[2];
        }
        if (str.equals("MELODY")) {
            return this.f12576z[0];
        }
        if (str.equals("VIBRATION")) {
            return this.f12576z[1];
        }
        return this.f12576z[3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m13431b(String str) {
        if (str.equals("ALL")) {
            return 2;
        }
        if (str.equals("MELODY")) {
            return 0;
        }
        if (str.equals("VIBRATION")) {
            return 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13428a(String str, Preference preference, boolean z) throws Resources.NotFoundException {
        int color = getResources().getColor(R.color.setting_disable_summary_color);
        if (z) {
            color = getResources().getColor(R.color.buddy_popup_center_background_focused);
        }
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str)) {
            spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 0);
            preference.setSummary(spannableString);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
