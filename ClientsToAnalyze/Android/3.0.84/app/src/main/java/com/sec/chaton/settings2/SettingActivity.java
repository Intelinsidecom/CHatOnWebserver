package com.sec.chaton.settings2;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.ActivityLocalBackup;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.settings.AboutNewNotice;
import com.sec.chaton.settings.ActivityAboutService;
import com.sec.chaton.settings.ActivityChat;
import com.sec.chaton.settings.ActivityContactSync;
import com.sec.chaton.settings.ActivityDeregister;
import com.sec.chaton.settings.ActivityManageBuddy;
import com.sec.chaton.settings.ActivityMultiDeviceView;
import com.sec.chaton.settings.ActivityNoti;
import com.sec.chaton.settings.ActivityPrivacy;
import com.sec.chaton.settings.BasePreferenceActivity;
import com.sec.chaton.settings.C2688ey;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SettingActivity extends BasePreferenceActivity implements Preference.OnPreferenceClickListener {
    private static final String PREF_SETTING_LEGACY_ABOUT = "pref_setting_legacy_about";
    private static final String PREF_SETTING_LEGACY_ALERTS = "pref_setting_legacy_alerts";
    private static final String PREF_SETTING_LEGACY_CALL_SETTINGS = "pref_setting_legacy_call_settings";
    private static final String PREF_SETTING_LEGACY_CHAT_DISPLAY = "pref_setting_legacy_chat_display";
    private static final String PREF_SETTING_LEGACY_CONNECTED_DEVICES = "pref_setting_legacy_connected_devices";
    private static final String PREF_SETTING_LEGACY_CONTACT_SYNC = "pref_setting_legacy_contact_sync";
    private static final String PREF_SETTING_LEGACY_DELETE_ACCOUNT = "pref_setting_legacy_delete_account";
    private static final String PREF_SETTING_LEGACY_MANAGE_ACCOUNTS = "pref_setting_legacy_manage_accounts";
    private static final String PREF_SETTING_LEGACY_MANAGE_BUDDIES = "pref_setting_legacy_manage_buddies";
    private static final String PREF_SETTING_LEGACY_PREF_SCREEN = "pref_setting_legacy_pref_screen";
    private static final String PREF_SETTING_LEGACY_PRIVACY = "pref_setting_legacy_privacy";
    private static final String PREF_SETTING_LEGACY_SEND_LOG = "pref_setting_legacy_send_log";
    private static final String PREF_SETTING_LOCAL_BACKUP = "pref_setting_backup";
    private static List<PreferenceActivity.Header> _headers;
    private C0045a mChatonV;
    private AboutNewNotice prefAbout;
    private AbstractC1144a<?> pushControl;
    private View deleteAccountlayout = null;
    private ProgressDialog progressBar = null;
    private boolean isDestroy = false;
    private HeaderAdapter headerAdapter = null;
    private BroadcastReceiver mSettingNewBadgeReceiver = new BroadcastReceiver() { // from class: com.sec.chaton.settings2.SettingActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SettingActivity.this.updateSettingTabBadge();
        }
    };

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C1493a.m6463a("tablet_enable_feature")) {
            addPreferencesFromResource(R.xml.pref_setting_legacy);
            initializeLegacyPreferences();
        } else {
            setTitle(R.string.setting_settings_title);
        }
        this.pushControl = C1302ao.m5594a();
        this.pushControl.mo5482c(new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.SettingActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1003) {
                    if (((Boolean) message.obj).booleanValue()) {
                        C3159aa.m10962a().m10983b("spp_available", (Boolean) true);
                    } else {
                        C3159aa.m10962a().m10983b("spp_available", (Boolean) false);
                    }
                }
            }
        });
        if (bundle == null && getIntent().hasExtra("gotoAlert")) {
            Intent intent = new Intent(this, (Class<?>) ActivityNoti.class);
            intent.putExtra("gotoAlert", true);
            startActivity(intent);
        }
        if (GlobalApplication.m6456e() && getIntent().hasExtra("fragment_choose")) {
            String stringExtra = getIntent().getStringExtra("fragment_choose");
            if (stringExtra.equals(PrefFragmentPrivacy.class.getName())) {
                switchToHeader(stringExtra, null);
            } else if (stringExtra.equals(PrefFragmentBirthday.class.getName())) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("fragment_choose", stringExtra);
                switchToHeader(PrefFragmentPrivacy.class.getName(), bundle2);
            }
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume", getClass().getSimpleName());
        ListView listView = getListView();
        if (listView != null) {
            listView.setItemsCanFocus(true);
            if (GlobalApplication.m6456e()) {
                listView.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_holo_light);
            }
        }
        updateSettingTabBadge();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("more_tab_badge_update");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.mSettingNewBadgeReceiver, intentFilter);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy", getClass().getSimpleName());
        this.isDestroy = true;
        if (this.progressBar != null && this.progressBar.isShowing()) {
            this.progressBar.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause", getClass().getSimpleName());
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.mSettingNewBadgeReceiver);
    }

    @Override // android.preference.PreferenceActivity
    public void onBuildHeaders(List<PreferenceActivity.Header> list) {
        super.onBuildHeaders(list);
        _headers = list;
        if (C1493a.m6463a("tablet_enable_feature")) {
            if (C1493a.m6463a("for_wifi_only_device")) {
                loadHeadersFromResource(R.xml.pref_setting_headers_forwifi, list);
            } else {
                loadHeadersFromResource(R.xml.pref_setting_headers, list);
            }
            if (C3159aa.m10962a().m10978a(C3250y.f11739g, (Integer) 0).intValue() <= 0) {
                Iterator<PreferenceActivity.Header> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PreferenceActivity.Header next = it.next();
                    if (next.id == 2131166528) {
                        list.remove(next);
                        break;
                    }
                }
            }
            this.mChatonV = new C0045a();
            if (!C1954g.m7916a().m7918a(this, EnumC1955h.ChatONV) || !this.mChatonV.m55d(this) || (TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", "")) && !C3171am.m11080r())) {
                for (PreferenceActivity.Header header : list) {
                    if (header.id == 2131166527) {
                        list.remove(header);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.preference.PreferenceActivity
    public void onHeaderClick(PreferenceActivity.Header header, int i) {
        super.onHeaderClick(header, i);
        if (header.id == 2131166528) {
            this.progressBar = ProgressDialogC3265l.m11489a(this, null, getResources().getString(R.string.wait_sending));
            C1302ao.m5594a().mo5482c(new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.SettingActivity.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (!SettingActivity.this.isDestroy) {
                        super.handleMessage(message);
                        if (message.what == 1003) {
                            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                            if (GlobalApplication.f5511a == null) {
                                zBooleanValue = false;
                            }
                            C2688ey.m9691a(CommonApplication.m11493l(), zBooleanValue);
                            if (SettingActivity.this.progressBar != null && SettingActivity.this.progressBar.isShowing()) {
                                SettingActivity.this.progressBar.dismiss();
                            }
                        }
                    }
                }
            });
        } else if (header.id == 2131166527) {
            Intent intentM56e = this.mChatonV.m56e(this);
            if (intentM56e != null) {
                startActivity(C3171am.m11044a(intentM56e));
                C3250y.m11450b("success : call log intent", "SettingActivity");
            } else {
                C3250y.m11450b("fail : call log intent", "SettingActivity");
            }
        }
        if (this.headerAdapter != null && header.id != 2131166527) {
            this.headerAdapter.setSelectedPosition(i);
            getListView().invalidateViews();
        }
    }

    @Override // android.app.ListActivity
    public void setListAdapter(ListAdapter listAdapter) {
        if (listAdapter == null) {
            super.setListAdapter(null);
        } else {
            this.headerAdapter = new HeaderAdapter(this, _headers);
            super.setListAdapter(this.headerAdapter);
        }
    }

    private void initializeLegacyPreferences() {
        PreferenceScreen preferenceScreen = (PreferenceScreen) findPreference(PREF_SETTING_LEGACY_PREF_SCREEN);
        this.mChatonV = new C0045a();
        findPreference(PREF_SETTING_LEGACY_MANAGE_BUDDIES).setOnPreferenceClickListener(this);
        findPreference(PREF_SETTING_LEGACY_PRIVACY).setOnPreferenceClickListener(this);
        findPreference(PREF_SETTING_LEGACY_ALERTS).setOnPreferenceClickListener(this);
        findPreference(PREF_SETTING_LEGACY_CHAT_DISPLAY).setOnPreferenceClickListener(this);
        Preference preferenceFindPreference = findPreference(PREF_SETTING_LEGACY_CALL_SETTINGS);
        if (C1954g.m7916a().m7918a(this, EnumC1955h.ChatONV) && this.mChatonV.m55d(this) && (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", "")) || C3171am.m11080r())) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
        } else {
            preferenceScreen.removePreference(preferenceFindPreference);
        }
        findPreference(PREF_SETTING_LEGACY_CONNECTED_DEVICES).setOnPreferenceClickListener(this);
        Preference preferenceFindPreference2 = findPreference(PREF_SETTING_LOCAL_BACKUP);
        if (C1493a.m6463a("local_backup_feature")) {
            preferenceFindPreference2.setOnPreferenceClickListener(this);
        } else {
            preferenceScreen.removePreference(preferenceFindPreference2);
        }
        Preference preferenceFindPreference3 = findPreference(PREF_SETTING_LEGACY_CONTACT_SYNC);
        if (C1493a.m6463a("support_contact_auto_sync")) {
            preferenceFindPreference3.setSummary(setSummaryContactSync());
        }
        preferenceFindPreference3.setOnPreferenceClickListener(this);
        this.prefAbout = (AboutNewNotice) findPreference(PREF_SETTING_LEGACY_ABOUT);
        this.prefAbout.setOnPreferenceClickListener(this);
        findPreference(PREF_SETTING_LEGACY_DELETE_ACCOUNT).setOnPreferenceClickListener(this);
        Preference preferenceFindPreference4 = findPreference(PREF_SETTING_LEGACY_SEND_LOG);
        preferenceFindPreference4.setOnPreferenceClickListener(this);
        if (C3159aa.m10962a().m10978a(C3250y.f11739g, (Integer) 0).intValue() <= 0) {
            preferenceScreen.removePreference(preferenceFindPreference4);
        }
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (PREF_SETTING_LEGACY_MANAGE_BUDDIES.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityManageBuddy.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_PRIVACY.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityPrivacy.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_ALERTS.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityNoti.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_CHAT_DISPLAY.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityChat.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_CALL_SETTINGS.equals(preference.getKey())) {
            Intent intentM56e = this.mChatonV.m56e(this);
            if (intentM56e != null) {
                startActivity(C3171am.m11044a(intentM56e));
                C3250y.m11450b("success : call log intent", "SettingActivity");
                return true;
            }
            C3250y.m11450b("fail : call log intent", "SettingActivity");
            return true;
        }
        if (PREF_SETTING_LEGACY_CONNECTED_DEVICES.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityMultiDeviceView.class));
            return true;
        }
        if (PREF_SETTING_LOCAL_BACKUP.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityLocalBackup.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_CONTACT_SYNC.equals(preference.getKey())) {
            if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
                startActivity(new Intent(this, (Class<?>) ActivityRegist.class));
                return true;
            }
            startActivity(new Intent(this, (Class<?>) ActivityContactSync.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_ABOUT.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityAboutService.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_DELETE_ACCOUNT.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityDeregister.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_SEND_LOG.equals(preference.getKey())) {
            this.progressBar = ProgressDialogC3265l.m11489a(this, null, getResources().getString(R.string.wait_sending));
            C1302ao.m5594a().mo5482c(new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.SettingActivity.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (!SettingActivity.this.isDestroy) {
                        super.handleMessage(message);
                        if (message.what == 1003) {
                            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                            if (GlobalApplication.f5511a == null) {
                                zBooleanValue = false;
                            }
                            C2688ey.m9691a(CommonApplication.m11493l(), zBooleanValue);
                            if (SettingActivity.this.progressBar != null && SettingActivity.this.progressBar.isShowing()) {
                                SettingActivity.this.progressBar.dismiss();
                            }
                        }
                    }
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSettingTabBadge() {
        C3250y.m11453c(" Update contain is " + C3159aa.m10962a().m10987b("UpdateIsCritical"), getClass().getSimpleName());
        int i = C3159aa.m10962a().m10987b("UpdateIsCritical") ? 1 : 0;
        if (C1954g.m7916a().m7918a(GlobalApplication.m11493l(), EnumC1955h.ChatONV) && C3159aa.m10962a().m10978a("chatonVUpdateStatus", (Integer) 0).intValue() != 0) {
            i++;
        }
        if (C3159aa.m10962a().m10977a("spp_update_is", (Boolean) false).booleanValue()) {
            i++;
        }
        if (this.prefAbout != null) {
            this.prefAbout.m8910a(i > 0, i);
        }
    }

    private String setSummaryContactSync() {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
            return "";
        }
        sb.append(getResources().getString(R.string.contact_auto_sync)).append(": ");
        if (C3159aa.m10962a().m10977a("auto_contact_sync", (Boolean) true).booleanValue()) {
            C3159aa.m10962a().m10983b("auto_contact_sync", (Boolean) true);
            sb.append(getResources().getString(R.string.settings_password_lock_text_on));
        } else {
            sb.append(getResources().getString(R.string.settings_password_lock_text_off));
        }
        sb.append("\n");
        long jLongValue = Long.valueOf(C3159aa.m10962a().m10979a("Setting Sync TimeInMillis", "0")).longValue();
        if (jLongValue == 0) {
            sb.append(getResources().getString(R.string.settings_sync_contacts_not_synced_yet));
        } else {
            sb.append(getResources().getString(R.string.setting_contact_latest_sync) + ": ").append(DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(jLongValue))).append(" ").append(DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(jLongValue)));
        }
        return sb.toString();
    }
}
