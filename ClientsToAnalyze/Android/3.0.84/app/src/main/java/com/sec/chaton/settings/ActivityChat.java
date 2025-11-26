package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p027e.C1439g;
import com.sec.chaton.p027e.p028a.C1367k;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ActivityChat extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    private Context f8941c;

    /* renamed from: e */
    private boolean f8943e;

    /* renamed from: f */
    private ProgressDialog f8944f;

    /* renamed from: g */
    private CheckBoxPreference f8945g;

    /* renamed from: h */
    private C1377u f8946h;

    /* renamed from: a */
    String f8939a = "Settings";

    /* renamed from: d */
    private C3160ab f8942d = null;

    /* renamed from: b */
    InterfaceC1378v f8940b = new C2721s(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f8941c = this;
        this.f8946h = new C1377u(getContentResolver(), this.f8940b);
        addPreferencesFromResource(R.xml.pref_setting_chats);
        this.f8942d = C3159aa.m10962a();
        this.f8942d.m10983b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m8940a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
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
    private void m8940a() {
        findPreference("pref_item_change_bubble_background_style").setOnPreferenceClickListener(new C2706j(this));
        Preference preferenceFindPreference = findPreference("pref_item_font_style");
        m8942a(m8947c(), preferenceFindPreference, getResources().getColor(R.color.buddy_list_item_status_changed));
        preferenceFindPreference.setOnPreferenceClickListener(new C2707k(this));
        Preference preferenceFindPreference2 = findPreference("pref_item_font_size");
        m8942a(m8948d(), preferenceFindPreference2, getResources().getColor(R.color.buddy_list_item_status_changed));
        preferenceFindPreference2.setOnPreferenceClickListener(new C2708l(this));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_enter_key");
        if (this.f8942d.m10977a("Setting enter key", (Boolean) false).booleanValue()) {
            this.f8943e = true;
            this.f8942d.m10983b("Setting enter key", (Boolean) true);
        } else {
            this.f8943e = false;
            this.f8942d.m10983b("Setting enter key", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.f8943e);
        m8942a(getResources().getString(R.string.settings_send_message_using_enter), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C2709m(this));
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("pref_item_push_to_talk_key");
        boolean zBooleanValue = this.f8942d.m10977a("Setting push to talk", (Boolean) false).booleanValue();
        this.f8942d.m10983b("Setting push to talk", Boolean.valueOf(zBooleanValue));
        checkBoxPreference2.setChecked(zBooleanValue);
        m8942a(getString(R.string.settings_send_button_walkie_talkie), checkBoxPreference2, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference2.setOnPreferenceChangeListener(new C2716n(this));
        this.f8945g = (CheckBoxPreference) findPreference("pref_item_auto_resend");
        boolean zM7251b = C1757q.m7251b();
        this.f8945g.setChecked(zM7251b);
        if (zM7251b) {
            m8942a(getResources().getString(R.string.setting_chat_autoresend_description_on), this.f8945g, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            m8942a(getResources().getString(R.string.setting_chat_autoresend_description_off), this.f8945g, getResources().getColor(R.color.buddy_list_item_status_changed));
        }
        this.f8945g.setOnPreferenceChangeListener(new C2717o(this));
        findPreference("pref_item_delete_old_chat_rooms").setOnPreferenceClickListener(new C2718p(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        try {
            m8940a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f8944f != null && this.f8944f.isShowing()) {
            this.f8944f.dismiss();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8942a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8945b() {
        this.f8944f = new ProgressDialog(this.f8941c);
        this.f8944f.setMessage(this.f8941c.getString(R.string.deleting));
        this.f8944f.setCancelable(false);
        this.f8944f.show();
        this.f8946h.startDelete(1, null, C1439g.m6302a(), null, null);
    }

    /* renamed from: c */
    private String m8947c() throws Resources.NotFoundException {
        String string = GlobalApplication.m6451b().getString(R.string.chaton_default);
        int iIntValue = C3159aa.m10962a().m10978a("Default Font Typeface", (Integer) (-1)).intValue();
        if (iIntValue != -1) {
            if (C3159aa.m10962a().m10987b("Default Font Name")) {
                return C3159aa.m10962a().m10979a("Default Font Name", string);
            }
            ArrayList<String> arrayListM6096a = C1367k.m6096a(GlobalApplication.m11493l(), Integer.toString(iIntValue));
            if (arrayListM6096a != null) {
                string = arrayListM6096a.get(0);
            }
            C3159aa.m10962a().m10986b("Default Font Name", string);
            return string;
        }
        return string;
    }

    /* renamed from: d */
    private String m8948d() throws Resources.NotFoundException {
        String strName = EnumC2504dk.m9259a(C3159aa.m10962a().m10979a("Default Font Size", EnumC2504dk.Normal.m9260a())).name();
        GlobalApplication.m6451b().getString(R.string.chat_font_medium);
        if (strName.equals(EnumC2504dk.System.name())) {
            return GlobalApplication.m6451b().getString(R.string.use_device_font_size);
        }
        if (strName.equals(EnumC2504dk.Tiny.name())) {
            return GlobalApplication.m6451b().getString(R.string.chat_font_extra_small);
        }
        if (strName.equals(EnumC2504dk.Small.name())) {
            return GlobalApplication.m6451b().getString(R.string.chat_font_small);
        }
        if (strName.equals(EnumC2504dk.Normal.name())) {
            return GlobalApplication.m6451b().getString(R.string.chat_font_medium);
        }
        if (strName.equals(EnumC2504dk.Large.name())) {
            return GlobalApplication.m6451b().getString(R.string.chat_font_large);
        }
        return GlobalApplication.m6451b().getString(R.string.chat_font_extra_large);
    }
}
