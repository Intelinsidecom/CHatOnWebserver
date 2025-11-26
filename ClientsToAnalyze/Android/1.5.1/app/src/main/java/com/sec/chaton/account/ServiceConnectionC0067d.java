package com.sec.chaton.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.AbstractPushControl;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.control.RegistrationControl;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.account.d */
/* loaded from: classes.dex */
class ServiceConnectionC0067d extends AbstractAccountAuthenticator implements ServiceConnection {

    /* renamed from: a */
    public Handler f333a;

    /* renamed from: b */
    public Handler f334b;

    /* renamed from: c */
    private Context f335c;

    /* renamed from: d */
    private AbstractPushControl f336d;

    /* renamed from: e */
    private RegistrationControl f337e;

    public ServiceConnectionC0067d(Context context) {
        super(context);
        this.f333a = new HandlerC0064a(this);
        this.f334b = new HandlerC0065b(this);
        this.f335c = context;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        ChatONLogWriter.m3511e("Add Account", getClass().getSimpleName());
        Intent intent = new Intent(this.f335c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        intent.putExtra("authtokenType", str2);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        ChatONLogWriter.m3511e("Confirm Credentials", getClass().getName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        ChatONLogWriter.m3511e("Edit Account Properties", getClass().getSimpleName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        if (ChatONPref.m3519a().contains("uid")) {
            AccountManager.get(this.f335c);
            if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
                this.f337e = new RegistrationControl(this.f334b);
                this.f336d = PushControlFactory.m2072a();
                this.f337e.m2075a(this.f335c);
            }
        }
        return accountRemovalAllowed;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        ChatONLogWriter.m3511e("get Auth Token", getClass().getName());
        if (!str.equals("com.sec.chaton")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("errorMessage", "invalid authTokenType");
            return bundle2;
        }
        String password = AccountManager.get(this.f335c).getPassword(account);
        if (password != null && ChatONPref.m3519a().getString("uid", "").equals(password)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("authAccount", account.name);
            bundle3.putString("accountType", "com.sec.chaton");
            bundle3.putString("authtoken", password);
            return bundle3;
        }
        Intent intent = new Intent(this.f335c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle4 = new Bundle();
        bundle4.putParcelable("intent", intent);
        return bundle4;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        ChatONLogWriter.m3511e("get Auth Token label", getClass().getSimpleName());
        if (str.equals("com.sec.chaton")) {
            return this.f335c.getString(C0062R.string.label);
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        ChatONLogWriter.m3511e("has features", getClass().getName());
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        ChatONLogWriter.m3511e("update Credentials", getClass().getName());
        Intent intent = new Intent(this.f335c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("confirmCredentials", false);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }
}
