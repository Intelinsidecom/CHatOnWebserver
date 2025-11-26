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
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v4.content.C0096i;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.ActivityLocalBackup;
import com.sec.chaton.multimedia.emoticon.anicon.AniconSortListActivity;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.settings.AboutNewNotice;
import com.sec.chaton.settings.ActivityAboutService;
import com.sec.chaton.settings.ActivityAccount;
import com.sec.chaton.settings.ActivityChat;
import com.sec.chaton.settings.ActivityContactSync;
import com.sec.chaton.settings.ActivityDeregister;
import com.sec.chaton.settings.ActivityManageAccounts;
import com.sec.chaton.settings.ActivityManageBuddy;
import com.sec.chaton.settings.ActivityMultiDeviceView;
import com.sec.chaton.settings.ActivityNoti2;
import com.sec.chaton.settings.ActivityPrivacy;
import com.sec.chaton.settings.BasePreferenceActivity;
import com.sec.chaton.settings.C3640fw;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.SMSPreferenceActivity;
import com.sec.chaton.smsplugin.p112ui.SpamSettingActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.logcollector.LogCollectService;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class SettingActivity extends BasePreferenceActivity implements Preference.OnPreferenceClickListener {
    private static final String PREF_SETTING_ACCOUNT = "pref_setting_account";
    private static final String PREF_SETTING_CATEGORY_COMMON = "pref_setting_common";
    private static final String PREF_SETTING_CATEGORY_CONNECTION_INFO = "pref_setting_category_connection_info";
    private static final String PREF_SETTING_CATEGORY_MESSAGE_CHATS = "pref_setting_message_chats";
    private static final String PREF_SETTING_CATEGORY_SERVICE_INFO = "pref_setting_category_service_info";
    private static final String PREF_SETTING_CATEGORY_SYNC_BACKUP = "pref_setting_sync_backup";
    private static final String PREF_SETTING_LEGACY_ABOUT = "pref_setting_legacy_about";
    private static final String PREF_SETTING_LEGACY_ALERTS = "pref_setting_legacy_alerts";
    private static final String PREF_SETTING_LEGACY_CALL_SETTINGS = "pref_setting_legacy_call_settings";
    private static final String PREF_SETTING_LEGACY_CHAT_DISPLAY = "pref_setting_legacy_chat_display";
    private static final String PREF_SETTING_LEGACY_CONNECTED_DEVICES = "pref_setting_legacy_connected_devices";
    private static final String PREF_SETTING_LEGACY_CONTACT_SYNC = "pref_setting_legacy_contact_sync";
    private static final String PREF_SETTING_LEGACY_DELETE_ACCOUNT = "pref_setting_legacy_delete_account";
    private static final String PREF_SETTING_LEGACY_LOG_COLLECTOR = "pref_setting_legacy_log_collector";
    private static final String PREF_SETTING_LEGACY_MANAGE_ACCOUNTS = "pref_setting_legacy_manage_accounts";
    private static final String PREF_SETTING_LEGACY_MANAGE_BUDDIES = "pref_setting_legacy_manage_buddies";
    private static final String PREF_SETTING_LEGACY_MANAGE_STICKERS = "pref_setting_legacy_manage_stickers";
    private static final String PREF_SETTING_LEGACY_PREF_SCREEN = "pref_setting_legacy_pref_screen";
    private static final String PREF_SETTING_LEGACY_PRIVACY = "pref_setting_legacy_privacy";
    private static final String PREF_SETTING_LEGACY_SEND_LOG = "pref_setting_legacy_send_log";
    private static final String PREF_SETTING_LOCAL_BACKUP = "pref_setting_backup";
    private static final String PREF_SETTING_SMS_MMS = "pref_setting_sms_mms";
    private static final String PREF_SETTING_SPAM_MESSAGES = "pref_setting_spam_messages";
    private static final String PREF_SETTING_TERMINATION_SERVICE_INFO = "pref_setting_termination_of_service";
    private static List<PreferenceActivity.Header> _headers;
    private C0416a mChatonV;
    private PreferenceCategory mPrefCategoryConnection;
    private Preference mPrefConnectedDivices;
    private AboutNewNotice prefAbout;
    private Preference prefSpamMessages;
    private AbstractC1899a<?> pushControl;
    private final View deleteAccountlayout = null;
    private ProgressDialog progressBar = null;
    private boolean isDestroy = false;
    private boolean removeContactSyncPref = false;
    PreferenceCategory prefCategorySyncBackup = null;
    Preference prefContactSync = null;
    private final BroadcastReceiver mSettingNewBadgeReceiver = new BroadcastReceiver() { // from class: com.sec.chaton.settings2.SettingActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SettingActivity.this.updateSettingTabBadge();
        }
    };

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.pref_setting_legacy);
        initializeLegacyPreferences();
        this.pushControl = C2093az.m9337a();
        this.pushControl.mo9080c(new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.SettingActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1003) {
                    if (((Boolean) message.obj).booleanValue()) {
                        C4809aa.m18104a().m18125b("spp_available", (Boolean) true);
                    } else {
                        C4809aa.m18104a().m18125b("spp_available", (Boolean) false);
                    }
                }
            }
        });
        if (bundle == null && getIntent().hasExtra("gotoAlert")) {
            Intent intent = new Intent(this, (Class<?>) ActivityNoti2.class);
            intent.putExtra("gotoAlert", true);
            startActivity(intent);
        }
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
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume", getClass().getSimpleName());
        Preference preferenceFindPreference = findPreference(PREF_SETTING_LEGACY_ALERTS);
        if (!C4822an.m18218a()) {
            if (!C4809aa.m18104a().m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue()) {
                preferenceFindPreference.setEnabled(false);
                setTitleTextWitColor(getString(R.string.setting_notifications), preferenceFindPreference, getResources().getColor(R.color.setting_explain_text));
            } else {
                preferenceFindPreference.setEnabled(true);
                setTitleTextWitColor(getString(R.string.setting_notifications), preferenceFindPreference, getResources().getColor(R.color.color2));
                preferenceFindPreference.setOnPreferenceClickListener(this);
            }
        }
        ListView listView = getListView();
        if (listView != null) {
            listView.setItemsCanFocus(true);
        }
        updateSettingTabBadge();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("more_tab_badge_update");
        C0096i.m358a(getApplicationContext()).m362a(this.mSettingNewBadgeReceiver, intentFilter);
        if (this.mPrefConnectedDivices != null && C4822an.m18255w()) {
            PreferenceScreen preferenceScreen = (PreferenceScreen) findPreference(PREF_SETTING_LEGACY_PREF_SCREEN);
            if (preferenceScreen != null) {
                preferenceScreen.addPreference(this.mPrefCategoryConnection);
            }
            if (this.mPrefCategoryConnection != null) {
                this.mPrefCategoryConnection.addPreference(this.mPrefConnectedDivices);
            }
        }
        if (this.prefContactSync == null) {
            this.prefContactSync = findPreference(PREF_SETTING_LEGACY_CONTACT_SYNC);
        }
        if (C2349a.m10301a("sms_feature") || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            if (this.removeContactSyncPref) {
                this.prefCategorySyncBackup.addPreference(this.prefContactSync);
                this.prefContactSync.setOnPreferenceClickListener(this);
                this.removeContactSyncPref = false;
            }
            if (C2349a.m10301a("support_contact_auto_sync")) {
                this.prefContactSync.setSummary(setSummaryAutoContactSync());
            } else {
                this.prefContactSync.setSummary(setSummaryContactSync());
            }
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(PREF_SETTING_CATEGORY_MESSAGE_CHATS);
        if (preferenceCategory != null && this.prefSpamMessages != null) {
            if (!C4822an.m18223b()) {
                preferenceCategory.removePreference(this.prefSpamMessages);
            } else {
                preferenceCategory.addPreference(this.prefSpamMessages);
            }
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy", getClass().getSimpleName());
        this.isDestroy = true;
        if (this.progressBar != null && this.progressBar.isShowing()) {
            this.progressBar.dismiss();
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause", getClass().getSimpleName());
        C0096i.m358a(getApplicationContext()).m361a(this.mSettingNewBadgeReceiver);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart", getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity
    public void onBuildHeaders(List<PreferenceActivity.Header> list) {
        super.onBuildHeaders(list);
        _headers = list;
    }

    private void initializeLegacyPreferences() {
        PreferenceScreen preferenceScreen = (PreferenceScreen) findPreference(PREF_SETTING_LEGACY_PREF_SCREEN);
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(PREF_SETTING_CATEGORY_COMMON);
        PreferenceCategory preferenceCategory2 = (PreferenceCategory) findPreference(PREF_SETTING_CATEGORY_MESSAGE_CHATS);
        this.prefCategorySyncBackup = (PreferenceCategory) findPreference(PREF_SETTING_CATEGORY_SYNC_BACKUP);
        this.mPrefCategoryConnection = (PreferenceCategory) findPreference(PREF_SETTING_CATEGORY_CONNECTION_INFO);
        PreferenceCategory preferenceCategory3 = (PreferenceCategory) findPreference(PREF_SETTING_CATEGORY_SERVICE_INFO);
        this.mChatonV = new C0416a();
        Preference preferenceFindPreference = findPreference(PREF_SETTING_ACCOUNT);
        preferenceFindPreference.setOnPreferenceClickListener(this);
        Preference preferenceFindPreference2 = findPreference(PREF_SETTING_LEGACY_PRIVACY);
        preferenceFindPreference2.setOnPreferenceClickListener(this);
        findPreference(PREF_SETTING_LEGACY_ALERTS).setOnPreferenceClickListener(this);
        Preference preferenceFindPreference3 = findPreference(PREF_SETTING_TERMINATION_SERVICE_INFO);
        preferenceFindPreference3.setOnPreferenceClickListener(this);
        Preference preferenceFindPreference4 = findPreference(PREF_SETTING_LEGACY_CALL_SETTINGS);
        if (C2948h.m12190a().m12192a(this, EnumC2949i.ChatONV) && this.mChatonV.m1495d(this) && (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) || C4822an.m18255w())) {
            preferenceFindPreference4.setOnPreferenceClickListener(this);
        } else {
            preferenceCategory.removePreference(preferenceFindPreference4);
        }
        Preference preferenceFindPreference5 = findPreference(PREF_SETTING_LEGACY_MANAGE_BUDDIES);
        preferenceFindPreference5.setOnPreferenceClickListener(this);
        Preference preferenceFindPreference6 = findPreference(PREF_SETTING_LEGACY_CHAT_DISPLAY);
        preferenceFindPreference6.setOnPreferenceClickListener(this);
        findPreference(PREF_SETTING_LEGACY_MANAGE_STICKERS).setOnPreferenceClickListener(this);
        Preference preferenceFindPreference7 = findPreference(PREF_SETTING_LEGACY_DELETE_ACCOUNT);
        if (C4809aa.m18104a().m18119a("hidden_skip_mode", (Boolean) false).booleanValue()) {
            preferenceFindPreference7.setOnPreferenceClickListener(this);
        } else {
            preferenceCategory.removePreference(preferenceFindPreference7);
        }
        Preference preferenceFindPreference8 = findPreference(PREF_SETTING_SMS_MMS);
        preferenceFindPreference8.setOnPreferenceClickListener(this);
        this.prefSpamMessages = findPreference(PREF_SETTING_SPAM_MESSAGES);
        this.prefSpamMessages.setOnPreferenceClickListener(this);
        this.prefContactSync = findPreference(PREF_SETTING_LEGACY_CONTACT_SYNC);
        if (C2349a.m10301a("sms_feature") || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            if (C2349a.m10301a("support_contact_auto_sync")) {
                this.prefContactSync.setSummary(setSummaryAutoContactSync());
            } else {
                this.prefContactSync.setSummary(setSummaryContactSync());
            }
            this.prefContactSync.setOnPreferenceClickListener(this);
        } else {
            this.prefCategorySyncBackup.removePreference(this.prefContactSync);
            this.removeContactSyncPref = true;
        }
        Preference preferenceFindPreference9 = findPreference(PREF_SETTING_LOCAL_BACKUP);
        if (C2349a.m10301a("local_backup_feature")) {
            preferenceFindPreference9.setOnPreferenceClickListener(this);
        } else {
            this.prefCategorySyncBackup.removePreference(preferenceFindPreference9);
        }
        this.mPrefConnectedDivices = findPreference(PREF_SETTING_LEGACY_CONNECTED_DEVICES);
        if (C4822an.m18218a()) {
            this.mPrefConnectedDivices.setOnPreferenceClickListener(this);
        }
        this.prefAbout = (AboutNewNotice) findPreference(PREF_SETTING_LEGACY_ABOUT);
        this.prefAbout.setOnPreferenceClickListener(this);
        Preference preferenceFindPreference10 = findPreference(PREF_SETTING_LEGACY_SEND_LOG);
        preferenceFindPreference10.setOnPreferenceClickListener(this);
        if (C4904y.m18630a() <= 0) {
            preferenceCategory3.removePreference(preferenceFindPreference10);
        }
        Preference preferenceFindPreference11 = findPreference(PREF_SETTING_LEGACY_LOG_COLLECTOR);
        preferenceFindPreference11.setOnPreferenceClickListener(this);
        if (C4904y.m18630a() != 2) {
            preferenceCategory3.removePreference(preferenceFindPreference11);
        }
        if (!C2349a.m10301a("sms_feature") || !C3847e.m14692ax()) {
            preferenceCategory2.removePreference(preferenceFindPreference8);
        }
        if (!C2349a.m10301a("sms_feature")) {
            preferenceCategory2.removePreference(this.prefSpamMessages);
        }
        if (!C2349a.m10301a("sms_feature")) {
            preferenceScreen.removePreference(preferenceCategory2);
        }
        if (!C4822an.m18218a()) {
            preferenceCategory.removePreference(preferenceFindPreference);
            preferenceCategory.removePreference(preferenceFindPreference4);
            this.mPrefCategoryConnection.removePreference(this.mPrefConnectedDivices);
            preferenceScreen.removePreference(this.mPrefCategoryConnection);
            if (!C2349a.m10301a("privacy_lite_feature")) {
                preferenceCategory.removePreference(preferenceFindPreference2);
            }
            preferenceCategory.removePreference(preferenceFindPreference5);
            preferenceCategory.removePreference(preferenceFindPreference6);
            this.prefCategorySyncBackup.removePreference(preferenceFindPreference9);
            return;
        }
        if (!C4822an.m18255w()) {
            this.mPrefCategoryConnection.removePreference(this.mPrefConnectedDivices);
            preferenceScreen.removePreference(this.mPrefCategoryConnection);
        }
        preferenceCategory3.removePreference(preferenceFindPreference3);
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (PREF_SETTING_ACCOUNT.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityAccount.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_MANAGE_BUDDIES.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityManageBuddy.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_PRIVACY.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityPrivacy.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_ALERTS.equals(preference.getKey())) {
            if (!C4822an.m18218a() || !C2349a.m10301a("sms_feature")) {
            }
            startActivity(new Intent(this, (Class<?>) ActivityNoti2.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_CHAT_DISPLAY.equals(preference.getKey())) {
            if (!C4822an.m18218a() || C2349a.m10301a("sms_feature")) {
            }
            startActivity(new Intent(this, (Class<?>) ActivityChat.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_MANAGE_STICKERS.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) AniconSortListActivity.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_CALL_SETTINGS.equals(preference.getKey())) {
            Intent intentM1496e = this.mChatonV.m1496e(this);
            if (intentM1496e != null) {
                startActivity(C4822an.m18208a(intentM1496e));
                C4904y.m18639b("success : call log intent", "SettingActivity");
                return true;
            }
            C4904y.m18639b("fail : call log intent", "SettingActivity");
            return true;
        }
        if (PREF_SETTING_LEGACY_CONNECTED_DEVICES.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityMultiDeviceView.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_MANAGE_ACCOUNTS.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityManageAccounts.class));
            return true;
        }
        if (PREF_SETTING_LOCAL_BACKUP.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityLocalBackup.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_CONTACT_SYNC.equals(preference.getKey())) {
            if (!C4822an.m18218a() || !C2349a.m10301a("sms_feature")) {
            }
            if (C2349a.m10301a("sms_feature")) {
                startActivity(new Intent(this, (Class<?>) ActivityContactSync.class));
                return true;
            }
            if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                startActivity(new Intent(this, (Class<?>) ActivityRegist.class));
                return true;
            }
            startActivity(new Intent(this, (Class<?>) ActivityContactSync.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_ABOUT.equals(preference.getKey())) {
            if (!C4822an.m18218a() || C2349a.m10301a("sms_feature")) {
            }
            startActivity(new Intent(this, (Class<?>) ActivityAboutService.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_DELETE_ACCOUNT.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityDeregister.class));
            return true;
        }
        if (PREF_SETTING_TERMINATION_SERVICE_INFO.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) ActivityDeregister.class));
            return true;
        }
        if (PREF_SETTING_LEGACY_SEND_LOG.equals(preference.getKey())) {
            this.progressBar = ProgressDialogC4926s.m18727a(this, null, getResources().getString(R.string.wait_sending));
            C2093az.m9337a().mo9080c(new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.SettingActivity.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (!SettingActivity.this.isDestroy) {
                        super.handleMessage(message);
                        if (message.what == 1003) {
                            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                            if (GlobalApplication.f8355a == null) {
                                zBooleanValue = false;
                            }
                            C3640fw.m13919a(CommonApplication.m18732r(), zBooleanValue);
                            if (SettingActivity.this.progressBar != null && SettingActivity.this.progressBar.isShowing()) {
                                SettingActivity.this.progressBar.dismiss();
                            }
                        }
                    }
                }
            });
            return true;
        }
        if (PREF_SETTING_LEGACY_LOG_COLLECTOR.equals(preference.getKey())) {
            this.progressBar = ProgressDialogC4926s.m18727a(this, null, getResources().getString(R.string.wait_sending));
            LogCollectService.m18551a(new Handler() { // from class: com.sec.chaton.settings2.SettingActivity.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        C3640fw.m13921b(CommonApplication.m18732r(), false);
                        if (SettingActivity.this.progressBar != null && SettingActivity.this.progressBar.isShowing()) {
                            SettingActivity.this.progressBar.dismiss();
                        }
                    }
                }
            });
            LogCollectService.m18550a(GlobalApplication.m18732r(), true, true, false);
            return true;
        }
        if (PREF_SETTING_SPAM_MESSAGES.equals(preference.getKey())) {
            startActivity(new Intent(this, (Class<?>) SpamSettingActivity.class));
            return true;
        }
        if (!PREF_SETTING_SMS_MMS.equals(preference.getKey()) || !C2349a.m10301a("sms_feature") || !C3847e.m14692ax()) {
            return false;
        }
        startActivity(new Intent(this, (Class<?>) SMSPreferenceActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSettingTabBadge() {
        C4904y.m18641c(" Update contain is " + C4809aa.m18104a().m18129b("UpdateIsCritical"), getClass().getSimpleName());
        int i = C4809aa.m18104a().m18129b("UpdateIsCritical") ? 1 : 0;
        if (C2948h.m12190a().m12192a(GlobalApplication.m18732r(), EnumC2949i.ChatONV) && C4809aa.m18104a().m18120a("chatonVUpdateStatus", (Integer) 0).intValue() != 0) {
            i++;
        }
        if (C4809aa.m18104a().m18119a("spp_update_is", (Boolean) false).booleanValue()) {
            i++;
        }
        if (this.prefAbout != null) {
            this.prefAbout.m13296a(i > 0, i);
        }
    }

    private String setSummaryAutoContactSync() {
        StringBuilder sb = new StringBuilder();
        if (!C2349a.m10301a("sms_feature") && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            return "";
        }
        sb.append(getResources().getString(R.string.contact_auto_sync)).append(": ");
        if (C4809aa.m18104a().m18119a("auto_contact_sync", (Boolean) true).booleanValue()) {
            C4809aa.m18104a().m18125b("auto_contact_sync", (Boolean) true);
            sb.append(getResources().getString(R.string.settings_password_lock_text_on));
        } else {
            sb.append(getResources().getString(R.string.settings_password_lock_text_off));
        }
        sb.append("\n");
        long jLongValue = Long.valueOf(C4809aa.m18104a().m18121a("Setting Sync TimeInMillis", Spam.ACTIVITY_CANCEL)).longValue();
        if (jLongValue == 0) {
            sb.append(getResources().getString(R.string.settings_sync_contacts_not_synced_yet));
        } else {
            sb.append(getResources().getString(R.string.setting_contact_latest_sync) + ": ").append(DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(jLongValue))).append(" ").append(DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(jLongValue)));
        }
        return sb.toString();
    }

    private String setSummaryContactSync() {
        StringBuilder sb = new StringBuilder();
        if (!C2349a.m10301a("sms_feature") && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            return "";
        }
        long jLongValue = Long.valueOf(C4809aa.m18104a().m18121a("Setting Sync TimeInMillis", Spam.ACTIVITY_CANCEL)).longValue();
        if (jLongValue == 0) {
            sb.append(getResources().getString(R.string.settings_sync_contacts_not_synced_yet));
        } else {
            sb.append(getResources().getString(R.string.setting_contact_latest_sync) + ": ").append(DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(jLongValue))).append(" ").append(DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(jLongValue)));
        }
        return sb.toString();
    }

    private void setTitleTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }
}
