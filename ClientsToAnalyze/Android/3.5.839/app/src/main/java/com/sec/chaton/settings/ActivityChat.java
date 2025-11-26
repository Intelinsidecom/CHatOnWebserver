package com.sec.chaton.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.C2660e;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p057e.p058a.C2197k;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ActivityChat extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: b */
    private Context f12502b;

    /* renamed from: d */
    private boolean f12504d;

    /* renamed from: e */
    private CheckBoxPreference f12505e;

    /* renamed from: a */
    String f12501a = "Settings";

    /* renamed from: c */
    private C4810ab f12503c = null;

    /* renamed from: f */
    private C2660e f12506f = null;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f12502b = this;
        addPreferencesFromResource(R.xml.pref_setting_chats);
        this.f12503c = C4809aa.m18104a();
        this.f12503c.m18125b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m13371a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    private void m13371a() {
        findPreference("pref_item_change_bubble_background_style").setOnPreferenceClickListener(new C3486ad(this));
        Preference preferenceFindPreference = findPreference("pref_item_font_style");
        m13373a(m13378c(), preferenceFindPreference, getResources().getColor(R.color.buddy_list_item_status_changed));
        preferenceFindPreference.setOnPreferenceClickListener(new C3487ae(this));
        if (this.f12503c.m18120a("Downloaded_font_count", (Integer) 0).intValue() <= 0) {
            ((PreferenceScreen) findPreference("pref_setting_chats")).removePreference(preferenceFindPreference);
        }
        Preference preferenceFindPreference2 = findPreference("pref_item_font_size");
        m13373a(m13379d(), preferenceFindPreference2, getResources().getColor(R.color.buddy_list_item_status_changed));
        preferenceFindPreference2.setOnPreferenceClickListener(new C3488af(this));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_enter_key");
        if (this.f12503c.m18119a("Setting enter key", (Boolean) false).booleanValue()) {
            this.f12504d = true;
            this.f12503c.m18125b("Setting enter key", (Boolean) true);
        } else {
            this.f12504d = false;
            this.f12503c.m18125b("Setting enter key", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.f12504d);
        m13373a(getResources().getString(R.string.settings_send_message_using_enter), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C3489ag(this));
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("pref_item_push_to_talk_key");
        boolean zBooleanValue = this.f12503c.m18119a("Setting push to talk", (Boolean) true).booleanValue();
        this.f12503c.m18125b("Setting push to talk", Boolean.valueOf(zBooleanValue));
        checkBoxPreference2.setChecked(zBooleanValue);
        m13373a(getString(R.string.settings_send_button_walkie_talkie), checkBoxPreference2, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference2.setOnPreferenceChangeListener(new C3490ah(this));
        this.f12505e = (CheckBoxPreference) findPreference("pref_item_auto_resend");
        boolean zM11398b = C2717y.m11398b();
        this.f12505e.setChecked(zM11398b);
        if (zM11398b) {
            m13373a(getResources().getString(R.string.setting_chat_autoresend_description_on), this.f12505e, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            m13373a(getResources().getString(R.string.setting_chat_autoresend_description_off), this.f12505e, getResources().getColor(R.color.buddy_list_item_status_changed));
        }
        this.f12505e.setOnPreferenceChangeListener(new C3491ai(this));
        findPreference("pref_item_delete_old_chat_rooms").setOnPreferenceClickListener(new C3492aj(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        try {
            m13371a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f12506f != null) {
            this.f12506f.m11236a();
            this.f12506f = null;
        }
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
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
    public void m13373a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13376b() {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteOldChatRooms()", ActivityChat.class.getSimpleName());
        }
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f12502b, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f12506f = new C2660e(this.f12502b, 3);
            this.f12506f.m11242c();
        }
    }

    /* renamed from: c */
    private String m13378c() throws Resources.NotFoundException {
        String string = GlobalApplication.m10283b().getString(R.string.chaton_default);
        int iIntValue = C4809aa.m18104a().m18120a("Default Font Typeface", (Integer) (-1)).intValue();
        if (iIntValue != -1) {
            if (C4809aa.m18104a().m18129b("Default Font Name")) {
                return C4809aa.m18104a().m18121a("Default Font Name", string);
            }
            ArrayList<String> arrayListM9901a = C2197k.m9901a(GlobalApplication.m18732r(), Integer.toString(iIntValue));
            if (arrayListM9901a != null) {
                string = arrayListM9901a.get(0);
            }
            C4809aa.m18104a().m18128b("Default Font Name", string);
            return string;
        }
        return string;
    }

    /* renamed from: d */
    private String m13379d() throws Resources.NotFoundException {
        String strName = EnumC3594ed.m13899a(C4809aa.m18104a().m18121a("Default Font Size", EnumC3594ed.Normal.m13900a())).name();
        GlobalApplication.m10283b().getString(R.string.chat_font_medium);
        if (strName.equals(EnumC3594ed.System.name())) {
            return GlobalApplication.m10283b().getString(R.string.use_device_font_size);
        }
        if (strName.equals(EnumC3594ed.Tiny.name())) {
            return GlobalApplication.m10283b().getString(R.string.chat_font_extra_small);
        }
        if (strName.equals(EnumC3594ed.Small.name())) {
            return GlobalApplication.m10283b().getString(R.string.chat_font_small);
        }
        if (strName.equals(EnumC3594ed.Normal.name())) {
            return GlobalApplication.m10283b().getString(R.string.chat_font_medium);
        }
        if (strName.equals(EnumC3594ed.Large.name())) {
            return GlobalApplication.m10283b().getString(R.string.chat_font_large);
        }
        return GlobalApplication.m10283b().getString(R.string.chat_font_extra_large);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            m13373a(m13379d(), findPreference("pref_item_font_size"), getResources().getColor(R.color.buddy_list_item_status_changed));
        }
    }
}
