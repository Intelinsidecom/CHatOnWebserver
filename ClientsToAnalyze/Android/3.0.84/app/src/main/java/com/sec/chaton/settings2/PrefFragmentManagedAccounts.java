package com.sec.chaton.settings2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import com.sec.chaton.R;
import com.sec.chaton.registration.ActivitySyncSignInPopup;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.settings.EnumC2693fc;
import com.sec.chaton.settings.SnsSignInOutPreference;
import com.sec.chaton.settings.tellfriends.C2733aj;
import com.sec.chaton.settings.tellfriends.C2735al;
import com.sec.chaton.settings.tellfriends.C2737an;
import com.sec.chaton.settings.tellfriends.C2739ap;
import com.sec.chaton.settings.tellfriends.C2831y;
import com.sec.chaton.settings.tellfriends.InterfaceC2729af;
import com.sec.chaton.settings.tellfriends.InterfaceC2730ag;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class PrefFragmentManagedAccounts extends BasePreferenceFragment {
    private String email;
    private Activity mActivity;
    private InterfaceC3274d mAlertDialog;
    private Context mContext;
    private SnsSignInOutPreference mPrefItemFacebook;
    private SnsSignInOutPreference mPrefItemRenren;
    private SnsSignInOutPreference mPrefItemTwitter;
    private SnsSignInOutPreference mPrefItemWeibo;
    private ProgressDialog mProgressDialog;
    private C2735al mRrSnsHelper;
    private C2733aj mSnsHelper;
    private C2737an mTwSnsHelper;
    private C2739ap mWbSnsHelper;
    private boolean result;
    private Preference samsungAccount;
    private String ssoEmail;
    private String TAG = PrefFragmentManagedAccounts.class.getSimpleName();
    private final int SAMSUNG_ACCOUNT_LOGIN = 0;
    private final int SIGN_IN = 1;
    private final int TWITTER_ACCOUNT_SIGN_IN = 2;
    private final int WEIBO_ACCOUNT_SIGN_IN = 3;
    private final int ACCOUNT_VER = 12005;
    private final int FACEBOOK_ACCOUNT_SIGN_IN = 32665;
    private ProgressDialog progressBar = null;
    private InterfaceC2730ag mOnFacebookLogoutCallback = new InterfaceC2730ag() { // from class: com.sec.chaton.settings2.PrefFragmentManagedAccounts.3
        @Override // com.sec.chaton.settings.tellfriends.InterfaceC2730ag
        public void onComplete() {
            C3250y.m11450b("onComplete() \t- Logout", PrefFragmentManagedAccounts.this.TAG);
            CookieManager.getInstance().removeAllCookie();
            PrefFragmentManagedAccounts.this.dismissProgressDialog();
            C2831y.m10064a(PrefFragmentManagedAccounts.this.mActivity.getApplicationContext()).m10066a(C2831y.f10362a, false);
            PrefFragmentManagedAccounts.this.mPrefItemFacebook.setTitle(R.string.tellfriends_via_facebook);
            PrefFragmentManagedAccounts.this.mPrefItemFacebook.setSummary("");
            PrefFragmentManagedAccounts.this.mPrefItemFacebook.m9189a(EnumC2693fc.SIGN_OUT);
        }

        @Override // com.sec.chaton.settings.tellfriends.InterfaceC2730ag
        public void onCancelled() {
            C3250y.m11450b("onCancelled() \t- Logout", PrefFragmentManagedAccounts.this.TAG);
            PrefFragmentManagedAccounts.this.dismissProgressDialog();
        }

        @Override // com.sec.chaton.settings.tellfriends.InterfaceC2730ag
        public void onError() {
            C3250y.m11442a("onError() \t- Logout", PrefFragmentManagedAccounts.this.TAG);
            PrefFragmentManagedAccounts.this.dismissProgressDialog();
            PrefFragmentManagedAccounts.this.showAlertDialog();
        }
    };
    private InterfaceC2729af mOnFacebookLoginCallback = new InterfaceC2729af() { // from class: com.sec.chaton.settings2.PrefFragmentManagedAccounts.4
        @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
        public void onComplete() {
            C3250y.m11450b("onComplete() \t- Login", PrefFragmentManagedAccounts.this.TAG);
            PrefFragmentManagedAccounts.this.checkFacebookLogin();
            PrefFragmentManagedAccounts.this.dismissProgressDialog();
        }

        @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
        public void onCancelled() {
            C3250y.m11450b("onCancelled() \t- Login", PrefFragmentManagedAccounts.this.TAG);
            PrefFragmentManagedAccounts.this.dismissProgressDialog();
        }

        @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
        public void onError(int i) {
            C3250y.m11442a("onError() \t- Login", PrefFragmentManagedAccounts.this.TAG);
            PrefFragmentManagedAccounts.this.dismissAllDialog();
            PrefFragmentManagedAccounts.this.showAlertDialog();
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
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
        addPreferencesFromResource(R.xml.pref_setting_manage_accounts);
        this.samsungAccount = findPreference("pref_item_samsung_account");
        this.samsungAccount.setTitle(R.string.setting_samsung_account);
        this.mContext = this.mActivity;
        this.email = C3159aa.m10962a().m10979a("samsung_account_email", "");
        this.result = C3171am.m11061d(this.mContext);
        if (C3171am.m11080r()) {
            if (!TextUtils.isEmpty(this.email)) {
                this.samsungAccount.setTitle(this.email);
            }
            this.samsungAccount.setWidgetLayoutResource(R.layout.preference_widget_nothing);
            this.samsungAccount.setSummary(R.string.setting_samsung_account);
        } else {
            this.samsungAccount.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentManagedAccounts.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(PrefFragmentManagedAccounts.this.mContext, (Class<?>) ActivitySyncSignInPopup.class);
                    intent.setFlags(67108864);
                    intent.putExtra("isSyncContacts", true);
                    PrefFragmentManagedAccounts.this.startActivityForResult(intent, 1);
                    return false;
                }
            });
        }
        initiallizeSNSPreference();
    }

    @Override // android.preference.PreferenceFragment
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return true;
    }

    private void initiallizeSNSPreference() {
        this.mPrefItemFacebook = (SnsSignInOutPreference) findPreference("pref_item_facebook");
        this.mPrefItemTwitter = (SnsSignInOutPreference) findPreference("pref_item_twitter");
        this.mPrefItemWeibo = (SnsSignInOutPreference) findPreference("pref_item_weibo");
        this.mPrefItemRenren = (SnsSignInOutPreference) findPreference("pref_item_renren");
        getPreferenceScreen().removePreference(this.mPrefItemFacebook);
        getPreferenceScreen().removePreference(this.mPrefItemTwitter);
        getPreferenceScreen().removePreference(this.mPrefItemWeibo);
        getPreferenceScreen().removePreference(this.mPrefItemRenren);
    }

    private void checkRenrenLogin() {
        if (this.mRrSnsHelper.mo9774d()) {
            this.mPrefItemRenren.setTitle(this.mRrSnsHelper.mo9772b());
            this.mPrefItemRenren.setSummary(R.string.tellfriends_via_renren);
            this.mPrefItemRenren.m9189a(EnumC2693fc.SIGN_IN);
            return;
        }
        this.mPrefItemRenren.m9189a(EnumC2693fc.SIGN_OUT);
    }

    private void checkWeiboLogin() {
        if (this.mWbSnsHelper.mo9774d()) {
            this.mPrefItemWeibo.setTitle(this.mWbSnsHelper.mo9772b());
            this.mPrefItemWeibo.setSummary(R.string.tellfriends_via_weibo);
            this.mPrefItemWeibo.m9189a(EnumC2693fc.SIGN_IN);
            return;
        }
        this.mPrefItemWeibo.m9189a(EnumC2693fc.SIGN_OUT);
    }

    private void checkTwitterLogin() {
        if (this.mTwSnsHelper.mo9774d()) {
            this.mPrefItemTwitter.setTitle(this.mTwSnsHelper.mo9772b());
            this.mPrefItemTwitter.setSummary(R.string.tellfriends_via_twitter);
            this.mPrefItemTwitter.m9189a(EnumC2693fc.SIGN_IN);
            return;
        }
        this.mPrefItemTwitter.m9189a(EnumC2693fc.SIGN_OUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFacebookLogin() {
        if (this.mSnsHelper.mo9774d()) {
            this.mPrefItemFacebook.setTitle(this.mSnsHelper.m9798e());
            this.mPrefItemFacebook.setSummary(R.string.tellfriends_via_facebook);
            this.mPrefItemFacebook.m9189a(EnumC2693fc.SIGN_IN);
            return;
        }
        this.mPrefItemFacebook.m9189a(EnumC2693fc.SIGN_OUT);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                String stringExtra = null;
                if (intent != null) {
                    stringExtra = intent.getStringExtra("country_code");
                }
                if (i2 == -1) {
                    doFinish(C3159aa.m10962a().m10979a("samsung_account_email", ""));
                    if (stringExtra != null) {
                        C3214cb.m11253a(stringExtra, this.mContext, true);
                        break;
                    }
                } else if (this.progressBar != null && this.progressBar.isShowing()) {
                    this.progressBar.dismiss();
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    String strM10979a = C3159aa.m10962a().m10979a("samsung_account_email", "");
                    doFinish(strM10979a);
                    C3250y.m11450b("email : " + strM10979a, getClass().getSimpleName());
                    break;
                } else {
                    C3250y.m11450b("SIGNING_SSO : result is ERROR", getClass().getSimpleName());
                    break;
                }
            case 32665:
                this.mSnsHelper.mo9768a(i, i2, intent);
                break;
        }
    }

    private void runSSO() {
        C3250y.m11450b("ActivitySignIn will be run", getClass().getSimpleName());
        Intent intent = new Intent();
        intent.setClassName("com.osp.app.signin", "com.osp.app.signin.AccountView");
        intent.putExtra("client_id", "fs24s8z0hh");
        intent.putExtra("client_ secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent.putExtra("OSP_VER", "OSP_02");
        try {
            startActivityForResult(intent, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doFinish(String str) {
        this.samsungAccount.setTitle(str);
        this.samsungAccount.setSummary(R.string.setting_samsung_account);
        this.samsungAccount.setWidgetLayoutResource(R.layout.preference_widget_nothing);
        this.samsungAccount.setOnPreferenceClickListener(null);
    }

    private void showPasswordLockActivity() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.mActivity.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
        showPasswordLockActivity();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        if (this.mSnsHelper != null) {
            this.mSnsHelper.mo9767a();
        }
        if (this.mTwSnsHelper != null) {
            this.mTwSnsHelper.mo9767a();
        }
        if (this.mWbSnsHelper != null) {
            this.mWbSnsHelper.mo9767a();
        }
        if (this.mRrSnsHelper != null) {
            this.mRrSnsHelper.mo9767a();
        }
        if (this.progressBar != null) {
            this.progressBar.dismiss();
        }
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
        super.onDestroy();
    }

    private void showProgressDialog() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = ProgressDialog.show(this.mContext, null, getString(R.string.dialog_connecting_server));
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.sec.chaton.settings2.PrefFragmentManagedAccounts.2
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4) {
                        return false;
                    }
                    if (PrefFragmentManagedAccounts.this.mProgressDialog != null) {
                        PrefFragmentManagedAccounts.this.mProgressDialog.dismiss();
                    }
                    return true;
                }
            });
        } else {
            C3250y.m11450b("showProgressDialog() \t- not null. show", this.TAG);
            this.mProgressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        boolean zIsShowing;
        if (this.mProgressDialog != null && (zIsShowing = this.mProgressDialog.isShowing())) {
            C3250y.m11450b("dismissProgressDialog() \t- mProgressDialog : " + this.mProgressDialog + ". isSowing : " + zIsShowing, this.TAG);
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAllDialog() {
        dismissProgressDialog();
        dismissAlertDialog();
    }

    private void dismissAlertDialog() {
        if (this.mAlertDialog != null && this.mAlertDialog.isShowing()) {
            this.mAlertDialog.dismiss();
            this.mAlertDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog() {
        if (this.mAlertDialog == null) {
            this.mAlertDialog = AbstractC3271a.m11494a(this.mContext).mo11500a(getResources().getString(R.string.ams_attention_title)).mo11509b(getResources().getString(R.string.dev_network_error)).mo11511b(false).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentManagedAccounts.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).mo11505a();
        }
        this.mAlertDialog.show();
    }
}
