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
import android.text.TextUtils;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.R;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.c */
/* loaded from: classes.dex */
class ServiceConnectionC0996c extends AbstractAccountAuthenticator implements ServiceConnection, InterfaceC0418c {

    /* renamed from: a */
    public HandlerC4826ar f3255a;

    /* renamed from: b */
    public Handler f3256b;

    /* renamed from: c */
    private Context f3257c;

    /* renamed from: d */
    private AbstractC1899a<?> f3258d;

    /* renamed from: e */
    private C2095ba f3259e;

    /* renamed from: f */
    private C1907ag f3260f;

    /* renamed from: g */
    private C0416a f3261g;

    public ServiceConnectionC0996c(Context context) {
        super(context);
        this.f3255a = new HandlerC0997d(this);
        this.f3256b = new HandlerC0998e(this);
        this.f3257c = context;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        C4904y.m18646e("Edit Account Properties", getClass().getSimpleName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        C4904y.m18646e("Add Account", getClass().getSimpleName());
        Intent intent = new Intent(this.f3257c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        intent.putExtra("authtokenType", str2);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        C4904y.m18646e("Confirm Credentials", getClass().getName());
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C4904y.m18646e("get Auth Token", getClass().getName());
        if (!str.equals(Config.CHATON_PACKAGE_NAME)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("errorMessage", "invalid authTokenType");
            return bundle2;
        }
        String password = AccountManager.get(this.f3257c).getPassword(account);
        if (password != null && C4809aa.m18104a().m18121a("uid", "").equals(password)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("authAccount", account.name);
            bundle3.putString("accountType", Config.CHATON_PACKAGE_NAME);
            bundle3.putString("authtoken", password);
            return bundle3;
        }
        Intent intent = new Intent(this.f3257c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle4 = new Bundle();
        bundle4.putParcelable("intent", intent);
        return bundle4;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        C4904y.m18646e("get Auth Token label", getClass().getSimpleName());
        if (str.equals(Config.CHATON_PACKAGE_NAME)) {
            return this.f3257c.getString(R.string.label);
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C4904y.m18646e("update Credentials", getClass().getName());
        Intent intent = new Intent(this.f3257c, (Class<?>) AuthenticatorActivity.class);
        intent.putExtra("username", account.name);
        intent.putExtra("authtokenType", str);
        intent.putExtra("confirmCredentials", false);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        C4904y.m18646e("has features", getClass().getName());
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C4904y.m18646e("onServiceConnected", ChatONAccountService.class.getSimpleName());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C4904y.m18646e("onServiceDisconnected", ChatONAccountService.class.getSimpleName());
    }

    /* renamed from: a */
    public void m6048a() {
        C4904y.m18646e("destroyVAccount", ChatONAccountService.class.getSimpleName());
        if (C2948h.m12190a().m12192a(this.f3257c, EnumC2949i.ChatONV) && this.f3261g != null) {
            this.f3261g.m1491a(this.f3257c, (InterfaceC0418c) null);
            this.f3261g = null;
            C4904y.m18646e("destroyVAccount:mChatonV.setListener(null)", ChatONAccountService.class.getSimpleName());
        }
    }

    /* renamed from: b */
    public void m6049b() {
        C4904y.m18639b("initVAccount", ChatONAccountService.class.getSimpleName());
        if (C2948h.m12190a().m12192a(this.f3257c, EnumC2949i.ChatONV) && this.f3261g == null) {
            this.f3261g = new C0416a();
            if (this.f3261g.m1495d(this.f3257c)) {
                this.f3261g.m1491a(this.f3257c, this);
                C4904y.m18639b("initVAccount:mChatonV.setListener()", ChatONAccountService.class.getSimpleName());
            }
        }
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        C0995b c0995b = null;
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            accountRemovalAllowed.putInt("errorCode", 3);
            accountRemovalAllowed.putString("errorMessage", CommonApplication.m18732r().getResources().getString(R.string.popup_no_network_connection));
            accountRemovalAllowed.putBoolean("booleanResult", false);
            if (Build.VERSION.SDK_INT >= 14) {
                new AsyncTaskC0999f(this).execute(new Void[0]);
            }
        } else {
            if (!C4809aa.m18104a().m18129b("uid")) {
                return accountRemovalAllowed;
            }
            AccountManager accountManager = AccountManager.get(this.f3257c);
            String userData = accountManager.getUserData(account, "skip_deregi");
            String userData2 = accountManager.getUserData(account, "req_email");
            if (C4904y.f17872b) {
                C4904y.m18639b(" skipDeregi : " + userData + " email : " + userData2, getClass().getSimpleName());
            }
            if (!TextUtils.isEmpty(userData)) {
                if (TextUtils.isEmpty(userData2)) {
                    userData2 = C4822an.m18254v();
                }
                C4859bx.m18385a(userData2, C4809aa.m18104a().m18121a("uid", ""), C4809aa.m18104a().m18129b("msisdn"));
                return accountRemovalAllowed;
            }
            if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
                this.f3259e = new C2095ba(this.f3256b);
                this.f3258d = C2093az.m9337a();
                m6049b();
                if (C4859bx.m18386a(this.f3257c) && this.f3261g.m1495d(this.f3257c)) {
                    if (C4859bx.m18388b(this.f3257c, this.f3261g) != 0) {
                        this.f3258d.mo9079b(this.f3255a);
                        this.f3255a.m18262a(30000);
                    }
                } else if (this.f3259e != null) {
                    this.f3260f = this.f3259e.m9349a(this.f3257c);
                } else {
                    this.f3260f = null;
                    this.f3256b.sendEmptyMessage(202);
                    C4904y.m18639b("onReceiveRemoveAccount : regControl is null.", ChatONAccountService.class.getSimpleName());
                }
            }
        }
        if (C4904y.f17871a && accountRemovalAllowed != null) {
            C4904y.m18646e("getAccountRemovalAllowed(): result = " + accountRemovalAllowed, getClass().getName());
        }
        return accountRemovalAllowed;
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
        C4904y.m18639b("onReceiveRemoveAccount" + z, ChatONAccountService.class.getSimpleName());
        this.f3258d.mo9079b(this.f3255a);
        this.f3255a.m18262a(30000);
    }
}
