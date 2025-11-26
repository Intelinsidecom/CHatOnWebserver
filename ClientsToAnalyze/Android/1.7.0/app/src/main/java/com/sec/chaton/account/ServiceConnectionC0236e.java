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
import com.sec.chaton.p013a.AbstractC0196ai;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.p013a.C0203b;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.e */
/* loaded from: classes.dex */
class ServiceConnectionC0236e extends AbstractAccountAuthenticator implements ServiceConnection {

    /* renamed from: a */
    public Handler f577a;

    /* renamed from: b */
    public Handler f578b;

    /* renamed from: c */
    private Context f579c;

    /* renamed from: d */
    private AbstractC0196ai f580d;

    /* renamed from: e */
    private C0203b f581e;

    public ServiceConnectionC0236e(Context context) {
        super(context);
        this.f577a = new HandlerC0234c(this);
        this.f578b = new HandlerC0235d(this);
        this.f579c = context;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        C1341p.m4662e("Edit Account Properties", getClass().getSimpleName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        C1341p.m4662e("Add Account", getClass().getSimpleName());
        Intent intent = new Intent(this.f579c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        intent.putExtra("authtokenType", str2);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        C1341p.m4662e("Confirm Credentials", getClass().getName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C1341p.m4662e("get Auth Token", getClass().getName());
        if (!str.equals("com.sec.chaton")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("errorMessage", "invalid authTokenType");
            return bundle2;
        }
        String password = AccountManager.get(this.f579c).getPassword(account);
        if (password != null && C1323bs.m4575a().getString("uid", "").equals(password)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("authAccount", account.name);
            bundle3.putString("accountType", "com.sec.chaton");
            bundle3.putString("authtoken", password);
            return bundle3;
        }
        Intent intent = new Intent(this.f579c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle4 = new Bundle();
        bundle4.putParcelable("intent", intent);
        return bundle4;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        C1341p.m4662e("get Auth Token label", getClass().getSimpleName());
        if (str.equals("com.sec.chaton")) {
            return this.f579c.getString(R.string.label);
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C1341p.m4662e("update Credentials", getClass().getName());
        Intent intent = new Intent(this.f579c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("confirmCredentials", false);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        C1341p.m4662e("has features", getClass().getName());
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
        if (C1323bs.m4575a().contains("uid")) {
            AccountManager.get(this.f579c);
            if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
                this.f581e = new C0203b(this.f578b);
                this.f580d = C0192ae.m739a();
                this.f581e.m772a(this.f579c);
            }
        }
        return accountRemovalAllowed;
    }
}
