package com.sec.chaton;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.sec.chaton.util.C1786r;
import java.io.IOException;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.w */
/* loaded from: classes.dex */
class C1796w implements AccountManagerCallback {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f6468a;

    C1796w(HomeActivity homeActivity) {
        this.f6468a = homeActivity;
    }

    @Override // android.accounts.AccountManagerCallback
    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            try {
                ((Bundle) accountManagerFuture.getResult()).keySet();
                C1786r.m6063c("AddAccount was succeeded", getClass().getSimpleName());
            } catch (AuthenticatorException e) {
                C1786r.m6063c("AddAccount was Failed", getClass().getSimpleName());
            } catch (OperationCanceledException e2) {
                C1786r.m6063c("AddAccount was Canceled", getClass().getSimpleName());
                this.f6468a.finish();
            }
        } catch (IOException e3) {
            C1786r.m6063c("AddAccount was Failed", getClass().getSimpleName());
        }
    }
}
