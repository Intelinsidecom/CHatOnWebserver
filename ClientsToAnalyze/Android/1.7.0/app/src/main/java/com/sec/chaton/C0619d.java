package com.sec.chaton;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.sec.chaton.util.C1341p;
import java.io.IOException;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.d */
/* loaded from: classes.dex */
class C0619d implements AccountManagerCallback {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2170a;

    C0619d(HomeActivity homeActivity) {
        this.f2170a = homeActivity;
    }

    @Override // android.accounts.AccountManagerCallback
    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            try {
                ((Bundle) accountManagerFuture.getResult()).keySet();
                C1341p.m4660c("AddAccount was succeeded", getClass().getSimpleName());
            } catch (AuthenticatorException e) {
                C1341p.m4660c("AddAccount was Failed", getClass().getSimpleName());
            } catch (OperationCanceledException e2) {
                C1341p.m4660c("AddAccount was Canceled", getClass().getSimpleName());
                this.f2170a.finish();
            }
        } catch (IOException e3) {
            C1341p.m4660c("AddAccount was Failed", getClass().getSimpleName());
        }
    }
}
