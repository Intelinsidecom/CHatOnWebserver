package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.settings.AboutNewNotice;
import com.sec.chaton.settings.AlertDialogC2481co;
import com.sec.chaton.settings.C2480cn;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentAlerts extends BasePreferenceFragment implements View.OnClickListener, Runnable {
    public static final int MUTE_HOUR = 0;
    public static final int MUTE_MANUALLY = 2;
    public static final int MUTE_NONE = 3;
    public static final int MUTE_UNTIL_7 = 1;
    public static final int POPUP_INPUT = 1;
    public static final int POPUP_SIMPLE = 0;
    protected static final int SET_RINGTONE = 2;
    private String[] alertTypes;

    /* renamed from: am */
    AlarmManager f10383am;
    private Context ctx;
    private PreferenceActivity mActivity;
    private int mCurrentPopupType;
    private int mSelectedPopupType;
    private String[] optionText;
    AboutNewNotice prefItemAbout;
    CheckBoxPreference prefItemAlertNewGroupChat;
    CheckBoxPreference prefItemBlackscreenPopup;
    CheckBoxPreference prefItemNotification;
    private Preference prefItemPopupType;
    CheckBoxPreference prefItemReceivedMessage;
    private Preference prefMuteAlert;
    private Preference prefSettingType;
    String tag = "Settings";
    private C3160ab sharedPref = null;
    private boolean isDisplayReceiveMessageChecked = true;
    private boolean isDisplayBlackscreenPopup = true;
    private boolean isAlertNewGroupChat = true;
    private boolean isNotificationReceive = true;
    private int mCurrentMuteType = 3;
    InterfaceC3274d muteTypeDialog = null;
    AlertDialogC2481co muteTimeDialog = null;
    DialogInterface.OnClickListener mMuteItemClickListener = new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.10
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
            Calendar calendar = Calendar.getInstance();
            switch (i) {
                case 0:
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(jCurrentTimeMillis));
                    C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(3600000 + jCurrentTimeMillis));
                    C3159aa.m10962a().m10984b("Setting mute type", (Integer) 0);
                    C3641ai.m13210a(PrefFragmentAlerts.this.ctx, R.string.settings_mute_set_toast, 0).show();
                    PrefFragmentAlerts.this.setNotiMuteType();
                    break;
                case 1:
                    calendar.add(5, 1);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), 7, 0);
                    C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(calendar.getTimeInMillis()));
                    C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(calendar2.getTimeInMillis()));
                    C3159aa.m10962a().m10984b("Setting mute type", (Integer) 1);
                    C3641ai.m13210a(PrefFragmentAlerts.this.ctx, R.string.settings_mute_set_toast, 0).show();
                    PrefFragmentAlerts.this.setNotiMuteType();
                    break;
                case 2:
                    PrefFragmentAlerts.this.displayManuallyDialog();
                    break;
                case 3:
                    C3159aa.m10962a().m10984b("Setting mute type", (Integer) 3);
                    C3159aa.m10962a().m10981a("Setting mute hour start Long");
                    C3159aa.m10962a().m10981a("Setting mute hour end Long");
                    C3159aa.m10962a().m10981a("Setting mute repeat");
                    PrefFragmentAlerts.this.setNotiMuteType();
                    break;
            }
            PrefFragmentAlerts.this.muteTypeDialog.dismiss();
        }
    };
    DialogInterface.OnClickListener mMuteTimeClickListener = new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.11
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
            C2480cn c2480cnM9255a = PrefFragmentAlerts.this.muteTimeDialog.m9255a();
            if (c2480cnM9255a.m9217a() > c2480cnM9255a.m9218b()) {
                c2480cnM9255a.m9219c();
            } else if (c2480cnM9255a.m9218b() < System.currentTimeMillis()) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("end time is expired. set to next day", "Mute Manually");
                }
                c2480cnM9255a.m9220d();
                c2480cnM9255a.m9219c();
            }
            C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(c2480cnM9255a.m9217a()));
            C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(c2480cnM9255a.m9218b()));
            C3159aa.m10962a().m10984b("Setting mute type", (Integer) 2);
            C3159aa.m10962a().m10983b("Setting mute repeat", Boolean.valueOf(c2480cnM9255a.m9221e()));
            if (PrefFragmentAlerts.this.muteTimeDialog != null && PrefFragmentAlerts.this.muteTimeDialog.isShowing()) {
                PrefFragmentAlerts.this.muteTimeDialog.setDismissMessage(null);
                PrefFragmentAlerts.this.muteTimeDialog.dismiss();
            }
            C3641ai.m13210a(PrefFragmentAlerts.this.ctx, R.string.settings_mute_set_toast, 0).show();
            PrefFragmentAlerts.this.setNotiMuteType();
        }
    };
    DialogInterface.OnClickListener mPopupTypeItemClickListener = new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.12
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                PrefFragmentAlerts.this.mSelectedPopupType = 0;
            } else {
                PrefFragmentAlerts.this.mSelectedPopupType = 1;
            }
        }
    };

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mActivity = (PreferenceActivity) getActivity();
        C3225cm.m11337a(getActivity());
        super.onCreate(bundle);
        if (bundle == null && getActivity().getIntent().hasExtra("gotoAlert")) {
            getActivity().getWindow().addFlags(4194304);
        }
        addPreferencesFromResource(R.xml.pref_setting_noti);
        this.ctx = getActivity();
        this.sharedPref = C3159aa.m10962a();
        this.sharedPref.m10983b("Lock Check", (Boolean) false);
        this.f10383am = (AlarmManager) this.ctx.getSystemService("alarm");
        this.optionText = this.ctx.getResources().getStringArray(R.array.settings_type_options_value);
        this.alertTypes = this.ctx.getResources().getStringArray(R.array.settings_type_options);
        try {
            initializeForPreference();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    private void initializeForPreference() throws Resources.NotFoundException {
        boolean zBooleanValue;
        this.prefItemNotification = (CheckBoxPreference) findPreference("pref_item_push_notification");
        if (this.sharedPref.m10977a("Setting Notification", (Boolean) true).booleanValue()) {
            this.isNotificationReceive = true;
            this.sharedPref.m10983b("Setting Notification", (Boolean) true);
        } else {
            this.isNotificationReceive = false;
            this.sharedPref.m10983b("Setting Notification", (Boolean) false);
        }
        this.prefItemNotification.setChecked(this.isNotificationReceive);
        setTextWitColor(getResources().getString(R.string.push_notification_text), this.prefItemNotification, getResources().getColor(R.color.setting_explain_text));
        this.prefItemNotification.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !"true".equals(str)) {
                    PrefFragmentAlerts.this.isNotificationReceive = false;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting Notification", (Boolean) false);
                    PrefFragmentAlerts.this.setNotiSettingType(false);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100011", "00000002");
                    }
                } else {
                    PrefFragmentAlerts.this.isNotificationReceive = true;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting Notification", (Boolean) true);
                    PrefFragmentAlerts.this.setNotiSettingType(true);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100011", "00000001");
                    }
                }
                return true;
            }
        });
        this.prefItemBlackscreenPopup = (CheckBoxPreference) findPreference("pref_item_blackscreen_popup");
        if (this.sharedPref.m10977a("Setting show blackscreen popup", (Boolean) true).booleanValue()) {
            this.isDisplayBlackscreenPopup = true;
            this.sharedPref.m10983b("Setting show blackscreen popup", (Boolean) true);
        } else {
            this.isDisplayBlackscreenPopup = false;
            this.sharedPref.m10983b("Setting show blackscreen popup", (Boolean) false);
        }
        this.prefItemBlackscreenPopup.setChecked(this.isDisplayBlackscreenPopup);
        setTextWitColor(getResources().getString(R.string.settings_popup_information), this.prefItemBlackscreenPopup, getResources().getColor(R.color.setting_explain_text));
        this.prefItemBlackscreenPopup.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentAlerts.this.isDisplayBlackscreenPopup = false;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting show blackscreen popup", (Boolean) false);
                } else {
                    PrefFragmentAlerts.this.isDisplayBlackscreenPopup = true;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting show blackscreen popup", (Boolean) true);
                }
                return true;
            }
        });
        this.prefItemPopupType = findPreference("pref_item_popup_type");
        if (this.sharedPref.m10987b("Setting is simple popup")) {
            zBooleanValue = this.sharedPref.m10977a("Setting is simple popup", (Boolean) true).booleanValue();
        } else {
            this.sharedPref.m10983b("Setting is simple popup", (Boolean) true);
            zBooleanValue = true;
        }
        if (zBooleanValue) {
            setTextWitColor(getResources().getString(R.string.settings_simple_popup), this.prefItemPopupType, getResources().getColor(R.color.buddy_list_item_status_changed));
            this.mCurrentPopupType = 0;
        } else {
            setTextWitColor(getResources().getString(R.string.settings_input_popup), this.prefItemPopupType, getResources().getColor(R.color.buddy_list_item_status_changed));
            this.mCurrentPopupType = 1;
        }
        this.prefItemPopupType.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                PrefFragmentAlerts.this.muteTypeDialog = AbstractC3271a.m11494a(PrefFragmentAlerts.this.ctx).mo11495a(R.string.settings_popup_type_title).mo11496a(R.array.setting_alert_type, PrefFragmentAlerts.this.mCurrentPopupType, PrefFragmentAlerts.this.mPopupTypeItemClickListener).mo11510b(PrefFragmentAlerts.this.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
                        String string;
                        PrefFragmentAlerts.this.mCurrentPopupType = PrefFragmentAlerts.this.mSelectedPopupType;
                        if (PrefFragmentAlerts.this.mCurrentPopupType == 0) {
                            string = PrefFragmentAlerts.this.getResources().getString(R.string.settings_simple_popup);
                            PrefFragmentAlerts.this.sharedPref.m10983b("Setting is simple popup", (Boolean) true);
                        } else {
                            string = PrefFragmentAlerts.this.getResources().getString(R.string.settings_input_popup);
                            PrefFragmentAlerts.this.sharedPref.m10983b("Setting is simple popup", (Boolean) false);
                        }
                        PrefFragmentAlerts.this.setTextWitColor(string, PrefFragmentAlerts.this.prefItemPopupType, PrefFragmentAlerts.this.getResources().getColor(R.color.buddy_list_item_status_changed));
                    }
                }).mo11501a(PrefFragmentAlerts.this.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return true;
            }
        });
        this.prefItemAlertNewGroupChat = (CheckBoxPreference) findPreference("pref_item_alert_group_chat");
        if (this.sharedPref.m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue()) {
            this.isAlertNewGroupChat = true;
            this.sharedPref.m10983b("Setting alert_new_groupchat", (Boolean) true);
        } else {
            this.isAlertNewGroupChat = false;
            this.sharedPref.m10983b("Setting alert_new_groupchat", (Boolean) false);
        }
        this.prefItemAlertNewGroupChat.setChecked(this.isAlertNewGroupChat);
        setTextWitColor(getResources().getString(R.string.setting_alert_new_group_chat_description), this.prefItemAlertNewGroupChat, getResources().getColor(R.color.setting_explain_text));
        this.prefItemAlertNewGroupChat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.4
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentAlerts.this.isAlertNewGroupChat = false;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting alert_new_groupchat", (Boolean) false);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100011", "00000006");
                    }
                } else {
                    PrefFragmentAlerts.this.isAlertNewGroupChat = true;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting alert_new_groupchat", (Boolean) true);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100011", "00000005");
                    }
                }
                return true;
            }
        });
        this.prefItemReceivedMessage = (CheckBoxPreference) findPreference("pref_item_received_message");
        if (this.sharedPref.m10977a("Setting show receive message", (Boolean) true).booleanValue()) {
            this.isDisplayReceiveMessageChecked = true;
            this.sharedPref.m10983b("Setting show receive message", (Boolean) true);
        } else {
            this.isDisplayReceiveMessageChecked = false;
            this.sharedPref.m10983b("Setting show receive message", (Boolean) false);
        }
        this.prefItemReceivedMessage.setChecked(this.isDisplayReceiveMessageChecked);
        setTextWitColor(getResources().getString(R.string.settings_received_message_summary), this.prefItemReceivedMessage, getResources().getColor(R.color.setting_explain_text));
        this.prefItemReceivedMessage.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.5
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentAlerts.this.isDisplayReceiveMessageChecked = false;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting show receive message", (Boolean) false);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100011", "00000004");
                    }
                } else {
                    PrefFragmentAlerts.this.isDisplayReceiveMessageChecked = true;
                    PrefFragmentAlerts.this.sharedPref.m10983b("Setting show receive message", (Boolean) true);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100011", "00000003");
                    }
                }
                return true;
            }
        });
        this.prefSettingType = findPreference("pref_item_type");
        if (this.sharedPref.m10979a("Set Type Text", "") == "") {
            this.sharedPref.m10986b("Set Type Text", this.ctx.getResources().getStringArray(R.array.settings_type_options_value)[0]);
        }
        setNotiSettingType(this.isNotificationReceive);
        this.prefSettingType.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.6
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                PrefFragmentAlerts.this.mActivity.startPreferencePanel(PrefFragmentAlertType.class.getName(), new Bundle(), 0, PrefFragmentAlerts.this.mActivity.getString(R.string.settings_type), null, 0);
                return false;
            }
        });
        if (C3159aa.m10962a().m10978a(C3250y.f11739g, (Integer) 0).intValue() > 0) {
            final Preference preference = new Preference(getActivity());
            preference.setTitle(R.string.settings_push_status);
            preference.setKey("pref_item_push_status");
            preference.setOrder(0);
            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.7
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference2) {
                    AbstractC3271a.m11494a(PrefFragmentAlerts.this.getActivity()).mo11509b(C0817b.m4370a(PrefFragmentAlerts.this.getActivity())).mo11515d(android.R.string.ok, null).mo11512b();
                    return false;
                }
            });
            getPreferenceScreen().addPreference(preference);
            C1302ao.m5594a().mo5482c(new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.8
                @Override // android.os.Handler
                @TargetApi(11)
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == 1003) {
                        boolean zBooleanValue2 = ((Boolean) message.obj).booleanValue();
                        if (GlobalApplication.f5511a == null) {
                            zBooleanValue2 = false;
                        }
                        if (zBooleanValue2) {
                            PrefFragmentAlerts.this.setTextWitColor(PrefFragmentAlerts.this.getString(R.string.settings_push_status_available), preference, PrefFragmentAlerts.this.getResources().getColor(R.color.buddy_list_item_status_changed));
                        } else {
                            PrefFragmentAlerts.this.setTextWitColor(PrefFragmentAlerts.this.getString(R.string.settings_push_status_unavailable), preference, PrefFragmentAlerts.this.getResources().getColor(R.color.buddy_list_item_status_changed));
                        }
                    }
                }
            });
        }
        this.prefMuteAlert = findPreference("pref_item_mute");
        C1103a.m5432a(this.ctx).m5472g();
        setNotiMuteType();
        this.prefMuteAlert.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAlerts.9
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference2) {
                PrefFragmentAlerts.this.muteTypeDialog = AbstractC3271a.m11494a(PrefFragmentAlerts.this.ctx).mo11495a(R.string.settings_mute_alert).mo11497a(R.array.settings_mute_alert_type, PrefFragmentAlerts.this.mMuteItemClickListener).mo11512b();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayManuallyDialog() {
        this.muteTimeDialog = new AlertDialogC2481co(this.ctx);
        this.muteTimeDialog.setButton(-2, this.ctx.getText(R.string.dialog_ok), this.mMuteTimeClickListener);
        this.muteTimeDialog.setButton(-1, this.ctx.getText(R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        this.muteTimeDialog.show();
    }

    private String getFormatedTime(Long l) {
        return new SimpleDateFormat("HH:mm").format(l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void setNotiMuteType() throws Resources.NotFoundException {
        this.mCurrentMuteType = C3159aa.m10962a().m10978a("Setting mute type", (Integer) 3).intValue();
        String string = "";
        switch (this.mCurrentMuteType) {
            case 0:
                string = getFormatedTime(Long.valueOf(C3159aa.m10962a().m10976a("Setting mute hour start Long", 0L))) + " ~ " + getFormatedTime(Long.valueOf(C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L)));
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
        setTextWitColor(string, this.prefMuteAlert, getResources().getColor(R.color.buddy_list_item_status_changed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void setNotiSettingType(boolean z) {
        String str;
        int i = 0;
        String strM10979a = this.sharedPref.m10979a("Set Type Text", this.ctx.getResources().getStringArray(R.array.settings_type_options_value)[0]);
        while (true) {
            if (i >= this.optionText.length) {
                str = strM10979a;
                break;
            } else if (!strM10979a.equals(this.optionText[i])) {
                i++;
            } else {
                str = this.alertTypes[i];
                break;
            }
        }
        setTextWitColor(str, this.prefSettingType, getResources().getColor(R.color.buddy_list_item_status_changed));
        this.prefItemBlackscreenPopup.setEnabled(z);
        this.prefItemReceivedMessage.setEnabled(z);
        this.prefItemAlertNewGroupChat.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getWindow().clearFlags(4194304);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setNotiSettingType(this.isNotificationReceive);
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
