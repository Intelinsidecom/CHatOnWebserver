package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p035io.entry.GetPrivacyList;
import com.sec.chaton.p035io.entry.inner.PrivacyList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.settings.ActivityPrivacy;
import com.sec.chaton.userprofile.MyInfoFragment;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentPrivacy extends BasePreferenceFragment {
    public static final int PROFILE_IMAGE_BUDDIES = 0;
    public static final int PROFILE_IMAGE_PUBLIC = 1;
    private static final int REQUEST_LOCK_SET = 1;
    protected static final int SET_RINGTONE = 2;
    private C1330h control;
    private Context ctx;
    private String mGuide;
    private String mGuideImageAll1;
    private String mGuideImageAll2;
    private String mGuideImageBuddy1;
    private String mGuideImageBuddy2;
    private String mGuideOff;
    private String mGuidePhoneNumber;
    private String mGuideSamsungAccountOff;
    private String mGuideSamsungAccountOn;
    private String mGuideSamsungAccountTitle;
    private String mMSISDN;
    private Boolean mNetworkError;
    private String mSamsungAccount;
    private CheckBoxPreference phone_number_privacy;
    private ArrayList<PrivacyList> privacyArray;
    private CheckBoxPreference samsung_account_privacy;
    private Preference settings_birthday;
    private Preference settings_password_lock;
    private int showProfileImageNum;
    private Preference show_profileimage;
    private C3160ab sharedPref = null;
    private ProgressDialog mProgressDialog = null;
    private String TAG = ActivityPrivacy.class.getSimpleName();
    private String[] passwordData = new String[2];
    private int INDEX_LOCKSTATE = 0;
    private InterfaceC3274d mAlertDialog = null;
    private Handler mHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.8
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (PrefFragmentPrivacy.this.ctx != null && PrefFragmentPrivacy.this.getActivity() != null) {
                if (PrefFragmentPrivacy.this.mProgressDialog != null) {
                    PrefFragmentPrivacy.this.mProgressDialog.dismiss();
                }
                switch (message.what) {
                    case HttpResponseCode.NOT_MODIFIED /* 304 */:
                        C0267d c0267d = (C0267d) message.obj;
                        if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                            PrefFragmentPrivacy.this.phone_number_privacy.setChecked(C3159aa.m10962a().m10977a("show_phone_number_to_all", (Boolean) true).booleanValue());
                            PrefFragmentPrivacy.this.samsung_account_privacy.setChecked(C3159aa.m10962a().m10977a("samsung_account_show", (Boolean) false).booleanValue());
                            C3641ai.m13210a(PrefFragmentPrivacy.this.ctx, R.string.popup_no_network_connection, 0).show();
                            break;
                        } else {
                            PrefFragmentPrivacy.this.setPrivacyGuide();
                            C3641ai.m13210a(PrefFragmentPrivacy.this.ctx, R.string.buddy_profile_saveprofile_toast_success, 0).show();
                            break;
                        }
                    case 322:
                        C0267d c0267d2 = (C0267d) message.obj;
                        if (!c0267d2.m11704n() || c0267d2.m1351b() == EnumC1587o.ERROR) {
                            PrefFragmentPrivacy.this.mNetworkError = true;
                            PrefFragmentPrivacy.this.phone_number_privacy.setEnabled(false);
                            PrefFragmentPrivacy.this.samsung_account_privacy.setEnabled(false);
                            if (PrefFragmentPrivacy.this.mProgressDialog != null) {
                                PrefFragmentPrivacy.this.mProgressDialog.dismiss();
                            }
                            C3641ai.m13210a(PrefFragmentPrivacy.this.ctx, R.string.popup_no_network_connection, 0).show();
                            break;
                        } else {
                            PrefFragmentPrivacy.this.mNetworkError = false;
                            GetPrivacyList getPrivacyList = (GetPrivacyList) c0267d2.m1354e();
                            if (getPrivacyList != null) {
                                PrefFragmentPrivacy.this.privacyArray = getPrivacyList.privacy;
                                for (int i = 0; i < PrefFragmentPrivacy.this.privacyArray.size(); i++) {
                                    PrefFragmentPrivacy.this.InitPrivacyCheck(((PrivacyList) PrefFragmentPrivacy.this.privacyArray.get(i)).name, ((PrivacyList) PrefFragmentPrivacy.this.privacyArray.get(i))._value);
                                }
                                PrefFragmentPrivacy.this.setPrivacyGuide();
                                if (PrefFragmentPrivacy.this.mProgressDialog != null) {
                                    PrefFragmentPrivacy.this.mProgressDialog.dismiss();
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    };

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.pref_setting_privacy);
        this.ctx = getActivity();
        this.mProgressDialog = new ProgressDialogC3265l(this.ctx, false);
        this.mProgressDialog.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                PrefFragmentPrivacy.this.control.m5740d();
                if (PrefFragmentPrivacy.this.mProgressDialog != null) {
                    PrefFragmentPrivacy.this.mProgressDialog.dismiss();
                }
                return true;
            }
        });
        this.mNetworkError = false;
        this.control = new C1330h(this.mHandler);
        this.control.m5753g("phonenumber|showprofileimage|emailsamsung");
        this.mProgressDialog.show();
        this.privacyArray = new ArrayList<>();
        this.sharedPref = C3159aa.m10962a();
        this.sharedPref.m10983b("Lock Check", (Boolean) false);
        this.mSamsungAccount = C3159aa.m10962a().m10979a("samsung_account_email", "");
        this.mMSISDN = C3159aa.m10962a().m10979a("msisdn", "");
        this.mGuide = getResources().getString(R.string.phone_number_privacy_guide);
        this.mGuideOff = getResources().getString(R.string.phone_number_privacy_guide_off);
        this.mGuideImageBuddy1 = getResources().getString(R.string.tab_buddies);
        this.mGuideImageBuddy2 = getResources().getString(R.string.setting_privacy_only_buddy_profile_description);
        this.mGuideImageAll1 = getResources().getString(R.string.setting_downloads_font_filter_all);
        this.mGuideImageAll2 = getResources().getString(R.string.setting_privacy_public_profile_description);
        this.mGuideSamsungAccountOn = getResources().getString(R.string.privacy_show_my_samsung_account_detail);
        this.mGuideSamsungAccountOff = getResources().getString(R.string.setting_privacy_blind_samsung_account_description);
        this.mGuidePhoneNumber = getResources().getString(R.string.settings_privacy_showmynumber);
        this.mGuideSamsungAccountTitle = getResources().getString(R.string.privacy_show_my_samsung_account);
        this.settings_password_lock = findPreference("pref_item_password_lock");
        try {
            initializeForPreference();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("fragment_choose") && arguments.getString("fragment_choose").equals(PrefFragmentBirthday.class.getName())) {
            ((PreferenceActivity) getActivity()).startPreferencePanel(PrefFragmentBirthday.class.getName(), null, R.string.settings_birthday_category, null, null, 0);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setBirthday();
        this.passwordData = prePassword("GET", "", "");
        changeSummary(this.passwordData[this.INDEX_LOCKSTATE]);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    ((PreferenceActivity) getActivity()).startPreferencePanel(PrefFragmentPasswordLock.class.getName(), null, R.string.settings_password_lock, null, null, 0);
                    break;
            }
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mAlertDialog != null) {
            this.mAlertDialog.dismiss();
        }
    }

    private void initializeForPreference() {
        C3159aa.m10962a().m10979a("msisdn", "");
        this.phone_number_privacy = (CheckBoxPreference) findPreference("pref_item_phonenumber");
        if (this.mMSISDN == null || this.mMSISDN.length() == 0) {
            C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) false);
            this.phone_number_privacy.setEnabled(false);
            this.phone_number_privacy.setChecked(false);
        } else {
            this.phone_number_privacy.setEnabled(true);
        }
        this.phone_number_privacy.setChecked(C3159aa.m10962a().m10977a("show_phone_number_to_all", (Boolean) true).booleanValue());
        if (this.phone_number_privacy.isChecked()) {
            if (this.mMSISDN == null || this.mMSISDN == "") {
                setTextWitColor(this.mGuide, this.phone_number_privacy, getResources().getColor(R.color.setting_explain_text));
            } else {
                setTextWitTwoColor("+" + this.mMSISDN, this.mGuide, this.phone_number_privacy, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
            }
        } else if (this.mMSISDN == null || this.mMSISDN == "") {
            setTitleTextWitColor(this.mGuidePhoneNumber, this.phone_number_privacy, getResources().getColor(R.color.dark_gray));
            setTextWitColor(this.mGuideOff, this.phone_number_privacy, getResources().getColor(R.color.setting_explain_text));
        } else {
            setTextWitTwoColor("+" + this.mMSISDN, this.mGuideOff, this.phone_number_privacy, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        this.phone_number_privacy.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (PrefFragmentPrivacy.this.mNetworkError.booleanValue()) {
                    C3641ai.m13210a(PrefFragmentPrivacy.this.ctx, R.string.popup_no_network_connection, 0).show();
                } else {
                    String str = obj + "";
                    if (obj == null || !str.equals("true")) {
                        PrefFragmentPrivacy.this.control.m5739c(false);
                    } else {
                        PrefFragmentPrivacy.this.control.m5739c(true);
                    }
                    PrefFragmentPrivacy.this.mProgressDialog.show();
                }
                return true;
            }
        });
        this.show_profileimage = findPreference("pref_item_show_profileimage");
        if (C3159aa.m10962a().m10977a("samsung_profile_image_show", (Boolean) false).booleanValue()) {
            setTextWitTwoColor(this.mGuideImageAll1, this.mGuideImageAll2, this.show_profileimage, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        } else {
            setTextWitTwoColor(this.mGuideImageBuddy1, this.mGuideImageBuddy2, this.show_profileimage, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        this.show_profileimage.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (PrefFragmentPrivacy.this.mNetworkError.booleanValue()) {
                    C3641ai.m13210a(PrefFragmentPrivacy.this.ctx, R.string.popup_no_network_connection, 0).show();
                } else {
                    PrefFragmentPrivacy.this.mAlertDialog = AbstractC3271a.m11494a(PrefFragmentPrivacy.this.getActivity()).mo11500a(PrefFragmentPrivacy.this.getString(R.string.setting_privacy_show_my_profile_picture)).mo11510b(PrefFragmentPrivacy.this.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11503a(new String[]{PrefFragmentPrivacy.this.getString(R.string.tab_buddies), PrefFragmentPrivacy.this.getString(R.string.setting_downloads_font_filter_all)}, PrefFragmentPrivacy.this.showProfileImageNum, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    PrefFragmentPrivacy.this.control.m5747e(false);
                                    PrefFragmentPrivacy.this.mProgressDialog.show();
                                    break;
                                case 1:
                                    PrefFragmentPrivacy.this.control.m5747e(true);
                                    PrefFragmentPrivacy.this.mProgressDialog.show();
                                    break;
                            }
                            PrefFragmentPrivacy.this.mAlertDialog.dismiss();
                        }
                    }).mo11512b();
                }
                return true;
            }
        });
        this.samsung_account_privacy = (CheckBoxPreference) findPreference("pref_item_samsung_account");
        if (this.mSamsungAccount == null || this.mSamsungAccount.length() == 0) {
            C3159aa.m10962a().m10983b("samsung_account_show", (Boolean) false);
            this.samsung_account_privacy.setChecked(false);
            this.samsung_account_privacy.setEnabled(false);
        } else {
            this.samsung_account_privacy.setEnabled(true);
        }
        this.samsung_account_privacy.setChecked(C3159aa.m10962a().m10977a("samsung_account_show", (Boolean) false).booleanValue());
        if (this.samsung_account_privacy.isChecked()) {
            this.samsung_account_privacy.setSummary(this.mGuideSamsungAccountOn);
            setTextWitColor(this.mGuideSamsungAccountOn, this.samsung_account_privacy, getResources().getColor(R.color.setting_explain_text));
        } else {
            setTitleTextWitColor(this.mGuideSamsungAccountTitle, this.samsung_account_privacy, getResources().getColor(R.color.dark_gray));
            this.samsung_account_privacy.setSummary(this.mGuideSamsungAccountOff);
            setTextWitColor(this.mGuideSamsungAccountOff, this.samsung_account_privacy, getResources().getColor(R.color.setting_explain_text));
        }
        this.samsung_account_privacy.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.4
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentPrivacy.this.control.m5743d(false);
                } else {
                    PrefFragmentPrivacy.this.control.m5743d(true);
                }
                PrefFragmentPrivacy.this.mProgressDialog.show();
                return true;
            }
        });
        this.settings_birthday = findPreference("pref_item_birthday");
        setBirthday();
        this.settings_birthday.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.5
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                ((PreferenceActivity) PrefFragmentPrivacy.this.getActivity()).startPreferencePanel(PrefFragmentBirthday.class.getName(), null, R.string.settings_birthday_category, null, null, 0);
                return true;
            }
        });
        Preference preferenceFindPreference = findPreference("pref_item_poston");
        preferenceFindPreference.setSummary(getResources().getString(R.string.poston_buddies_blocked));
        setTextWitColor(getString(R.string.poston_buddies_blocked), preferenceFindPreference, getResources().getColor(R.color.setting_explain_text));
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.6
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                ((PreferenceActivity) PrefFragmentPrivacy.this.getActivity()).startPreferencePanel(PrefFragmentPostONHide.class.getName(), null, R.string.poston_title, null, null, 0);
                return true;
            }
        });
        this.settings_password_lock.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPrivacy.7
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (PrefFragmentPrivacy.this.passwordData[PrefFragmentPrivacy.this.INDEX_LOCKSTATE].equals(C3241p.m11408d())) {
                    Intent intent = new Intent(PrefFragmentPrivacy.this.ctx, (Class<?>) ActivityPasswordLockSet.class);
                    intent.putExtra("MODE", "PRIVACY");
                    PrefFragmentPrivacy.this.startActivityForResult(intent, 1);
                } else {
                    ((PreferenceActivity) PrefFragmentPrivacy.this.getActivity()).startPreferencePanel(PrefFragmentPasswordLock.class.getName(), null, R.string.settings_password_lock, null, null, 0);
                }
                return false;
            }
        });
    }

    private void setTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    private void setTextWitTwoColor(String str, String str2, Preference preference, int i, int i2) {
        SpannableString spannableString = new SpannableString(str);
        SpannableString spannableString2 = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        spannableString2.setSpan(new ForegroundColorSpan(i2), 0, str2.length(), 0);
        preference.setSummary(TextUtils.concat(spannableString, "\n", spannableString2));
    }

    private void setTitleTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    public String[] prePassword(String str, String str2, String str3) {
        C3250y.m11450b("prePassword", this.TAG);
        C3250y.m11450b("mode : " + str, this.TAG);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = this.ctx.getSharedPreferences("PASSWORD_LOCK", 0);
        if (str.equals("GET")) {
            C3250y.m11450b("GET preference", this.TAG);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C3241p.m11409e());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C3250y.m11450b("data : " + strArr[i2], this.TAG);
            }
        } else {
            C3250y.m11450b("SET preference", this.TAG);
            C3250y.m11450b("state : " + str2, this.TAG);
            C3250y.m11450b("pass : " + str3, this.TAG);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM11401b = C3241p.m11401b(str2);
            String strM11401b2 = C3241p.m11401b(str3);
            editorEdit.putString("LOCK_STATE", strM11401b);
            editorEdit.putString("PASSWORD", strM11401b2);
            editorEdit.commit();
        }
        return strArr;
    }

    public void changeSummary(String str) {
        C3250y.m11450b("changeSummary", this.TAG);
        if (str.equals(C3241p.m11408d())) {
            this.settings_password_lock.setSummary(R.string.settings_password_lock_text_on);
            setTextWitColor(getResources().getString(R.string.settings_password_lock_text_on), this.settings_password_lock, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            this.settings_password_lock.setSummary(R.string.settings_password_lock_text_off);
            setTextWitColor(getResources().getString(R.string.settings_password_lock_text_off), this.settings_password_lock, getResources().getColor(R.color.buddy_list_item_status_changed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrivacyGuide() {
        if (this.phone_number_privacy.isChecked()) {
            if (this.mMSISDN == null || this.mMSISDN == "") {
                C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) false);
                setTextWitColor(this.mGuide, this.phone_number_privacy, getResources().getColor(R.color.setting_explain_text));
            } else {
                setTextWitTwoColor("+" + this.mMSISDN, this.mGuide, this.phone_number_privacy, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
            }
        } else if (this.mMSISDN == null || this.mMSISDN == "") {
            setTextWitColor(this.mGuideOff, this.phone_number_privacy, getResources().getColor(R.color.setting_explain_text));
        } else {
            setTextWitTwoColor("+" + this.mMSISDN, this.mGuideOff, this.phone_number_privacy, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        if (C3159aa.m10962a().m10977a("samsung_profile_image_show", (Boolean) false).booleanValue()) {
            this.showProfileImageNum = 1;
            setTextWitTwoColor(this.mGuideImageAll1, this.mGuideImageAll2, this.show_profileimage, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        } else {
            this.showProfileImageNum = 0;
            setTextWitTwoColor(this.mGuideImageBuddy1, this.mGuideImageBuddy2, this.show_profileimage, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        if (this.samsung_account_privacy.isChecked()) {
            this.samsung_account_privacy.setSummary(this.mGuideSamsungAccountOn);
            setTextWitColor(this.mGuideSamsungAccountOn, this.samsung_account_privacy, getResources().getColor(R.color.setting_explain_text));
        } else {
            this.samsung_account_privacy.setSummary(this.mGuideSamsungAccountOff);
            setTextWitColor(this.mGuideSamsungAccountOff, this.samsung_account_privacy, getResources().getColor(R.color.setting_explain_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitPrivacyCheck(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.equals("phonenumber") && this.phone_number_privacy.isEnabled()) {
                if (str2.equals("true")) {
                    C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) true);
                    this.phone_number_privacy.setChecked(true);
                } else {
                    C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) false);
                    this.phone_number_privacy.setChecked(false);
                }
                C3250y.m11456e("InitPrivacyCheck/ phonenumber : " + str2, getClass().getSimpleName());
                return;
            }
            if (str.equals("showprofileimage")) {
                if (str2.equals("true")) {
                    this.showProfileImageNum = 1;
                    C3159aa.m10962a().m10983b("samsung_profile_image_show", (Boolean) true);
                    setTextWitTwoColor(this.mGuideImageAll1, this.mGuideImageAll2, this.show_profileimage, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                } else {
                    this.showProfileImageNum = 0;
                    C3159aa.m10962a().m10983b("samsung_profile_image_show", (Boolean) false);
                    setTextWitTwoColor(this.mGuideImageBuddy1, this.mGuideImageBuddy2, this.show_profileimage, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                }
                C3250y.m11456e("InitPrivacyCheck/ showprofileimage : " + str2, getClass().getSimpleName());
                return;
            }
            if (str.equals("emailsamsung") && this.samsung_account_privacy.isEnabled()) {
                if (str2.equals("true")) {
                    this.samsung_account_privacy.setChecked(true);
                    C3159aa.m10962a().m10983b("samsung_account_show", (Boolean) true);
                } else {
                    this.samsung_account_privacy.setChecked(false);
                    C3159aa.m10962a().m10983b("samsung_account_show", (Boolean) false);
                }
                C3250y.m11456e("InitPrivacyCheck/ emailsamsung : " + str2, getClass().getSimpleName());
            }
        }
    }

    private void setBirthday() {
        String strM10979a = C3159aa.m10962a().m10979a("birthday", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("birthday_type", "");
        if (strM10979a.length() > 0) {
            if ("".equals(strM10979a2)) {
                strM10979a2 = "SHORT_HIDE";
            }
            if ("FULL".equals(strM10979a2)) {
                setTextWitColor(MyInfoFragment.m10678b(strM10979a), this.settings_birthday, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            }
            if ("SHORT".equals(strM10979a2)) {
                String[] strArrSplit = strM10979a.split("-");
                setTextWitColor(MyInfoFragment.m10678b(strArrSplit[1] + "-" + strArrSplit[2]), this.settings_birthday, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            } else if ("FULL_HIDE".equals(strM10979a2)) {
                setTextWitColor(MyInfoFragment.m10678b(strM10979a), this.settings_birthday, getResources().getColor(R.color.setting_explain_text));
                return;
            } else if ("SHORT_HIDE".equals(strM10979a2)) {
                String[] strArrSplit2 = strM10979a.split("-");
                setTextWitColor(MyInfoFragment.m10678b(strArrSplit2[1] + "-" + strArrSplit2[2]), this.settings_birthday, getResources().getColor(R.color.setting_explain_text));
                return;
            } else {
                setTextWitColor(getResources().getString(R.string.add_your_birthday), this.settings_birthday, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            }
        }
        setTextWitColor(getResources().getString(R.string.add_your_birthday), this.settings_birthday, getResources().getColor(R.color.buddy_list_item_status_changed));
    }

    @Override // android.preference.PreferenceFragment
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return true;
    }
}
