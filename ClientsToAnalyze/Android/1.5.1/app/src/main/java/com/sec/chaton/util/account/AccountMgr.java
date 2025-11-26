package com.sec.chaton.util.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncAdapterType;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AccountMgr {

    /* renamed from: a */
    public static AccountMgr f3760a;

    /* renamed from: b */
    public static AccountManager f3761b;

    /* renamed from: c */
    private HashMap f3762c = new HashMap();

    private AccountMgr(Context context) {
        AuthenticatorDescription authenticatorDescriptionM3688a;
        this.f3762c.clear();
        context.getContentResolver();
        SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
        AuthenticatorDescription[] authenticatorTypes = f3761b.getAuthenticatorTypes();
        for (SyncAdapterType syncAdapterType : syncAdapterTypes) {
            if ("com.android.contacts".equals(syncAdapterType.authority) && (authenticatorDescriptionM3688a = m3688a(authenticatorTypes, syncAdapterType.accountType)) != null) {
                AccountSource accountSource = new AccountSource(authenticatorDescriptionM3688a.packageName);
                accountSource.f3763a = authenticatorDescriptionM3688a.type;
                accountSource.f3766d = authenticatorDescriptionM3688a.labelId;
                accountSource.f3767e = authenticatorDescriptionM3688a.iconId;
                accountSource.f3768f = !syncAdapterType.supportsUploading();
                m3691a(accountSource);
            }
        }
    }

    /* renamed from: a */
    private static AuthenticatorDescription m3688a(AuthenticatorDescription[] authenticatorDescriptionArr, String str) {
        for (AuthenticatorDescription authenticatorDescription : authenticatorDescriptionArr) {
            if (str.equals(authenticatorDescription.type)) {
                return authenticatorDescription;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized AccountMgr m3689a(Context context) {
        if (f3760a == null) {
            f3761b = AccountManager.get(context);
            f3760a = new AccountMgr(context);
        }
        return f3760a;
    }

    /* renamed from: a */
    public ArrayList m3690a(Context context, boolean z) {
        Account[] accounts = f3761b.getAccounts();
        ArrayList arrayList = new ArrayList();
        for (Account account : accounts) {
            AccountSource accountSource = (AccountSource) this.f3762c.get(account.type);
            if (accountSource != null) {
                boolean z2 = !z || (z && !accountSource.f3768f);
                AccountData accountData = new AccountData(context, account.name, accountSource.f3763a, accountSource.f3764b, accountSource.f3766d, accountSource.f3767e);
                if (z2) {
                    arrayList.add(accountData);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected void m3691a(AccountSource accountSource) {
        this.f3762c.put(accountSource.f3763a, accountSource);
    }
}
