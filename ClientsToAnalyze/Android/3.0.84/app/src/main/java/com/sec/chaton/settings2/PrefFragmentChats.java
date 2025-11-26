package com.sec.chaton.settings2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p027e.C1439g;
import com.sec.chaton.p027e.p028a.C1367k;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings.AboutNewNotice;
import com.sec.chaton.settings.ActivityBgBubbleChange;
import com.sec.chaton.settings.ActivityChatView;
import com.sec.chaton.settings.ActivityFontChange;
import com.sec.chaton.settings.EnumC2504dk;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.log.collector.C3358h;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PrefFragmentChats extends BasePreferenceFragment {
    public static final String ALL_CHAT = "all_chat";
    public static final int BACKGROUND_COLOURS_BLACK = 1;
    public static final int BACKGROUND_COLOURS_DEFAULT = 0;
    public static final String CHANGE_BACKGROUND = "change_background";
    public static final String CHANGE_BUBBLE = "change_bubble";
    public static final String CHANGE_MODE = "change_mode";
    private static final int CONTROL_CODE = 7000;
    private static final int DELETE_OLD_MSGBOX = 1;
    public static final int DELETE_OLD_MSGBOX_FAILED = -1;
    public static final int DELETE_OLD_MSGBOX_NO_CHATROOM = 2;
    public static final int DELETE_OLD_MSGBOX_NO_OLD_CHATROOM = 1;
    public static final int DELETE_OLD_MSGBOX_SUCCESS = 0;
    public static final int METHOD_SET_TYPING_STATUS = 7001;
    public static final String ONE_CHAT = "one_chat";
    protected static final int SET_RINGTONE = 2;
    public static final String TYPE = "type";
    private Context ctx;
    private Activity mActivity;
    private ProgressDialog mDialog;
    private boolean mIsEnterKey;
    private CheckBoxPreference mPrefItemAutoResend;
    private C1377u mQueryHandler;
    AboutNewNotice prefItemAbout;
    private Preference prefItemChangeBubbleBackground;
    private Preference prefItemFontSize;
    private Preference prefItemFontStyle;
    private CheckBoxPreference prefItemTypingStatus;
    String tag = "Settings";
    private C3160ab sharedPref = null;
    private boolean mBackKeyIgnore = false;
    private boolean mTypingStatus = true;
    InterfaceC1378v mQueryListener = new InterfaceC1378v() { // from class: com.sec.chaton.settings2.PrefFragmentChats.5
        @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
        }

        @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
        public void onInsertComplete(int i, Object obj, Uri uri) {
        }

        @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
        public void onUpdateComplete(int i, Object obj, int i2) {
        }

        @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
        public void onDeleteComplete(int i, Object obj, int i2) {
            if (i == 1) {
                PrefFragmentChats.this.mDialog.dismiss();
                switch (i2) {
                    case -1:
                        Toast.makeText(PrefFragmentChats.this.ctx, R.string.settings_chat_delete_old_chat_rooms_failed_toast, 0).show();
                        if (C3250y.f11733a) {
                            C3250y.m11456e("No old Chatroom", getClass().getSimpleName());
                            break;
                        }
                        break;
                    case 0:
                        Toast.makeText(PrefFragmentChats.this.ctx, R.string.settings_chat_delete_old_chat_rooms_success_toast, 0).show();
                        if (C3250y.f11733a) {
                            C3250y.m11456e("Delete old Chat Rooms", getClass().getSimpleName());
                            break;
                        }
                        break;
                    case 1:
                    case 2:
                        Toast.makeText(PrefFragmentChats.this.ctx, R.string.settings_chat_delete_old_chat_rooms_no_chatroom_toast, 0).show();
                        if (C3250y.f11733a) {
                            C3250y.m11456e("No old Chatroom", getClass().getSimpleName());
                            break;
                        }
                        break;
                    default:
                        if (C3250y.f11733a) {
                            C3250y.m11456e("Delete old failed", getClass().getSimpleName());
                            break;
                        }
                        break;
                }
            }
        }
    };

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        this.mActivity = activity;
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.ctx = this.mActivity;
        this.mQueryHandler = new C1377u(this.ctx.getContentResolver(), this.mQueryListener);
        addPreferencesFromResource(R.xml.pref_setting_chats);
        this.sharedPref = C3159aa.m10962a();
        this.sharedPref.m10983b("Lock Check", (Boolean) false);
        try {
            initializeForPreference();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setTextWitColor(getFontName(), this.prefItemFontStyle, getResources().getColor(R.color.setting_explain_text));
        setTextWitColor(getFontSize(), this.prefItemFontSize, getResources().getColor(R.color.setting_explain_text));
    }

    @Override // android.preference.PreferenceFragment
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == this.prefItemChangeBubbleBackground) {
            Intent intent = new Intent(this.ctx, (Class<?>) ActivityBgBubbleChange.class);
            intent.putExtra(TYPE, ALL_CHAT);
            startActivity(intent);
            return false;
        }
        if (preference == this.prefItemFontStyle) {
            startActivity(new Intent(this.ctx, (Class<?>) ActivityFontChange.class));
            return true;
        }
        if (preference != this.prefItemFontSize) {
            return true;
        }
        startActivity(new Intent(this.ctx, (Class<?>) ActivityChatView.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    private void initializeForPreference() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        this.prefItemChangeBubbleBackground = preferenceScreen.findPreference("pref_item_change_bubble_background_style");
        this.prefItemFontStyle = preferenceScreen.findPreference("pref_item_font_style");
        setTextWitColor(getFontName(), this.prefItemFontStyle, getResources().getColor(R.color.setting_explain_text));
        this.prefItemFontSize = preferenceScreen.findPreference("pref_item_font_size");
        setTextWitColor(getFontSize(), this.prefItemFontSize, getResources().getColor(R.color.setting_explain_text));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("pref_item_enter_key");
        if (this.sharedPref.m10977a("Setting enter key", (Boolean) false).booleanValue()) {
            this.mIsEnterKey = true;
            this.sharedPref.m10983b("Setting enter key", (Boolean) true);
        } else {
            this.mIsEnterKey = false;
            this.sharedPref.m10983b("Setting enter key", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.mIsEnterKey);
        setTextWitColor(getResources().getString(R.string.settings_send_message_using_enter), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentChats.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentChats.this.mIsEnterKey = false;
                    PrefFragmentChats.this.sharedPref.m10983b("Setting enter key", (Boolean) false);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100013", "00000002");
                    }
                } else {
                    PrefFragmentChats.this.mIsEnterKey = true;
                    PrefFragmentChats.this.sharedPref.m10983b("Setting enter key", (Boolean) true);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100013", "00000001");
                    }
                }
                return true;
            }
        });
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preferenceScreen.findPreference("pref_item_push_to_talk_key");
        boolean zBooleanValue = this.sharedPref.m10977a("Setting push to talk", (Boolean) true).booleanValue();
        this.sharedPref.m10983b("Setting push to talk", Boolean.valueOf(zBooleanValue));
        checkBoxPreference2.setChecked(zBooleanValue);
        setTextWitColor(getString(R.string.settings_send_button_walkie_talkie), checkBoxPreference2, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentChats.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (obj != null) {
                    PrefFragmentChats.this.sharedPref.m10983b("Setting push to talk", Boolean.valueOf(Boolean.parseBoolean(obj.toString())));
                    if (Boolean.parseBoolean(obj.toString())) {
                        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                            C3358h.m11842a().m11847a("00100013", "00000003");
                        }
                    } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100013", "00000004");
                    }
                }
                return true;
            }
        });
        this.mPrefItemAutoResend = (CheckBoxPreference) preferenceScreen.findPreference("pref_item_auto_resend");
        boolean zM7251b = C1757q.m7251b();
        this.mPrefItemAutoResend.setChecked(zM7251b);
        if (zM7251b) {
            setTextWitColor(getResources().getString(R.string.setting_chat_autoresend_description_on), this.mPrefItemAutoResend, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            setTextWitColor(getResources().getString(R.string.setting_chat_autoresend_description_off), this.mPrefItemAutoResend, getResources().getColor(R.color.buddy_list_item_status_changed));
        }
        this.mPrefItemAutoResend.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentChats.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (PrefFragmentChats.this.mPrefItemAutoResend == null) {
                    return false;
                }
                if (Boolean.valueOf(Boolean.parseBoolean(obj.toString())) == Boolean.TRUE) {
                    C1757q.m7253c();
                    PrefFragmentChats.this.setTextWitColor(PrefFragmentChats.this.getResources().getString(R.string.setting_chat_autoresend_description_on), PrefFragmentChats.this.mPrefItemAutoResend, PrefFragmentChats.this.getResources().getColor(R.color.buddy_list_item_status_changed));
                } else {
                    C1757q.m7254d();
                    PrefFragmentChats.this.setTextWitColor(PrefFragmentChats.this.getResources().getString(R.string.setting_chat_autoresend_description_off), PrefFragmentChats.this.mPrefItemAutoResend, PrefFragmentChats.this.getResources().getColor(R.color.buddy_list_item_status_changed));
                }
                return true;
            }
        });
        preferenceScreen.findPreference("pref_item_delete_old_chat_rooms").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentChats.4
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(PrefFragmentChats.this.ctx);
                abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
                abstractC3271aM11494a.mo11509b(GlobalApplication.m6451b().getString(R.string.settings_chat_delete_old_chat_rooms_popup_text, 3));
                abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentChats.4.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PrefFragmentChats.this.deleteOldChatRooms();
                        dialogInterface.dismiss();
                    }
                }).mo11507b(R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentChats.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                abstractC3271aM11494a.mo11512b();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOldChatRooms() {
        this.mDialog = new ProgressDialog(this.ctx);
        this.mDialog.setMessage(this.ctx.getString(R.string.deleting));
        this.mDialog.setCancelable(false);
        this.mBackKeyIgnore = true;
        this.mDialog.show();
        this.mQueryHandler.startDelete(1, null, C1439g.m6302a(), null, null);
    }

    private String getFontName() throws Resources.NotFoundException {
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

    private String getFontSize() throws Resources.NotFoundException {
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
