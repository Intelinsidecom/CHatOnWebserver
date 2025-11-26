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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.common.CommonApplication;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.c */
/* loaded from: classes.dex */
class ServiceConnectionC0417c extends AbstractAccountAuthenticator implements ServiceConnection, InterfaceC0047c {

    /* renamed from: a */
    public HandlerC3176ar f1465a;

    /* renamed from: b */
    public Handler f1466b;

    /* renamed from: c */
    private Context f1467c;

    /* renamed from: d */
    private AbstractC1144a<?> f1468d;

    /* renamed from: e */
    private C1303ap f1469e;

    /* renamed from: f */
    private C1156ak f1470f;

    /* renamed from: g */
    private C0045a f1471g;

    public ServiceConnectionC0417c(Context context) {
        super(context);
        this.f1465a = new HandlerC0418d(this);
        this.f1466b = new HandlerC0419e(this);
        this.f1467c = context;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        C3250y.m11456e("Edit Account Properties", getClass().getSimpleName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        C3250y.m11456e("Add Account", getClass().getSimpleName());
        Intent intent = new Intent(this.f1467c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        intent.putExtra("authtokenType", str2);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        C3250y.m11456e("Confirm Credentials", getClass().getName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C3250y.m11456e("get Auth Token", getClass().getName());
        if (!str.equals("com.sec.chaton")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("errorMessage", "invalid authTokenType");
            return bundle2;
        }
        String password = AccountManager.get(this.f1467c).getPassword(account);
        if (password != null && C3159aa.m10962a().m10979a("uid", "").equals(password)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("authAccount", account.name);
            bundle3.putString("accountType", "com.sec.chaton");
            bundle3.putString("authtoken", password);
            return bundle3;
        }
        Intent intent = new Intent(this.f1467c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle4 = new Bundle();
        bundle4.putParcelable("intent", intent);
        return bundle4;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        C3250y.m11456e("get Auth Token label", getClass().getSimpleName());
        if (str.equals("com.sec.chaton")) {
            return this.f1467c.getString(R.string.label);
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C3250y.m11456e("update Credentials", getClass().getName());
        Intent intent = new Intent(this.f1467c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("confirmCredentials", false);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        C3250y.m11456e("has features", getClass().getName());
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C3250y.m11456e("onServiceConnected", ChatONAccountService.class.getSimpleName());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C3250y.m11456e("onServiceDisconnected", ChatONAccountService.class.getSimpleName());
    }

    /* renamed from: a */
    public void m3029a() {
        C3250y.m11456e("destroyVAccount", ChatONAccountService.class.getSimpleName());
        if (C1954g.m7916a().m7918a(this.f1467c, EnumC1955h.ChatONV) && this.f1471g != null) {
            this.f1471g.m51a(this.f1467c, (InterfaceC0047c) null);
            this.f1471g = null;
            C3250y.m11456e("destroyVAccount:mChatonV.setListener(null)", ChatONAccountService.class.getSimpleName());
        }
    }

    /* renamed from: b */
    public void m3030b() {
        C3250y.m11450b("initVAccount", ChatONAccountService.class.getSimpleName());
        if (C1954g.m7916a().m7918a(this.f1467c, EnumC1955h.ChatONV) && this.f1471g == null) {
            this.f1471g = new C0045a();
            if (this.f1471g.m55d(this.f1467c)) {
                this.f1471g.m51a(this.f1467c, this);
                C3250y.m11450b("initVAccount:mChatonV.setListener()", ChatONAccountService.class.getSimpleName());
            }
        }
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            accountRemovalAllowed.putInt("errorCode", 3);
            accountRemovalAllowed.putString("errorMessage", CommonApplication.m11493l().getResources().getString(R.string.popup_no_network_connection));
            accountRemovalAllowed.putBoolean("booleanResult", false);
            if (Build.VERSION.SDK_INT >= 14) {
                new AsyncTaskC0420f(this).execute(new Void[0]);
            }
        } else {
            if (C3159aa.m10962a().m10987b("uid")) {
                AccountManager.get(this.f1467c);
                if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
                    this.f1469e = new C1303ap(this.f1466b);
                    this.f1468d = C1302ao.m5594a();
                    m3030b();
                    if (C3214cb.m11256a(this.f1467c) && this.f1471g.m55d(this.f1467c)) {
                        this.f1471g.m54c(this.f1467c);
                        C3250y.m11450b("getAccountRemovalAllowed:mChatonV.removeAccountInDevice()", ChatONAccountService.class.getSimpleName());
                    } else {
                        this.f1470f = this.f1469e.m5597a(this.f1467c);
                    }
                }
            }
            return accountRemovalAllowed;
        }
        C3250y.m11456e("getAccountRemovalAllowed(): result = " + accountRemovalAllowed, getClass().getName());
        return accountRemovalAllowed;
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        C3250y.m11450b("onReceiveRemoveAccount" + z, ChatONAccountService.class.getSimpleName());
        if (z) {
            if (this.f1469e != null) {
                this.f1470f = this.f1469e.m5597a(this.f1467c);
                return;
            } else {
                C3250y.m11450b("onReceiveRemoveAccount : regControl is null.", ChatONAccountService.class.getSimpleName());
                return;
            }
        }
        this.f1470f = null;
        this.f1466b.sendEmptyMessage(202);
    }
}
