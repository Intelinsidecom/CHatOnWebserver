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
import com.sec.chaton.R;
import com.sec.chaton.p015d.AbstractC0531a;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.p015d.C0621ak;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.b */
/* loaded from: classes.dex */
class ServiceConnectionC0205b extends AbstractAccountAuthenticator implements ServiceConnection {

    /* renamed from: a */
    public Handler f738a;

    /* renamed from: b */
    public Handler f739b;

    /* renamed from: c */
    private Context f740c;

    /* renamed from: d */
    private AbstractC0531a f741d;

    /* renamed from: e */
    private C0621ak f742e;

    public ServiceConnectionC0205b(Context context) {
        super(context);
        this.f738a = new HandlerC0206c(this);
        this.f739b = new HandlerC0207d(this);
        this.f740c = context;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        C1786r.m6066e("Edit Account Properties", getClass().getSimpleName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        C1786r.m6066e("Add Account", getClass().getSimpleName());
        Intent intent = new Intent(this.f740c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        intent.putExtra("authtokenType", str2);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        C1786r.m6066e("Confirm Credentials", getClass().getName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C1786r.m6066e("get Auth Token", getClass().getName());
        if (!str.equals("com.sec.chaton")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("errorMessage", "invalid authTokenType");
            return bundle2;
        }
        String password = AccountManager.get(this.f740c).getPassword(account);
        if (password != null && C1789u.m6075a().getString("uid", "").equals(password)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("authAccount", account.name);
            bundle3.putString("accountType", "com.sec.chaton");
            bundle3.putString("authtoken", password);
            return bundle3;
        }
        Intent intent = new Intent(this.f740c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle4 = new Bundle();
        bundle4.putParcelable("intent", intent);
        return bundle4;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        C1786r.m6066e("get Auth Token label", getClass().getSimpleName());
        if (str.equals("com.sec.chaton")) {
            return this.f740c.getString(R.string.label);
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C1786r.m6066e("update Credentials", getClass().getName());
        Intent intent = new Intent(this.f740c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("confirmCredentials", false);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        C1786r.m6066e("has features", getClass().getName());
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
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        if (C1789u.m6075a().contains("uid")) {
            AccountManager.get(this.f740c);
            if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
                this.f742e = new C0621ak(this.f739b);
                this.f741d = C0620aj.m2804a();
                this.f742e.m2807a(this.f740c);
            }
        }
        return accountRemovalAllowed;
    }
}
