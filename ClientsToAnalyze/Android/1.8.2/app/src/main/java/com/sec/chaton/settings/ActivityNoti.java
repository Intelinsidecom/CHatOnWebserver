package com.sec.chaton.settings;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.support.v4.content.LocalBroadcastManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityNoti extends PreferenceListFragment {

    /* renamed from: p */
    private static boolean f4494p = false;

    /* renamed from: c */
    AlarmManager f4497c;

    /* renamed from: d */
    private Context f4498d;

    /* renamed from: j */
    private String[] f4504j;

    /* renamed from: k */
    private String[] f4505k;

    /* renamed from: l */
    private Preference f4506l;

    /* renamed from: m */
    private CheckBoxPreference f4507m;

    /* renamed from: n */
    private CheckBoxPreference f4508n;

    /* renamed from: o */
    private String f4509o;

    /* renamed from: q */
    private Handler f4510q;

    /* renamed from: a */
    String f4495a = "Settings";

    /* renamed from: e */
    private SharedPreferences f4499e = null;

    /* renamed from: b */
    SharedPreferences.Editor f4496b = null;

    /* renamed from: f */
    private boolean f4500f = true;

    /* renamed from: g */
    private boolean f4501g = true;

    /* renamed from: h */
    private boolean f4502h = true;

    /* renamed from: i */
    private boolean f4503i = true;

    /* renamed from: r */
    private BroadcastReceiver f4511r = new C1225ad(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_noti);
        this.f4498d = getActivity();
        this.f4499e = C1789u.m6075a();
        this.f4496b = this.f4499e.edit();
        this.f4496b.putBoolean("Lock Check", false);
        Context context = this.f4498d;
        getActivity();
        this.f4497c = (AlarmManager) context.getSystemService("alarm");
        this.f4504j = this.f4498d.getResources().getStringArray(R.array.settings_type_options_value);
        this.f4505k = this.f4498d.getResources().getStringArray(R.array.settings_type_options);
        try {
            m4511b();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
        this.f4510q = new HandlerC1481x(this);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: b */
    private void m4511b() throws NumberFormatException {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) m6121a("pref_item_push_notification");
        if (this.f4499e.getBoolean("Setting Notification", true)) {
            this.f4502h = true;
            this.f4496b.putBoolean("Setting Notification", true).commit();
        } else {
            this.f4502h = false;
            this.f4496b.putBoolean("Setting Notification", false).commit();
        }
        checkBoxPreference.setChecked(this.f4502h);
        m4507a(getResources().getString(R.string.push_notification_text), checkBoxPreference, getResources().getColor(R.color.ics_orange_font_color));
        checkBoxPreference.setOnPreferenceChangeListener(new C1482y(this));
        this.f4508n = (CheckBoxPreference) m6121a("pref_item_blackscreen_popup");
        if (this.f4499e.getBoolean("Setting show blackscreen popup", true)) {
            this.f4501g = true;
            this.f4496b.putBoolean("Setting show blackscreen popup", true).commit();
        } else {
            this.f4501g = false;
            this.f4496b.putBoolean("Setting show blackscreen popup", false).commit();
        }
        this.f4508n.setChecked(this.f4501g);
        if (this.f4502h) {
            m4513b(getResources().getString(R.string.settings_popup_notifications), this.f4508n, getResources().getColor(R.color.ics_main_font_color_2));
            m4507a(getResources().getString(R.string.settings_popup_information), this.f4508n, getResources().getColor(R.color.ics_orange_font_color));
        } else {
            m4513b(getResources().getString(R.string.settings_popup_notifications), this.f4508n, getResources().getColor(R.color.gray));
            m4507a(getResources().getString(R.string.settings_popup_information), this.f4508n, getResources().getColor(R.color.gray));
        }
        this.f4508n.setOnPreferenceChangeListener(new C1483z(this));
        this.f4507m = (CheckBoxPreference) m6121a("pref_item_received_message");
        if (this.f4499e.getBoolean("Setting show receive message", true)) {
            this.f4500f = true;
            this.f4496b.putBoolean("Setting show receive message", true).commit();
        } else {
            this.f4500f = false;
            this.f4496b.putBoolean("Setting show receive message", false).commit();
        }
        this.f4507m.setChecked(this.f4500f);
        if (this.f4502h) {
            m4513b(getResources().getString(R.string.settings_received_message), this.f4507m, getResources().getColor(R.color.ics_main_font_color_2));
            m4507a(getResources().getString(R.string.settings_received_message_summary), this.f4507m, getResources().getColor(R.color.ics_orange_font_color));
        } else {
            m4513b(getResources().getString(R.string.settings_received_message), this.f4507m, getResources().getColor(R.color.gray));
            m4507a(getResources().getString(R.string.settings_received_message_summary), this.f4507m, getResources().getColor(R.color.gray));
        }
        this.f4507m.setOnPreferenceChangeListener(new C1222aa(this));
        this.f4506l = m6121a("pref_item_type");
        if (this.f4499e.getString("Set Type Text", "") == "") {
            this.f4496b.putString("Set Type Text", Integer.toString(0));
            this.f4496b.commit();
        }
        if (!f4494p) {
            try {
                Integer.parseInt(this.f4499e.getString("Set Type Text", ""));
            } catch (NumberFormatException e) {
                this.f4496b.putString("Set Type Text", Integer.toString(0));
                this.f4496b.commit();
            }
        }
        this.f4509o = this.f4504j[Integer.parseInt(this.f4499e.getString("Set Type Text", ""))];
        int i = 0;
        while (true) {
            if (i >= this.f4504j.length) {
                break;
            }
            if (!this.f4509o.equals(this.f4504j[i])) {
                i++;
            } else {
                this.f4509o = this.f4505k[i];
                break;
            }
        }
        this.f4506l.setSummary(this.f4509o);
        if (this.f4502h) {
            m4513b(getResources().getString(R.string.settings_type), this.f4506l, getResources().getColor(R.color.ics_main_font_color_2));
            m4507a(this.f4509o, this.f4506l, getResources().getColor(R.color.ics_orange_font_color));
        } else {
            m4513b(getResources().getString(R.string.settings_type), this.f4506l, getResources().getColor(R.color.gray));
            m4507a(this.f4509o, this.f4506l, getResources().getColor(R.color.gray));
        }
        this.f4506l.setOnPreferenceClickListener(new C1223ab(this));
        m4519a();
    }

    /* renamed from: a */
    public void m4519a() {
        C0620aj.m2804a().mo2705c(new HandlerC1224ac(this, Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4507a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4513b(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f4511r);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f4511r, intentFilter);
        this.f4509o = this.f4504j[Integer.parseInt(this.f4499e.getString("Set Type Text", ""))];
        int i = 0;
        while (true) {
            if (i >= this.f4504j.length) {
                break;
            }
            if (!this.f4509o.equals(this.f4504j[i])) {
                i++;
            } else {
                this.f4509o = this.f4505k[i];
                break;
            }
        }
        this.f4506l.setSummary(this.f4509o);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
    }
}
