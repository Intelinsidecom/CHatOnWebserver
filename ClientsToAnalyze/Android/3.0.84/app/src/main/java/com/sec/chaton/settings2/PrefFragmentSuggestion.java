package com.sec.chaton.settings2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p035io.entry.GetPrivacyList;
import com.sec.chaton.p035io.entry.inner.PrivacyList;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.AboutNewNotice;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PrefFragmentSuggestion extends BasePreferenceFragment {
    private C1330h control;
    private Context ctx;
    private Activity mAttachedActivity;
    AboutNewNotice prefItemAbout;
    private CheckBoxPreference prefItemExcludeMe;
    private CheckBoxPreference prefItemSpecialbuddySuggestions;
    private CheckBoxPreference prefItemSuggestions;
    private BreadCrumbsPreference prefItemTitle;
    private ArrayList<PrivacyList> privacyArray;
    private C1330h privacyControl;
    private boolean isSuggestionsReceive = true;
    private boolean isSpecialbuddyReceive = true;
    private boolean isExcludeMe = false;
    private C3160ab sharedPref = null;
    private ProgressDialog mProgressDialog = null;
    private Handler mHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentSuggestion.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (PrefFragmentSuggestion.this.ctx != null) {
                if (PrefFragmentSuggestion.this.mProgressDialog != null) {
                    PrefFragmentSuggestion.this.mProgressDialog.dismiss();
                }
                switch (message.what) {
                    case 322:
                        C0267d c0267d = (C0267d) message.obj;
                        if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                            if (PrefFragmentSuggestion.this.mProgressDialog != null) {
                                PrefFragmentSuggestion.this.mProgressDialog.dismiss();
                            }
                            C3641ai.m13211a(PrefFragmentSuggestion.this.ctx, PrefFragmentSuggestion.this.getResources().getString(R.string.dev_network_error), 0).show();
                            break;
                        } else {
                            GetPrivacyList getPrivacyList = (GetPrivacyList) c0267d.m1354e();
                            if (getPrivacyList != null) {
                                PrefFragmentSuggestion.this.privacyArray = getPrivacyList.privacy;
                                for (int i = 0; i < PrefFragmentSuggestion.this.privacyArray.size(); i++) {
                                    PrefFragmentSuggestion.this.InitPrivacyCheck(((PrivacyList) PrefFragmentSuggestion.this.privacyArray.get(i)).name, ((PrivacyList) PrefFragmentSuggestion.this.privacyArray.get(i))._value);
                                }
                                if (PrefFragmentSuggestion.this.mProgressDialog != null) {
                                    PrefFragmentSuggestion.this.mProgressDialog.dismiss();
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    };
    private Handler mUiHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentSuggestion.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (PrefFragmentSuggestion.this.ctx != null) {
                C0267d c0267d = (C0267d) message.obj;
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    try {
                        PrefFragmentSuggestion.this.mProgressDialog.dismiss();
                    } catch (Exception e) {
                        C3250y.m11442a("Exception occurred while trying to dismiss progress dialog", getClass().getSimpleName());
                    }
                    int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 != iM6733a && -2 != iM6733a) {
                        C3641ai.m13210a(PrefFragmentSuggestion.this.ctx, R.string.toast_network_unable, 0).show();
                        return;
                    }
                    return;
                }
                if (PrefFragmentSuggestion.this.sharedPref.m10977a("recomned_receive", (Boolean) true).booleanValue()) {
                    PrefFragmentSuggestion.this.isSuggestionsReceive = true;
                    PrefFragmentSuggestion.this.sharedPref.m10983b("recomned_receive", (Boolean) true);
                } else {
                    PrefFragmentSuggestion.this.isSuggestionsReceive = false;
                    PrefFragmentSuggestion.this.sharedPref.m10983b("recomned_receive", (Boolean) false);
                }
                PrefFragmentSuggestion.this.prefItemSuggestions.setChecked(PrefFragmentSuggestion.this.isSuggestionsReceive);
                try {
                    PrefFragmentSuggestion.this.mProgressDialog.dismiss();
                } catch (Exception e2) {
                    C3250y.m11442a("Exception occurred while trying to dismiss progress dialog", getClass().getSimpleName());
                }
                C3641ai.m13211a(PrefFragmentSuggestion.this.ctx, PrefFragmentSuggestion.this.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
            }
        }
    };

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        this.mAttachedActivity = activity;
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        this.mAttachedActivity = null;
        super.onDetach();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctx = this.mAttachedActivity;
        this.mProgressDialog = new ProgressDialogC3265l(this.mAttachedActivity, false);
        this.mProgressDialog.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        addPreferencesFromResource(R.xml.pref_setting_buddies_suggestions);
        this.control = new C1330h(this.mUiHandler);
        this.sharedPref = C3159aa.m10962a();
        this.sharedPref.m10983b("Lock Check", (Boolean) false);
        try {
            initializeForPreference();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
        this.privacyControl = new C1330h(this.mHandler);
        this.privacyControl.m5753g("recommendationbuddy|ignorerecommendation");
        this.mProgressDialog.show();
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitPrivacyCheck(String str, String str2) {
        if (str == null || str2 == null) {
            C3250y.m11456e("have no privacy", getClass().getSimpleName());
            return;
        }
        if (str.equals("recommendationbuddy")) {
            if (str2.equals("true")) {
                this.prefItemSuggestions.setChecked(true);
                this.sharedPref.m10983b("recomned_receive", (Boolean) true);
            } else {
                this.prefItemSuggestions.setChecked(false);
                this.sharedPref.m10983b("recomned_receive", (Boolean) false);
            }
            C3250y.m11456e("recommendationbuddy : " + str2, getClass().getSimpleName());
            return;
        }
        if (str.equals("ignorerecommendation")) {
            if (str2.equals("true")) {
                this.prefItemExcludeMe.setChecked(false);
                this.sharedPref.m10983b("exclude_me", (Boolean) true);
            } else {
                this.prefItemExcludeMe.setChecked(true);
                this.sharedPref.m10983b("exclude_me", (Boolean) false);
            }
            C3250y.m11456e("ignorerecommendation : " + str2, getClass().getSimpleName());
        }
    }

    private void initializeForPreference() {
        this.prefItemTitle = (BreadCrumbsPreference) findPreference("pref_item_breadcrumbs");
        this.prefItemTitle.setActivity(getActivity());
        this.prefItemSuggestions = (CheckBoxPreference) findPreference("pref_item_buddy_sugestions");
        if (this.sharedPref.m10977a("recomned_receive", (Boolean) true).booleanValue()) {
            this.isSuggestionsReceive = true;
            this.sharedPref.m10983b("recomned_receive", (Boolean) true);
        } else {
            this.isSuggestionsReceive = false;
            this.sharedPref.m10983b("recomned_receive", (Boolean) false);
        }
        this.prefItemSuggestions.setChecked(this.isSuggestionsReceive);
        setTextWitColor(getResources().getString(R.string.settings_suggestions_buddy_description), this.prefItemSuggestions, getResources().getColor(R.color.setting_explain_text));
        this.prefItemSuggestions.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentSuggestion.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentSuggestion.this.isSuggestionsReceive = false;
                    PrefFragmentSuggestion.this.sharedPref.m10983b("recomned_receive", (Boolean) false);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100003", "00000002");
                    }
                    PrefFragmentSuggestion.this.control.m5754g(false);
                    PrefFragmentSuggestion.this.mProgressDialog.show();
                } else {
                    PrefFragmentSuggestion.this.isSuggestionsReceive = true;
                    PrefFragmentSuggestion.this.sharedPref.m10983b("recomned_receive", (Boolean) true);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100003", "00000001");
                    }
                    PrefFragmentSuggestion.this.control.m5754g(true);
                    PrefFragmentSuggestion.this.mProgressDialog.show();
                }
                C3641ai.m13211a(PrefFragmentSuggestion.this.ctx, PrefFragmentSuggestion.this.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
                return true;
            }
        });
        if (!this.sharedPref.m10977a("recomned_special", (Boolean) true).booleanValue()) {
            this.isSpecialbuddyReceive = true;
            this.sharedPref.m10983b("recomned_special", (Boolean) true);
        }
        this.prefItemExcludeMe = (CheckBoxPreference) findPreference("pref_item_exclude_me");
        if (this.sharedPref.m10977a("exclude_me", (Boolean) true).booleanValue()) {
            this.isExcludeMe = false;
            this.sharedPref.m10983b("exclude_me", (Boolean) true);
        } else {
            this.isExcludeMe = true;
            this.sharedPref.m10983b("exclude_me", (Boolean) false);
        }
        this.prefItemExcludeMe.setChecked(this.isExcludeMe);
        setTextWitColor(getResources().getString(R.string.manage_buddies_suggest_me_description), this.prefItemExcludeMe, getResources().getColor(R.color.setting_explain_text));
        this.prefItemExcludeMe.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentSuggestion.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a || -2 == iM6733a) {
                    C3641ai.m13210a(PrefFragmentSuggestion.this.ctx, R.string.popup_no_network_connection, 0).show();
                    return false;
                }
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentSuggestion.this.isExcludeMe = true;
                    PrefFragmentSuggestion.this.sharedPref.m10983b("exclude_me", (Boolean) false);
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11847a("00100003", "00000006");
                    }
                    PrefFragmentSuggestion.this.control.m5751f(true);
                    PrefFragmentSuggestion.this.mProgressDialog.show();
                    return true;
                }
                PrefFragmentSuggestion.this.isExcludeMe = false;
                PrefFragmentSuggestion.this.sharedPref.m10983b("exclude_me", (Boolean) true);
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11847a("00100003", "00000005");
                }
                PrefFragmentSuggestion.this.control.m5751f(false);
                PrefFragmentSuggestion.this.mProgressDialog.show();
                return true;
            }
        });
        this.prefItemExcludeMe.setTitle(getResources().getString(R.string.manage_buddies_suggest_me));
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void setTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }
}
